package w.com.wk.freelife;

import android.animation.PropertyValuesHolder;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;

import w.com.wk.freelife.ui.hold.HoldFragment;
import w.com.wk.freelife.ui.home.HomeFragment;
import w.com.wk.freelife.ui.know.KnowFragment;
import w.com.wk.freelife.ui.my.MyFragment;
import w.com.wk.freelife.ui.widget.WidgetFragment;

/***
 *
 */

/**
 * 管理器,管理首页fragment切换
 */
public class FragmentController {

    private int containerId;
    private FragmentManager fm;
    public ArrayList<Fragment> fragments;

    private static FragmentController controller;

    public static FragmentController getInstance(FragmentActivity activity, int containerId) {
        if (controller == null) {
            controller = new FragmentController(activity, containerId);
        }
        return controller;
    }

    public static void onDestroy() {
        controller = null;
    }

    private FragmentController(FragmentActivity activity, int containerId) {
        this.containerId = containerId;
        fm = activity.getSupportFragmentManager();
        initFragment();
    }

    private void initFragment() {
        fragments = new ArrayList<Fragment>();
        fragments.add(new HomeFragment());
        fragments.add(new HoldFragment());
        fragments.add(new KnowFragment());
        fragments.add(new WidgetFragment());
        fragments.add(new MyFragment());


        FragmentTransaction ft = fm.beginTransaction();
        for (Fragment fragment : fragments) {
            ft.add(containerId, fragment);
        }
        ft.commitAllowingStateLoss();
    }

    public void showFragment(int position) {
        hideFragments();
        Fragment fragment = fragments.get(position);
        FragmentTransaction ft = fm.beginTransaction();
        ft.show(fragment);
        ft.commitAllowingStateLoss();

    }

    public void hideFragments() {
        FragmentTransaction ft = fm.beginTransaction();
        for (Fragment fragment : fragments) {
            if (fragment != null) {
                ft.hide(fragment);
            }
        }
        ft.commitAllowingStateLoss();
    }

    public Fragment getFragment(int position) {
        return fragments.get(position);
    }
}