package com.example.dumdum.stress;



import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;



import java.util.Random;


public class CanvasPop extends SurfaceView implements Runnable{



    public Thread thread = null;
    public boolean canDraw = false;


    public Bitmap backGroundSand;
    public Bitmap bobble;
    public Bitmap newBobble;
    public Canvas canvasPop;
    public SurfaceHolder surfaceHolder;


    public Random randomlocation = new Random();
    public int circle_x,circle_y;

    public int newWidth = 300;
    public int newHeight = 300;




    public CanvasPop(Context context){
        super(context);
        surfaceHolder = getHolder();
        backGroundSand = BitmapFactory.decodeResource(getResources(),R.drawable.sand);
        bobble = BitmapFactory.decodeResource(getResources(),R.drawable.circle);
        newBobble = Bitmap.createScaledBitmap(bobble,newWidth,newHeight,false);
        circle_x = 200;
        circle_y = 100;
        BiggerBobble();

    }


    @Override
    public void run() {


        while (canDraw){
            //can draw the bobbles and the canvas
            if(!surfaceHolder.getSurface().isValid()){
                continue;

            }
            canvasPop = surfaceHolder.lockCanvas();
            canvasPop.drawBitmap(backGroundSand,0,0,null);

            //bobbles
            canvasPop.drawBitmap(newBobble,circle_x,circle_y,null);

            surfaceHolder.unlockCanvasAndPost(canvasPop);
        }
    }


    public void pause(){
        canDraw = false;

        while (true){
            try {
                thread.join();
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        thread = null;

    }


    public void resume(){
        canDraw = true;
        thread = new Thread(this);
        thread.start();
    }


    private void BiggerBobble(){

        if(newWidth <= 500 && newHeight <= 500){

            newWidth ++;
            newHeight ++;
        }


    }

    private void RandomLocation(){


        if(circle_x < canvasPop.getWidth()){

            circle_x = randomlocation.nextInt(500);
        }
        else {
            circle_x = 0;
        }
        if(circle_y <canvasPop.getHeight()){
            circle_y = randomlocation.nextInt(800);
        }
        else{
            circle_y = 0;
        }


    }

    public boolean onTouchEvent(MotionEvent event){
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(x>= circle_x && x < (circle_x + bobble.getWidth()) && y >= circle_y && y <(circle_y + bobble.getHeight())) {
                    newWidth = 100;
                    newHeight = 100;
                    RandomLocation();

                }
                break;
        }

        return true;
    }

}
