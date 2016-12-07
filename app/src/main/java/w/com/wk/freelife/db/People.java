package w.com.wk.freelife.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ModelContainer;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * @author WK
 * @version 1.0.0
 * @desc:
 * @2016-12-07:11:16
 */
@ModelContainer
@Table(database = AppDatabase.class)
public class People extends BaseModel {
    //自增ID
    @PrimaryKey(autoincrement = true)
    public Long id;
    @Column
    public String name;
    @Column
    public int gender;
}
