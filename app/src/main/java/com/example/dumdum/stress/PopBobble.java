package com.example.dumdum.stress;


import android.app.Activity;
import android.os.Bundle;

public class PopBobble extends Activity{

//Draw directly to the canvas trough surfaceview

    CanvasPop pop_LayoutView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pop_LayoutView = new CanvasPop(this);
        setContentView(pop_LayoutView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        pop_LayoutView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        pop_LayoutView.resume();
    }
}
