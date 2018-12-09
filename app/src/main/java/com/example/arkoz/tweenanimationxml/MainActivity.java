package com.example.arkoz.tweenanimationxml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    private ImageView mImageView;

    private Button b1, b2, b3, b4;

    //Initializing animation variables
    private Animation mRotateAnim;
    private Animation mScaleAnim;
    private Animation mTranslateAnim;
    private Animation mAlphaAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.face);
        b1 = findViewById(R.id.rot);
        b2 = findViewById(R.id.sca);
        b3 = findViewById(R.id.tra);
        b4 = findViewById(R.id.button);

        //OnClickListener to perform animations on
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast to confirm Image presence
                Toast.makeText(MainActivity.this, "Image Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        //Button for rotate animation
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateAnimation(v);
            }
        });

        //Button for scale animation
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scaleAnimation(v);
            }
        });

        //Button for translate animation
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translateAnimation(v);
            }
        });

        //Button for alpha animation
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alphaAnimation(v);
            }
        });

    }



    public void scaleAnimation(View view) {

        //Constructor that takes 6 arguments
        mScaleAnim = new ScaleAnimation(
                1.0f, 2.0f,
                1.0f, 2.0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f   //As the case of PivotY in xml

        );
        mScaleAnim.setDuration(2000); //To set duration...
        mScaleAnim.setAnimationListener(this);
        mImageView.startAnimation(mScaleAnim);


    }

    public void translateAnimation(View view) {
        //Constructor that takes 4 arguments: from X, to X, from Y, to Y in float
        mTranslateAnim = new TranslateAnimation(

                Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 300f


        );
        mTranslateAnim.setDuration(2000);
        mTranslateAnim.setAnimationListener(this);
        mImageView.startAnimation(mTranslateAnim);


    }

    public void alphaAnimation(View view){
        //Constructor that takes 2 arguments: fromAlpha, toAlpha
        mAlphaAnim = new AlphaAnimation(1.0f, 0.0f);
        mAlphaAnim.setDuration(2000);
        mAlphaAnim.setAnimationListener(this);
        mImageView.startAnimation(mAlphaAnim);


    }

    public void rotateAnimation(View view) {
        //Constructor that takes 4 arguments: from Degree, to Degree, float XPivot, float Y pivot
        mRotateAnim = new RotateAnimation(
                0.0f, -200f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        mRotateAnim.setDuration(2000);
        mRotateAnim.setRepeatMode(Animation.REVERSE);
        mRotateAnim.setRepeatCount(2);
        mRotateAnim.setAnimationListener(this);
        mImageView.startAnimation(mRotateAnim);


    }






    @Override
    public void onAnimationStart(Animation animation) {

        if(animation == mScaleAnim) {
            Toast.makeText(MainActivity.this, "Scale Animation Started ", Toast.LENGTH_SHORT).show();
        }

        if(animation == mRotateAnim){
            Toast.makeText(MainActivity.this, "Rotate Animation Started ", Toast.LENGTH_SHORT).show();
        }

        if(animation == mTranslateAnim){
            Toast.makeText(MainActivity.this, "Translate Animation Started ", Toast.LENGTH_SHORT).show();
        }

        if(animation == mAlphaAnim){
            Toast.makeText(MainActivity.this, "Alpha Animation Started ", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Toast.makeText(MainActivity.this, "Ended", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        Toast.makeText(MainActivity.this, "Repeated", Toast.LENGTH_SHORT).show();

    }


}
