package com.example.dumdum.stress;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;




public class DrawTheLine extends Activity {

    public Button bac_button;
    public Button spi_button;
    public Button inf_button;
    public Button hea_button;




    public void init() {
        bac_button = (Button) findViewById(R.id.bac_button);
        bac_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent draw = new Intent(DrawTheLine.this, MainActivity.class);
                startActivity(draw);

            }
        }  );
        spi_button = (Button) findViewById(R.id.spi_button);
        spi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent draw = new Intent(DrawTheLine.this, SpiralLine.class);
                startActivity(draw);
            }
        });
        inf_button = (Button) findViewById(R.id.inf_button);
        inf_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent draw = new Intent(DrawTheLine.this, InfinityLine.class);
                startActivity(draw);
            }
        });
        hea_button = (Button) findViewById(R.id.hea_button);
        hea_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent draw = new Intent(DrawTheLine.this, HeartLine.class);
                startActivity(draw);
            }
        });


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawtheline);
        init();
    }



}