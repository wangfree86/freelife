package w.com.wk.freelife.ui.widget;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import w.com.wk.freelife.CommonAdapter;
import w.com.wk.freelife.R;
import w.com.wk.freelife.base.BaseFragment;
import w.com.wk.freelife.bean.Common;

/**
 * @author WK
 * @version 1.0.0
 * @desc:
 * @2016-12-05:12:29
 */
public class WidgetFragment extends BaseFragment {

    @BindView(R.id.et_money)
    EditText mEtMoney;
    @BindView(R.id.et_per)
    EditText mEtPer;
    @BindView(R.id.et_year)
    EditText mEtYear;
    @BindView(R.id.lv_all)
    ListView mLvAll;
    @BindView(R.id.bt)
    Button mBt;

    CommonAdapter mCommonAdapter;
    List<Common> lc = new ArrayList<Common>();
    int y;
    int m;
    double newm;
    double per;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View rootView = inflater.inflate(R.layout.fragment_widget, null);
        ButterKnife.bind(this, rootView);
        return rootView;
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
        mCommonAdapter = new CommonAdapter(context, lc);
        mLvAll.setAdapter(mCommonAdapter);

    }


}
