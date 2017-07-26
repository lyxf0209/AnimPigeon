package test.com.animpigeon;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private AnimationDrawable anim;
    private Button button1;
    private  Button button2;
    private boolean isRotating;

//    private void iv_setlocal(ImageView iv,int value) {
//        iv.setPadding(iv.getPaddingLeft() + value, iv.getPaddingTop() + value,
//                iv.getPaddingRight(), iv.getPaddingBottom());
//// 固定第一次动画结束后图片的位置
//    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=(Button)findViewById(R.id.start);
        button2=(Button)findViewById(R.id.stop);
        final ImageView iv=(ImageView)findViewById(R.id.ImgDance);	//获取要应用动画效果的ImageView
        final Animation translateright=AnimationUtils.loadAnimation(this, R.anim.translateright);	//获取“向右飞”的动画资源
        final Animation translateleft=AnimationUtils.loadAnimation(this, R.anim.translateleft);	//获取“向左飞”的动画资源
        final Animation translateup=AnimationUtils.loadAnimation(this, R.anim.translateup);	//获取“向上飞”的动画资源
        final Animation translatedown=AnimationUtils.loadAnimation(this, R.anim.translatedown);	//获取“向下飞”的动画资源

        anim=(AnimationDrawable)iv.getBackground();//获取应用的帧动画

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                anim.start();	//开始播放帧动画
                isRotating=true;
                iv.startAnimation(translatedown);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                anim.stop();	//开始播放帧动画
                isRotating=false;
                iv.clearAnimation();
            }
        });



        translatedown.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationRepeat(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                if(isRotating) {
                    iv.setBackgroundResource(R.drawable.fly2);    //重新设置ImageView应用的帧动画
                    iv.startAnimation(translateright);        //播放“向左奔跑”的动画
                    anim = (AnimationDrawable) iv.getBackground();//获取应用的帧动画
                    anim.start();    //开始播放帧动画
                }
            }
        });

        translateright.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationRepeat(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                if(isRotating) {
                    iv.setBackgroundResource(R.drawable.fly2);    //重新设置ImageView应用的帧动画
                    iv.startAnimation(translateup);    //播放“向右奔跑”的动画
                    anim = (AnimationDrawable) iv.getBackground();//获取应用的帧动画
                    anim.start();    //开始播放帧动画
                }
            }
        });

        translateup.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationRepeat(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                if(isRotating) {
                    iv.setBackgroundResource(R.drawable.fly);    //重新设置ImageView应用的帧动画
                    iv.startAnimation(translateleft);        //播放“向左奔跑”的动画
                    anim = (AnimationDrawable) iv.getBackground();//获取应用的帧动画
                    anim.start();    //开始播放帧动画
                }
            }
        });

        translateleft.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationRepeat(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                if(isRotating) {
                    iv.setBackgroundResource(R.drawable.fly);    //重新设置ImageView应用的帧动画
                    iv.startAnimation(translatedown);        //播放“向左奔跑”的动画
                    anim = (AnimationDrawable) iv.getBackground();//获取应用的帧动画
                    anim.start();    //开始播放帧动画
                }
            }
        });


    }
}
