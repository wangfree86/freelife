package w.com.wk.freelife.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import w.com.wk.freelife.R;
import w.com.wk.freelife.adapter.SingleSelectAdapter;
import w.com.wk.freelife.ui.widget.WtMuseActivtiy;

//自定义dialog

public class SelectMusicDialog extends Dialog {

    Context context;
    @BindView(R.id.rc_time)
    RecyclerView mRcTime;
    public String[] musics = {"bell.mp3", "btnclick.mp3", "dalcoms_seawave.mp3", "sound1.ogg"};
    public int nowTime = 1;

    List<String> lc = new ArrayList<String>();
    public SelectMusicDialog(Context context) {
        super(context);
        this.context = context;
    }

    public SelectMusicDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.view_dialog);
        ButterKnife.bind(this);
        //创建默认的线性LayoutManager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(context);
        mRcTime.setLayoutManager(mLayoutManager);
//如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRcTime.setHasFixedSize(true);
//创建并设置Adapter

        //数组转成集合
        lc = Arrays.asList(musics);

        SingleSelectAdapter mAdapter = new SingleSelectAdapter(lc);
        mRcTime.setAdapter(mAdapter);
        //RecyclerView点击事件的实现 2、实现具体点击事件,接口传入到Adapter
        mAdapter.setItemOnClickListener(new SingleSelectAdapter.MyItemOnClickListener() {
            @Override
            public void onItemOnClick(View view, int postion) {
                nowTime = postion;
                WtMuseActivtiy w = (WtMuseActivtiy) context;
                w.setNTime(nowTime);
                dismiss();
            }
        });

    }


}