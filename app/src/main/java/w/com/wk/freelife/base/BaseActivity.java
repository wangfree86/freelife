package w.com.wk.freelife.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import w.com.wk.freelife.R;
import w.com.wk.freelife.utils.ToastUtils;


public abstract class BaseActivity extends FragmentActivity implements OnClickListener {

    protected Context context;
    //title
    protected ImageView iv_back;
    protected TextView activity_titlebar_title;
    protected TextView activity_titlebar_left;
    protected TextView activity_titlebar_right_text;
    //title
    public RelativeLayout rl_common_title;
    // 右侧公用图片
    public ImageView iv_common_img_right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        initView();

        initTitle();

        initData();
    }

    protected abstract void initView();

    protected abstract void initData();

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    protected void intent2Activity(Class<? extends Activity> tarActivity) {
        Intent intent = new Intent(this, tarActivity);
        startActivity(intent);
    }
    /**
     * 标题实现按钮,文字
     */
    public void initTitle() {
        rl_common_title = (RelativeLayout) this
                .findViewById(R.id.rl_common_title);
        iv_back = (ImageView) this.findViewById(R.id.iv_back);

        if (iv_back != null) {
            iv_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }

        activity_titlebar_title = (TextView) this
                .findViewById(R.id.activity_titlebar_title);
        activity_titlebar_left = (TextView) this
                .findViewById(R.id.activity_titlebar_left);
        activity_titlebar_right_text = (TextView) this
                .findViewById(R.id.activity_titlebar_right_text);

        iv_common_img_right = (ImageView) this
                .findViewById(R.id.iv_common_img_right);
    }


    /**
     * 普通toast
     *
     * @param msg
     */
    protected void showToast(String msg) {
        ToastUtils.showToast(msg);
    }

    /**
     * 普通toast
     */
    protected void showToast(int resId) {
        ToastUtils.showToast(resId);
    }

    /**
     * 加对错符合的toast
     *
     * @param msg
     * @param b
     */
    protected void showToast(String msg, Boolean b) {
        if (b) {
            ToastUtils.showToast(msg);
        } else {
            ToastUtils.showToast(msg);
        }

    }

}
