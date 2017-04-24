package com.example.dumdum.stress;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SpiralLine extends Activity {

    private CanvasDraw canvasDraw;
    public Button bac_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawline_spiral);

        canvasDraw = (CanvasDraw) findViewById(R.id.canvas);
        ImageView spiralImageView = (ImageView) findViewById(R.id.imageView_spiral);
        spiralImageView.setImageResource(R.drawable.spiral);
        init();
    }

    public void clearCanvas(View v){
        canvasDraw.clearCanvas();
    }

    public void init() {
        bac_button = (Button) findViewById(R.id.bac_button);
        bac_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent draw = new Intent(SpiralLine.this, DrawTheLine.class);
                startActivity(draw);
            }
        });
    }
}
