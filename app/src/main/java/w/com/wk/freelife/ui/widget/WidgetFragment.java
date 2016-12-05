package w.com.wk.freelife.ui.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import w.com.wk.freelife.R;
import w.com.wk.freelife.base.BaseFragment;

/**
 * @author WK
 * @version 1.0.0
 * @desc:
 * @2016-12-05:12:29
 */
public class WidgetFragment extends BaseFragment {

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_home, null);

        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {

    }
}
