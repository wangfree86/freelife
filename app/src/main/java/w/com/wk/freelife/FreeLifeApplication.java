package w.com.wk.freelife;

import android.app.Application;
import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.raizlabs.android.dbflow.config.FlowManager;

import java.io.File;

import static android.R.attr.path;

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
