package com.example.mytravelmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    Button letsgo;
    TextView welcometo, name, travelright;
    ImageView wimage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        letsgo=findViewById(R.id.letsgobutton);

        letsgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Welcome.this,Discover.class);
                startActivity(intent);


            }
        });
        TextView welcometoTextView = findViewById(R.id.wwelcome);
        TextView nameTextView = findViewById(R.id.wmytravel);
        TextView travelrightTextView = findViewById(R.id.wtravelright);

        AnimationSet animationSet = new AnimationSet(true);

        Animation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(3000);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setStartOffset(1500);

        Animation translateAnimation = new TranslateAnimation(0, 0, 50, 0);
        translateAnimation.setDuration(1500);
        translateAnimation.setInterpolator(new DecelerateInterpolator());

        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);

        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                welcometoTextView.setVisibility(View.VISIBLE);
                nameTextView.setVisibility(View.VISIBLE);
                travelrightTextView.setVisibility(View.VISIBLE);
                letsgo.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        letsgo.setVisibility(View.VISIBLE);
                    }
                }, 500); // Delay the button display by 500 milliseconds (0.5 seconds)
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // Do nothing
            }
        });

        welcometoTextView.startAnimation(animationSet);
        nameTextView.startAnimation(animationSet);
        travelrightTextView.startAnimation(animationSet);



    }
}