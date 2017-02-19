package w.com.wk.freelife.ui.widget;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import w.com.wk.freelife.R;
import w.com.wk.freelife.base.BaseFragment;

/**
 * @author WK
 * @version 1.0.0
 * @desc:
 * @2016-12-05:12:29
 */
public class WidgetFragment extends BaseFragment {

    @BindView(R.id.bt_think)
    Button bt_think;
    @BindView(R.id.bt_interest)
    Button bt_interest;
    @BindView(R.id.bt_music)
    Button bt_music; @BindView(R.id.bt_exercise)
    Button bt_exercise;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View rootView = inflater.inflate(R.layout.fragment_widget, null);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.bt_interest, R.id.bt_think, R.id.bt_music, R.id.bt_exercise})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_interest:
                intent2Activity(WtInterestActivtiy.class);
                break;
            case R.id.bt_think:
                intent2Activity(WtTestActivtiy.class);
            case R.id.bt_music:
                intent2Activity(WtMuseActivtiy.class);
                break; case R.id.bt_exercise:
                intent2Activity(WtExerciseActivtiy.class);
                break;

        }
    }


}
