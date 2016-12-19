package w.com.wk.freelife;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.common.eventbus.EventBus;
import com.google.gson.Gson;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import w.com.wk.freelife.bean.Common;
import w.com.wk.freelife.db.ListDetail;
import w.com.wk.freelife.di.DaggerAppComponent;
import w.com.wk.freelife.manager.UserManager;
import w.com.wk.freelife.ui.hold.ListDetailActivtiy;
import w.com.wk.freelife.utils.ToastUtils;

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

    //添加@Inject注解，表示这个mPoetry是需要注入的
    @Inject
    UserManager mUserManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        controller = FragmentController.getInstance(this, R.id.fl_content);
        controller.showFragment(0);
        // 使用Dagger2生成的类 生成组件进行构造，并注入
        DaggerAppComponent.builder()
                .build()
                .inject(this);
//
//        List<ListDetail> lis = new Select().from(ListDetail.class).queryList();
//        for (int i = 0; i < lis.size(); i++) {
//            ListDetail l = lis.get(i);
//            if (l.time / 1000 / 3600 > 1) {
//                show(l);
//            }
//
//        }
    }


    @OnClick({R.id.iv_home, R.id.iv_hold, R.id.iv_widget, R.id.iv_knowledge, R.id.iv_my})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_home:
                controller.showFragment(0);
                break;
            case R.id.iv_hold:
                controller.showFragment(1);
//                mUserManager.test(this);
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



    public void show(ListDetail l) {


        Notification.Builder builder1 = new Notification.Builder(MainActivity.this);
        builder1.setSmallIcon(R.drawable.ic_launcher); //设置图标

        builder1.setContentTitle(l.name); //设置标题
        builder1.setContentText(l.time+""); //消息内容
        builder1.setWhen(System.currentTimeMillis()); //发送时间
        builder1.setDefaults(Notification.DEFAULT_ALL); //设置默认的提示音，振动方式，灯光
        builder1.setAutoCancel(true);//打开程序后图标消失


        Intent intent =new Intent (MainActivity.this,ListDetailActivtiy.class);
        Bundle bundle = new Bundle();
        bundle.putString("allid", l.id+"");
        intent.putExtras(bundle);

        PendingIntent pendingIntent =PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
        builder1.setContentIntent(pendingIntent);
        Notification notification = builder1.build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(11,notification);

    }

    @Override
    protected void onDestroy () {
        super.onDestroy();
        FragmentController.onDestroy();

    }
}
