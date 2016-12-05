package w.com.wk.freelife.ui.home;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindBitmap;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import w.com.wk.freelife.R;
import w.com.wk.freelife.base.BaseFragment;

/**
 * @author WK
 * @version 1.0.0
 * @desc:
 * @2016-12-05:12:29
 */
public class HomeFragment extends BaseFragment {
    //绑定TextView
    @BindView(R.id.test)
    TextView test;// 注意： 的修饰类型不能是：private 或者 static 。 否则会报错：错误: @BindView fields must not be private or static
    //绑定string 字符串
    @BindString(R.string.app_name)
    String mString;
    //绑定ImageView 控件
    @BindView(R.id.iv_test)
    ImageView iv_test;
    //绑定Bitmap 资源
    @BindBitmap(R.mipmap.gold_button_heart)
    Bitmap mBitmap;
    @BindColor(R.color.black)
    int black;  //绑定一个颜色值


    @OnClick(R.id.test)   //设置一个点击事件
    public void showToast() {
        Toast.makeText(getActivity(), "is a click", Toast.LENGTH_SHORT).show();
    }

    @OnLongClick(R.id.test)    //给 设置一个长按事件
    public boolean showToast2() {
        Toast.makeText(getActivity(), "is a long click", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        //绑定fragment
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        test.setText(mString);
        test.setTextColor(black);
        iv_test.setImageBitmap(mBitmap);
        return rootView;
    }

    @Override
    public void onClick(View view) {

    }
}
