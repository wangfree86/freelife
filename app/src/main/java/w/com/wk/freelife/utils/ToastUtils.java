package w.com.wk.freelife.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;


import w.com.wk.freelife.FreeLifeApplication;
import w.com.wk.freelife.R;


public class ToastUtils {

    private static Toast toast;
    private static LayoutInflater inflater;

    public static void showToast(int resId) {
        try {
            if (toast != null) {
                toast.cancel();
                toast = null;
            }

            toast = makeToast(FreeLifeApplication.get(), resId);
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showToast(String msg) {
        try {
            if (toast != null) {
                toast.cancel();
                toast = null;
            }
            toast = makeToast(FreeLifeApplication.get(), msg);
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Toast makeToast(Context context, String string) {
        if(inflater == null) {
            inflater = LayoutInflater.from(context);
        }
        TextView tv = (TextView) inflater.inflate(R.layout.view_toast, null);
        tv.setText(string);
        Toast toast = new Toast(context);
        toast.setView(tv);
        toast.setGravity(android.view.Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        return toast;
    }

    public static Toast makeToast(Context context, int resId) {
        return makeToast(context, context.getString(resId));
    }


}
