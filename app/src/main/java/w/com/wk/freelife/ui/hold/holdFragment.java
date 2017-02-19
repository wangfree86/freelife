package w.com.wk.freelife.ui.hold;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import w.com.wk.freelife.adapter.CommonAdapter;
import w.com.wk.freelife.R;
import w.com.wk.freelife.base.BaseFragment;
import w.com.wk.freelife.bean.Common;
import w.com.wk.freelife.db.ListAll;

/**
 * @author WK
 * @version 1.0.0
 * @desc:
 * @2016-12-05:12:29
 */
public class HoldFragment extends BaseFragment {


    @BindView(R.id.name)
    TextView mKind;
    @BindView(R.id.time)
    TextView mTime;
    @BindView(R.id.add)
    ImageView mAdd;
    @BindView(R.id.lv)
    ListView mLv;
    List<Common> lc = new ArrayList<Common>();
    CommonAdapter mCommonAdapter;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {

        View rootView = inflater.inflate(R.layout.fragment_hold, null);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected void initData() {
        RefData();
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putLong("allid", lc.get(i).id);
                intent2Activity(ListDetailActivtiy.class, bundle);
            }


        });

    }

    private void RefData() {
        lc.clear();
        List<ListAll> lis = new Select().from(ListAll.class).queryList();
        for (int i = 0; i < lis.size(); i++) {
            ListAll l = lis.get(i);
            Common c = new Common();
            c.y = l.time + "";
            c.m = l.name;
            c.id = l.id ;
            lc.add(c);
        }
        mCommonAdapter = new CommonAdapter(context, lc);
        mCommonAdapter.setAllList(true);
        mLv.setAdapter(mCommonAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        RefData();
    }

    @OnClick({R.id.name, R.id.time, R.id.add})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.name:
                RefData();
                break;
            case R.id.time:
                RefData();
                break;
            case R.id.add:
                intent2Activity(NewListActivtiy.class);
                break;
        }
    }
}
