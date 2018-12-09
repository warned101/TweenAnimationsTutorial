package sriyank.com.viewanimation;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements Animation.AnimationListener{

    private ImageView mImageView;

    private Animation rotateAnimation;
    private Animation scaleAnimation;
    private Animation alphaAnimation;
    private Animation translateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.football);

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Image Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }




    public void scaleAnimation(View view) {

        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
        scaleAnimation.setAnimationListener(this);
        mImageView.startAnimation(scaleAnimation);
    }

    public void translateAnimation(View view) {

        translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate_anim);
        translateAnimation.setAnimationListener(this);
        mImageView.startAnimation(translateAnimation);
    }

    public void alphaAnimation(View view) {
        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
        alphaAnimation.setAnimationListener(this);
        mImageView.startAnimation(alphaAnimation);
    }

    public void rotateAnimation(View view) {

        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        rotateAnimation.setAnimationListener(this);
        mImageView.startAnimation(rotateAnimation);
    }





    @Override
    public void onAnimationStart(Animation animation) {

        if(animation == rotateAnimation){
            Toast.makeText(MainActivity.this, "Rotation Started", Toast.LENGTH_SHORT).show();
        }

        if(animation == scaleAnimation) {
            Toast.makeText(MainActivity.this, "Scale Started", Toast.LENGTH_SHORT).show();
        }
        if(animation == translateAnimation) {
            Toast.makeText(MainActivity.this, "Translate Started", Toast.LENGTH_SHORT).show();
        }
        if(animation == alphaAnimation) {
            Toast.makeText(MainActivity.this, "Alpha Started", Toast.LENGTH_SHORT).show();
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
