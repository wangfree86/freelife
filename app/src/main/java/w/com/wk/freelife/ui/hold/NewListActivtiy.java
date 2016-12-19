package w.com.wk.freelife.ui.hold;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import w.com.wk.freelife.R;
import w.com.wk.freelife.base.BaseActivity;
import w.com.wk.freelife.db.ListAll;
import w.com.wk.freelife.db.MList;
import w.com.wk.freelife.db.People;
import w.com.wk.freelife.utils.DateTool;

import static android.R.attr.y;

/**
 * @author WK
 * @version 1.0.0
 * @desc:
 * @2016-12-14:11:51
 */
public class NewListActivtiy extends BaseActivity {


    @BindView(R.id.name)
    TextView mName;
    @BindView(R.id.add)
    TextView mAdd;
    @BindView(R.id.et_list_name)
    EditText mEtListName;

    @Override
    protected void initView() {
        setContentView(R.layout.hold_list_add);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {

    }


    @OnClick(R.id.add)
    public void onClick() {
//        List<MList> peoples = new Select().from(MList.class).queryList();

        add();
    }

    private void add() {
        String nName = mEtListName.getText().toString();
        ListAll mList = new ListAll();
        mList.name = nName;
        mList.time = DateTool.getTime();;
        mList.save();
        finish();
    }
}
