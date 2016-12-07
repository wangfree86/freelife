package w.com.wk.freelife.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * @author WK
 * @version 1.0.0
 * @desc:
 * @2016-12-07:11:16
 */
@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public class AppDatabase {
    //数据库名称
    public static final String NAME = "AppDatabase";
    //数据库版本号
    public static final int VERSION = 1;
}
