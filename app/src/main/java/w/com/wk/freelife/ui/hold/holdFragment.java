package w.com.wk.freelife.ui.hold;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import w.com.wk.freelife.R;
import w.com.wk.freelife.base.BaseFragment;

import w.com.wk.freelife.di.DaggerAppComponent;
import w.com.wk.freelife.manager.UserManager;

/**
 * @author WK
 * @version 1.0.0
 * @desc:
 * @2016-12-05:12:29
 */
public class HoldFragment extends BaseFragment {

    @BindView(R.id.button)
    Button mButton;
    //添加@Inject注解，表示这个mPoetry是需要注入的
    @Inject
    UserManager mUserManager;


    @Inject
    Gson g;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {

        View view = inflater.inflate(R.layout.fragment_hold, null);
        // 使用Dagger2生成的类 生成组件进行构造，并注入
        DaggerAppComponent.builder()
                .build()
                .inject(this);
        return view;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.button)
    public void onClick() {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.setName("name" + i);
            p.setAge(i * 5);
            persons.add(p);
        }
        HashMap     hashmap     =     new     HashMap();
        hashmap.put("Item0",     "Value0");
        Toast.makeText(getActivity(), g.toJson(hashmap), Toast.LENGTH_SHORT).show();
      //  mUserManager.test(context);
    }

     class Person {

        private String name;
        private int age;

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return the age
         */
        public int getAge() {
            return age;
        }

        /**
         * @param age the age to set
         */
        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString()
        {
            return name + ":" +age;
        }
    }
}
