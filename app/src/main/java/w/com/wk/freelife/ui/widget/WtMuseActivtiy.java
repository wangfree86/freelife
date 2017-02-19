package w.com.wk.freelife.ui.widget;


import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import w.com.wk.freelife.R;
import w.com.wk.freelife.base.BaseActivity;
import w.com.wk.freelife.view.MViewOne;
import w.com.wk.freelife.view.SelectTimeDialog;
import w.com.wk.freelife.view.SelectMusicDialog;


public class WtMuseActivtiy extends BaseActivity {
    MediaPlayer mediaPlayer;
    @BindView(R.id.start)
    Button mStart;
    @BindView(R.id.stop)
    Button mStop;
    @BindView(R.id.time)
    EditText mTime;
    @BindView(R.id.view_arc)
    MViewOne mViewArc;
    @BindView(R.id.select_time)
    Button mSelectTime;
    int selectMusic = 0;
    @BindView(R.id.select_music)
    Button mSelectMusic;
    private AssetManager mAssets;
    //sound1.ogg
//MUSIC
    //测试用的音乐文件
    public String[] musics = {"bell.mp3", "btnclick.mp3", "dalcoms_seawave.mp3", "sound1.ogg"};
    //    public static final String MUSIC = "dalcoms_seawave.mp3";
    //播放的总时常秒
    public int playerAllTime = 10 * 60;
    public int alltime = 0;
    public int duration;
    private int showtime = 0;
    private boolean isPlayer = false;

    @Override
    protected void initData() {
        String s = mTime.getText().toString();
        mTime.setSelection(s.length());
//        mTime.setCursorVisible(false);
    }

    Handler handler = new Handler();
    //只是刷新自定义view,MediaPlayer
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (isPlayer && playerAllTime > showtime) {
                //开启计时器
                showtime++;
                handler.postDelayed(this, 1000);
                float p = (float) showtime / (float) playerAllTime;
                mViewArc.setProgress(p, showtime);
            } else {
                showtime = 0;
                mViewArc.setProgress(0, 0);
            }

        }
    };

    @Override
    protected void initView() {
        setContentView(R.layout.widget_muse);
        ButterKnife.bind(this);


    }

    //播放器资源的准备工作
    private void initMediaPlayer() {
        try {
            //获取音乐文件
            mAssets = this.getAssets();
            AssetFileDescriptor fileDescriptor = mAssets.openFd(musics[selectMusic]);
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

//        //文件时长 mils 毫秒，我们需要自行转换为所需的显示格式
//        duration = mediaPlayer.getDuration();
////当前播放时间 单位同上
//        mediaPlayer.getCurrentPosition();

        //监听播放结束,循环播放
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                                @Override
                                                public void onCompletion(MediaPlayer mp) {
                                                    if (!mediaPlayer.isPlaying()) {
                                                        showToast("test" + showtime);
                                                        mediaPlayer.start();
                                                    } else {

                                                    }

                                                }
                                            }

        );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    @OnClick({R.id.start, R.id.stop, R.id.time, R.id.select_time, R.id.select_music})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:
                isPlayer = true;
                initMediaPlayer();
                if (!mediaPlayer.isPlaying()) {
                    String s = mTime.getText().toString();
                    playerAllTime = Integer.parseInt(s) * 60;
                    //播放
                    mediaPlayer.start();
                    //开启计时器
                    handler.postDelayed(runnable, 1000);
                }
                break;
            case R.id.stop:
                isPlayer = false;
                if (mediaPlayer != null&&mediaPlayer.isPlaying()) {

                    mediaPlayer.reset();
                    initMediaPlayer();
//
                }


                break;
            case R.id.select_time:
                //初始化一个自定义的Dialog
                SelectTimeDialog dialog = new SelectTimeDialog(context);

                dialog.show();
                break;
            case R.id.select_music:
                //初始化一个自定义的Dialog
                SelectMusicDialog dialog1 = new SelectMusicDialog(context);
                dialog1.show();
                break;
        }
    }

    public void setNTime(String nowTime) {
        mTime.setText(nowTime);
    }

    public void setNTime(int selectMusic) {

        this.selectMusic = selectMusic;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }


}