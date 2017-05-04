package com.example.rico.drumapp;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    private Display display;
    private SoundManager soundManager;
    private int crash, hat, hi_tom, kick, low_tom, mid_tom, ride, snare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        display = (Display) findViewById(R.id.display);
        soundManager = new SoundManager(this);
        crash = soundManager.addSound(R.raw.crash);
        hat = soundManager.addSound(R.raw.hat);
        hi_tom = soundManager.addSound(R.raw.hi_tom);
        kick = soundManager.addSound(R.raw.kick);
        low_tom = soundManager.addSound(R.raw.low_tom);
        mid_tom = soundManager.addSound(R.raw.mid_tom);
        ride = soundManager.addSound(R.raw.ride);
        snare = soundManager.addSound(R.raw.snare);
    }
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() != MotionEvent.ACTION_UP){
            return super.onTouchEvent(event);
        }
        Position position = display.getPosition(event.getX(), event.getY());

        switch (position){
            case CRASH_LEFT:
                soundManager.play(crash);
                break;
            case HI_TOM:
                soundManager.play(hi_tom);
                break;
            case MID_TOM:
                soundManager.play(mid_tom);
                break;
            case CRASH_RIGHT:
                soundManager.play(crash);
                break;
            case KICK:
                soundManager.play(kick);
                break;
            case HI_HAT:
                soundManager.play(hat);
                break;
            case SNARE:
                soundManager.play(snare);
                break;
            case LOW_TOM:
                soundManager.play(low_tom);
                break;
            case RIDE:
                soundManager.play(ride);
                break;
        }
        return super.onTouchEvent(event);
    }
}
