package w.com.wk.freelife.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import w.com.wk.freelife.R;


public abstract class BaseFragment extends Fragment implements OnClickListener {

    protected Context context;


    protected String TAG;


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = initView(inflater, container);

        TAG = this.getClass().getSimpleName();

        // 初始化所有请求都有的参数
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        LajinApplication.getRefWatcher(getActivity()).watch(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // try {
        initData();
//		 } catch (Exception e) {
//			 ToastTool.showToast(context, "连接异常,请稍后再试哦", 0);
//		 }
        super.onActivityCreated(savedInstanceState);
    }

    protected abstract View initView(LayoutInflater inflater,
                                     ViewGroup container);

    protected abstract void initData();



}
