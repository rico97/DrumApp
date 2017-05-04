package com.example.rico.drumapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;


public class Display extends View {
    private Paint paint;
    private Random random;
    public Display(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        random = new Random();
        setBackground(getResources().getDrawable(R.drawable.bg));
    }

    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        setBackgroundColor(Color.rgb(red,green,blue));

        return super.onTouchEvent(event);
    }*/

    private PointF getCenter() {
        return new PointF(getWidth()/2f,getHeight()/2f);
    }

    private PointF getSpecialPoint() {
        return new PointF(getWidth()/5f,getHeight()/2f);
    }

    public Position getPosition(float x, float y){
        PointF center = getCenter();
        if(x<getSpecialPoint().x && y <center.y){
            return Position.CRASH_LEFT;
        }else if (x<getSpecialPoint().x*2 && x>getSpecialPoint().x && y<center.y){
            return  Position.HI_TOM;
        }else if (x<getSpecialPoint().x*4 && x>getSpecialPoint().x*3 && y<center.y){
            return  Position.MID_TOM;
        }else if (x<getSpecialPoint().x*5 && x>getSpecialPoint().x*4 && y<center.y){
            return  Position.CRASH_RIGHT;
        }else if (x<getSpecialPoint().x && y >center.y){
            return  Position.HI_HAT;
        }else if (x<getSpecialPoint().x*2 && x>getSpecialPoint().x && y>center.y){
            return  Position.SNARE;
        }else if (x<getSpecialPoint().x*4 && x>getSpecialPoint().x*3 && y>center.y){
            return  Position.LOW_TOM;
        }else if (x<getSpecialPoint().x*5 && x>getSpecialPoint().x*4 && y>center.y) {
            return Position.RIDE;
        }
        else {
            return  Position.KICK;
        }
    }

    /*
    public void setMessage(String message){
        this.message = message;
        invalidate();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        Drawable backgroundPic = getContext().getDrawable(R.drawable.bg);
        backgroundPic.setBounds(0,0,getWidth(),getHeight());
        PointF center = getCenter();
        backgroundPic.draw(canvas);
    }*/
}
