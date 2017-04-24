package com.example.dumdum.stress;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class InfinityLine extends Activity {

    private CanvasDraw canvasDraw;
    public Button bac_button;

    public void init() {
        bac_button = (Button) findViewById(R.id.bac_button);
        bac_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent draw = new Intent(InfinityLine.this, DrawTheLine.class);
                startActivity(draw);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawline_infinity);

        canvasDraw = (CanvasDraw) findViewById(R.id.canvas);
        ImageView infinityImageView = (ImageView) findViewById(R.id.imageView_infinity);
        infinityImageView.setImageResource(R.drawable.infinity);
        init();
    }

    public void clearCanvas(View v){
        canvasDraw.clearCanvas();
    }

}
