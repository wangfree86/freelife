package w.com.wk.freelife.ui.hold;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.raizlabs.android.dbflow.sql.language.Select;

import org.eclipse.jdt.internal.compiler.batch.Main;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import w.com.wk.freelife.CommonAdapter;
import w.com.wk.freelife.R;
import w.com.wk.freelife.base.BaseActivity;
import w.com.wk.freelife.bean.Common;
import w.com.wk.freelife.db.ListAll;
import w.com.wk.freelife.db.ListAll_Table;
import w.com.wk.freelife.db.ListDetail;
import w.com.wk.freelife.db.ListDetail_Table;
import w.com.wk.freelife.db.People_Table;
import w.com.wk.freelife.utils.DateTool;

import static android.media.CamcorderProfile.get;
import static w.com.wk.freelife.R.id.all;

/**
 * @author WK
 * @version 1.0.0
 * @desc:
 * @2016-12-14:11:51
 */
public class ListDetailActivtiy extends BaseActivity {

    @BindView(R.id.et_list_name)
    EditText mEtListName;
    Long allid;
    @BindView(R.id.lv)
    ListView mLv;
    List<Common> lc = new ArrayList<Common>();
    CommonAdapter mCommonAdapter;

    @Override
    protected void initView() {
        setContentView(R.layout.hold_detail_list_add);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        Bundle bundle = this.getIntent().getExtras();
        allid = bundle.getLong("allid");
        ListAll listAll = new Select().from(ListAll.class).where(ListAll_Table.id.eq(allid)).querySingle();

        activity_titlebar_title.setText(listAll.name);
        activity_titlebar_right_text.setVisibility(View.VISIBLE);
        activity_titlebar_right_text.setText("add");
        activity_titlebar_right_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });
        getData();
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Common c = lc.get(i);
                dialog(c);
            }
        });

    }

    protected void dialog(Common c) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("确认复习吗？");

        builder.setTitle("提示");

        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                update(c);

            }
        });

        builder.setNegativeButton("delete", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                mdelete(c);
                dialog.dismiss();
            }


        });

        builder.create().show();
    }

    private void add() {
        String nName = mEtListName.getText().toString();
        ListDetail mList = new ListDetail();
        mList.allid = allid;
        mList.name = nName;
        mList.time = DateTool.getTime();
        mList.reviewcount = 0;
        mList.save();
        getData();
        //   finish();
    }

    private void update(Common c) {
        ListDetail li = new Select().from(ListDetail.class).where(ListDetail_Table.id.eq(c.id)).querySingle();
        li.reviewcount++;
        li.update();
        getData();
    }


    private void mdelete(Common c) {
        ListDetail li = new Select().from(ListDetail.class).where(ListDetail_Table.id.eq(c.id)).querySingle();
        li.delete();
        getData();
    }

    @Override
    public void onClick(View view) {

    }


    private void getData() {
        lc.clear();
        List<ListDetail> lis = new Select().from(ListDetail.class).where(ListDetail_Table.allid.eq(allid)).queryList();
        for (int i = 0; i < lis.size(); i++) {
            ListDetail l = lis.get(i);
            Common c = new Common();
            c.y = l.time + "";
            c.m = l.name;
            c.id = l.id;
            c.reviewcount = l.reviewcount;
            lc.add(c);
        }
        mCommonAdapter = new CommonAdapter(context, lc);
        mLv.setAdapter(mCommonAdapter);
    }
}
