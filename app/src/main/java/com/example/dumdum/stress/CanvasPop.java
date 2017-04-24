package com.example.dumdum.stress;



import android.content.Context;
import android.view.SurfaceView;


public class CanvasPop extends SurfaceView implements Runnable{

    Thread theread = null;
    boolean canDraw = false;

    public CanvasPop(Context context){
        super(context);
    }

    @Override
    public void run() {
        while (canDraw){
            //can draw the bobbles

        }
    }


    public void pause(){
        canDraw = false;

        while (true){
            try {
                theread.join();
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        theread = null;

    }

    public void resume(){
        canDraw = true;
        theread = new Thread(this);
        theread.start();
    }
}
