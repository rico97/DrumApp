package com.example.rico.drumapp;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import android.view.View;

public class Display extends View {
    public Display(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackground(ContextCompat.getDrawable(context,R.drawable.bg));
    }

    private PointF getSpecialPoint() {
        return new PointF(getWidth()/5f,getHeight()/2f);
    }

    public Position getPosition(float x, float y){
        if(x<getSpecialPoint().x && y <getSpecialPoint().y){
            return Position.CRASH_LEFT;
        }else if (x<getSpecialPoint().x*2 && x>getSpecialPoint().x && y<getSpecialPoint().y){
            return  Position.HI_TOM;
        }else if (x<getSpecialPoint().x*4 && x>getSpecialPoint().x*3 && y<getSpecialPoint().y){
            return  Position.MID_TOM;
        }else if (x<getSpecialPoint().x*5 && x>getSpecialPoint().x*4 && y<getSpecialPoint().y){
            return  Position.CRASH_RIGHT;
        }else if (x<getSpecialPoint().x && y >getSpecialPoint().y){
            return  Position.HI_HAT;
        }else if (x<getSpecialPoint().x*2 && x>getSpecialPoint().x && y>getSpecialPoint().y){
            return  Position.SNARE;
        }else if (x<getSpecialPoint().x*4 && x>getSpecialPoint().x*3 && y>getSpecialPoint().y){
            return  Position.LOW_TOM;
        }else if (x<getSpecialPoint().x*5 && x>getSpecialPoint().x*4 && y>getSpecialPoint().y) {
            return Position.RIDE;
        }
        else {
            return  Position.KICK;
        }
    }
}
