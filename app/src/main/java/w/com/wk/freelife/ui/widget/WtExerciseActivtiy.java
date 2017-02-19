package w.com.wk.freelife.ui.widget;


import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import w.com.wk.freelife.R;
import w.com.wk.freelife.base.BaseActivity;
import w.com.wk.freelife.view.MViewOne;


public class WtExerciseActivtiy extends BaseActivity {
    MediaPlayer mediaPlayer;
    @BindView(R.id.iv_exercise)
    ImageView mIvExercise;
    @BindView(R.id.desc)
    TextView mDesc;
    @BindView(R.id.start)
    Button mStart;
    @BindView(R.id.stop)
    Button mStop;
    @BindView(R.id.view_arc)
    MViewOne mViewArc;
    public String[] title = {"1两手对搓一分钟——缓解肩痛",
            "手指摩头一分钟——头发健康",
            "轻揉耳轮一分钟——缓解耳鸣目眩",
            "转动眼睛一分钟——提神醒目",
            "拇指揉鼻一分钟——缓解感冒",
            "叩齿卷舌一分钟——牙齿保健",
            "轻按肚脐一分钟——促进消化",
            "收腹提肛一分钟——促进血液循环",
            "伸屈四肢一分钟——缓解心脑血管疾病",
            "蹬摩脚心一分钟——清肝明目"};

    //a.jpeg
    public String[] des = {"手掌快速对搓300次，刺激手掌的经络穴位可调和阴阳之气，可缓解肩痛、眼睛疲劳。",
            "手指由前额深摩头顶至脑后，以每秒2-4次的速度，促进脑部血液回流，使发根得到充分营养。",
            "双手指轻揉左右耳轮至热，舒适为止，有通经散热、保健听力的作用，尤其对耳鸣、目眩有缓解功效。",
            "眼球顺时针和逆时针各转动30次，可提神醒目，有强化眼肌、防治慢性角膜炎和近视眼等功能。",
            "双手拇指上下揉鼻50次，可祛风雍塞，开肺窍，对感冒、上呼吸道感染、支气管炎有缓解功效。",
            "轻叩牙齿，可使牙根和牙龈活血，卷舌可使舌活动自如，增加其灵敏度。\n",
            "用双手掌心交替顺时针揉摩肚脐，可通畅胃肠之气，促进消化吸收。",
            "反复收缩，使肛门上提，可增强肛门括约肌的收缩力，促进血液循环。",
            "仰卧时血流缓慢，血液存留四肢过多，通过伸屈运动，使血液迅速回流，供给心脑系统足够的氧与血。",
            "仰卧以双足跟交替蹬摩脚心，可引导肾脏虚火及上身浊气下降，并能清肝明目，对治疗神经衰弱、失眠、耳鸣等均有疗效。"};
    public int[] pic = {R.mipmap.a, R.mipmap.b, R.mipmap.c, R.mipmap.d, R.mipmap.e, R.mipmap.f, R.mipmap.g, R.mipmap.h, R.mipmap.i, R.mipmap.j};
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.ll_bg)
    LinearLayout mLlBg;
    private AssetManager mAssets;

    public static final String MUSIC = "sound78.ogg";
    //播放的总时常秒
    public int playerAllTime = 50;
    private int showtime = 0;
    private boolean isPlayer = false;
    private int allCount = 0;

    @Override
    protected void initData() {
    }

    Handler handler = new Handler();
    //60秒一周,播放一次音乐
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (isPlayer) {
                //60秒跑完了或者低0秒
                if (!mediaPlayer.isPlaying()) {
                    if (playerAllTime == showtime && allCount < 9) {
                        // mediaPlayer.start();
                        showtime = 0;

                        allCount++;
                        setData();
                        mediaPlayer.start();
                    } else if (showtime == 0) {
                          mediaPlayer.start();
                    }
                }

                //开启计时器
                showtime++;
                handler.postDelayed(this, 1000);
                float p = (float) showtime / (float) playerAllTime;
                mViewArc.setProgress(p, showtime);


            }

        }
    };

    private void setData() {
        Glide.with(context)
                .load(pic[allCount])
                .into(mIvExercise);
        mTitle.setText(title[allCount]);
        mDesc.setText(des[allCount]);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.widget_exercise);
        ButterKnife.bind(this);
        initMediaPlayer();
        setData();
//        Glide.with(context)
//                .load(pic[allCount])
//                .into(mLlBg);

    }

    //播放器资源的准备工作
    private void initMediaPlayer() {
        try {
            //获取音乐文件
            mAssets = this.getAssets();
            AssetFileDescriptor fileDescriptor = mAssets.openFd(MUSIC);
            //获取到播放类
            mediaPlayer = new MediaPlayer();
            //配置数据源
            mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(),
                    fileDescriptor.getStartOffset(),
                    fileDescriptor.getLength());
            //准备
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    @OnClick({R.id.start, R.id.stop})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:
                isPlayer = true;
                handler.postDelayed(runnable, 1000);
                break;
            case R.id.stop:
                isPlayer = false;
                mViewArc.setProgress(0, 0);
//                if (mediaPlayer != null) {
//                    mediaPlayer.stop();
//                    mediaPlayer.release();
//                }


                break;

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


}