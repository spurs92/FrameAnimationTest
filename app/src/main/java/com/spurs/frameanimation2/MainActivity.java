package com.spurs.frameanimation2;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    AnimationDrawable aniDrawable;

    Drawable lastFrame;//애니메이션 drawable의 마지막 그림을 침조하는 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img=(ImageView) findViewById(R.id.img);
        aniDrawable=(AnimationDrawable)img.getDrawable();
        aniDrawable.start();
    }

    public void clickAttack(View v){

        if(aniDrawable.isRunning()) aniDrawable.stop();

        img.setImageResource(R.drawable.ani_attack);
        aniDrawable=(AnimationDrawable)img.getDrawable();
        aniDrawable.start();
    }

    public void clickJump(View v){
        if(aniDrawable.isRunning()){

            //현재 플레이 되고 있는 그림 얻어오기
           Drawable current=aniDrawable.getCurrent();

            //현재 그림과 마지막 그림이 일치하는가?
            if(lastFrame==current){ //같은 객체냐??(주소비교)
                //현재 그림이 마지막 그림과 같다면..
                //애니메이션이 끝났다라는 것을 의미
                aniDrawable.stop();
                img.setImageResource(R.drawable.ani_jump);
            }
        }

        aniDrawable=(AnimationDrawable)img.getDrawable();

        //이 aniDrawable이 가지고 있는 그림의 수
        int frameNum=aniDrawable.getNumberOfFrames();
        //마지막 그림 얻어오기
        lastFrame= aniDrawable.getFrame(frameNum-1);

        aniDrawable.start();

    }

    public void clickRun(View v){
        if(aniDrawable.isRunning()) aniDrawable.stop();

        img.setImageResource(R.drawable.ani_run);
        aniDrawable=(AnimationDrawable)img.getDrawable();
        aniDrawable.start();

    }
}
