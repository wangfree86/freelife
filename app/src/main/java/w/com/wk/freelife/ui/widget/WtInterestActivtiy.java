package w.com.wk.freelife.ui.widget;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import w.com.wk.freelife.R;
import w.com.wk.freelife.adapter.CommonAdapter;
import w.com.wk.freelife.adapter.CountAdapter;
import w.com.wk.freelife.base.BaseActivity;
import w.com.wk.freelife.base.BaseFragment;
import w.com.wk.freelife.bean.Common;

/**
 * @author WK
 * @version 1.0.0
 * @desc:复利计算器
 * @2017年2月15日18:24:18
 */
public class WtInterestActivtiy extends BaseActivity {

    @BindView(R.id.et_money)
    EditText mEtMoney;
    @BindView(R.id.et_per)
    EditText mEtPer;
    @BindView(R.id.et_year)
    EditText mEtYear;

    @BindView(R.id.bt)
    Button mBt;
    @BindView(R.id.my_recycler_view)
    RecyclerView mRecyclerView;

    CommonAdapter mCommonAdapter;
    List<Common> lc = new ArrayList<Common>();
    int y;
    int m;
    double newm;
    double per;



    @Override
    protected void initView() {
        setContentView(R.layout.fragment_widget_interest);
        ButterKnife.bind(this);
        //创建默认的线性LayoutManager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(context);
        mRecyclerView.setLayoutManager(mLayoutManager);
//如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true);
//创建并设置Adapter
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {

    }

    @OnClick(R.id.bt)
    public void onClick() {
        lc.clear();
        y = new Integer(mEtYear.getText().toString());
        m = new Integer(mEtMoney.getText().toString());
        per = new Double(mEtPer.getText().toString()) / 100 + 1;

        newm = per * m;
        DecimalFormat df = new DecimalFormat("0.0000");


        for (int i = 1; i <= y; i++) {
            Common c = new Common();
            c.y = i + "";
            String strnewm = df.format(newm);
            c.m = strnewm;
            lc.add(c);
            newm = newm * per;
        }
        CountAdapter mAdapter = new CountAdapter(lc);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new CountAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                showToast("ere");
            }
        });
    }
}
