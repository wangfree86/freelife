package w.com.wk.freelife;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import w.com.wk.freelife.db.ListDetail;
import w.com.wk.freelife.di.DaggerAppComponent;
import w.com.wk.freelife.manager.UserManager;
import w.com.wk.freelife.ui.hold.ListDetailActivtiy;

public class ttActivity {

    public static void main(String[] stra) {
        //   System.out.print("dfdf");
        String s="123456";
        System.out.print(printt(s));
    }

    public static String printt(String s) {
        if (s == null || s.length() < 0) {
            return "error";
        }
        if (s.length() <= 1) {
            return s;
        }
        char a = s.charAt(0);
        char b = s.charAt(s.length() - 1);
        if (s.length() == 2) {
            return b + "" + a;
        }
        return b + printt(s.substring(1, s.length() - 1)) + a;
    }
}
