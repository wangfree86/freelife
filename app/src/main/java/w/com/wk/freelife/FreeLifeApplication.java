package w.com.wk.freelife;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * @author WK
 * @version 1.0.0
 * @desc:
 * @2016-12-05:10:07
 */
public class FreeLifeApplication  extends Application {
    private static FreeLifeApplication mInstance;
    @Override
    public void onCreate () {
        super.onCreate();
        mInstance = this;
        FlowManager.init(this);
    }


    public static FreeLifeApplication get () {
        return mInstance;
    }
}
