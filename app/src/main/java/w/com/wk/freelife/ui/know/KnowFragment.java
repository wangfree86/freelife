package w.com.wk.freelife.ui.know;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.raizlabs.android.dbflow.runtime.transaction.process.ProcessModelInfo;
import com.raizlabs.android.dbflow.runtime.transaction.process.SaveModelTransaction;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.ArrayList;
import java.util.List;

import w.com.wk.freelife.R;
import w.com.wk.freelife.base.BaseFragment;
import w.com.wk.freelife.db.People;
import w.com.wk.freelife.db.People_Table;

/**
 * @author WK
 * @version 1.0.0
 * @desc:
 * @2016-12-05:12:29
 */
public class KnowFragment extends BaseFragment {

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_home, null);
      //  find();
        return view;
    }

    public void add() {
        People people = new People();
        people.name = "Wiki";
        people.gender = 1;
        people.save();
//people.update();
//people.delete();
        Log.e("Test", String.valueOf(people.id));
    }

    public void find() {
        //返回所有查询结果
        List<People> peoples = new Select().from(People.class).queryList();
//返回单个查询结果
        People people = new Select().from(People.class).querySingle();
        Toast.makeText(context, String.valueOf(people.name), Toast.LENGTH_SHORT).show();
//查询gender = 1的所有People
        List<People> peoples2 = new Select().from(People.class).where(People_Table.gender.eq(1)).queryList();
    }

    public void test() {
        List<People> peoples = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            People people = new People();
            people.name = "ww";
            people.gender = 1;
            peoples.add(people);
        }
//实时保存，马上保存
        new SaveModelTransaction<>(ProcessModelInfo.withModels(peoples)).onExecute();
//异步保存，使用异步，如果立刻查询可能无法查到结果
//TransactionManager.getInstance().addTransaction(new SaveModelTransaction<>(ProcessModelInfo.withModels(peoples)));   }
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {

    }
}
