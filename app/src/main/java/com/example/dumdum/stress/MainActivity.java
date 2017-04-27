package com.example.dumdum.stress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button but1;
    public Button but2;

        //goes to draw the line game
        public void init(){
            but1= (Button)findViewById(R.id.but1);
            but2= (Button)findViewById(R.id.but2);

            but1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent draw = new Intent(MainActivity.this,DrawTheLine.class);
                    startActivity(draw);
                }
            });
            but2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent draw = new Intent(MainActivity.this,PopBobble.class);
                    startActivity(draw);
                }
            });


        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
}