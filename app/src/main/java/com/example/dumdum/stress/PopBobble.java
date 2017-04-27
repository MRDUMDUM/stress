package com.example.dumdum.stress;


import android.app.Activity;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;



public class PopBobble extends Activity{

//Draw directly to the canvas trough surfaceview

    private CanvasPop canvasPop;

    public SoundPool popSoundPool;
    public SoundPool.Builder popBuilder;

    public AudioAttributes attributes;
    public AudioAttributes.Builder attributesBuilder;

    public int soundID_pop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        canvasPop = new CanvasPop(this);
        setContentView(canvasPop);

        attributesBuilder = new AudioAttributes.Builder();
        attributesBuilder.setUsage(AudioAttributes. USAGE_GAME);
        attributesBuilder.setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION);
        attributes = attributesBuilder.build();

        popBuilder = new SoundPool.Builder();
        popBuilder.setAudioAttributes(attributes);
        popSoundPool = popBuilder.build();

        soundID_pop = popSoundPool.load(this, R.raw.pop, 1);

    }



    @Override
    protected void onPause() {
        super.onPause();
        canvasPop.pause();

        popSoundPool.release();
    }

    @Override
    protected void onResume() {
        super.onResume();
        canvasPop.resume();
    }
}
