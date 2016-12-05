package w.com.wk.freelife;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.iv_home)
    ImageView mIvHome;
    @BindView(R.id.iv_hold)
    ImageView mIvHold;
    @BindView(R.id.iv_widget)
    ImageView mIvWidget;
    @BindView(R.id.iv_knowledge)
    ImageView mIvKnowledge;
    @BindView(R.id.iv_my)
    ImageView mIvMy;
    @BindView(R.id.activity_main)
    RelativeLayout mActivityMain;


    private FragmentController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        controller = FragmentController.getInstance(this, R.id.fl_content);
        controller.showFragment(0);
    }


    @OnClick({R.id.iv_home, R.id.iv_hold, R.id.iv_widget, R.id.iv_knowledge, R.id.iv_my})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_home:
                Toast.makeText(this, "sdf", Toast.LENGTH_SHORT).show();
                controller.showFragment(0);
                break;
            case R.id.iv_hold:
                controller.showFragment(1);
                break;
            case R.id.iv_widget:
                controller.showFragment(2);
                break;
            case R.id.iv_knowledge:
                controller.showFragment(3);
                break;
            case R.id.iv_my:
                controller.showFragment(4);
                break;
        }
    }
}
