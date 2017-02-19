package w.com.wk.freelife.ui.widget;


import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import w.com.wk.freelife.R;
import w.com.wk.freelife.adapter.CommonAdapter;
import w.com.wk.freelife.adapter.CountAdapter;
import w.com.wk.freelife.base.BaseActivity;
import w.com.wk.freelife.bean.Common;

import static android.R.attr.y;

/**
 * @author WK
 * @version 1.0.0
 * @desc:test
 * @2017年2月15日18:24:18
 */
public class WtTestActivtiy extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("HJJ", "Activity &&&& onCreate...");
        // Create the list fragment and add it as our sole content.
        if (getFragmentManager().findFragmentById(android.R.id.content) == null) {
            ArrayListFragment list = new ArrayListFragment();
            getFragmentManager().beginTransaction().add(android.R.id.content, list).commit();
        }
    }

    @Override
    protected void onStart() {

        super.onStart();
        Log.e("HJJ", "Activity &&&& onStart...");
    }

    @Override
    protected void onResume() {

        super.onResume();
        Log.e("HJJ", "Activity &&&& onResume...");
    }

    @Override
    protected void onStop() {

        super.onStop();
        Log.e("HJJ", "Activity &&&& onStop...");
    }

    @Override
    protected void onPause() {

        super.onPause();
        Log.e("HJJ", "Activity &&&& onPause...");
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        Log.e("HJJ", "Activity &&&& onDestroy...");
    }

    public static class ArrayListFragment extends ListFragment {

        @Override
        public void onAttach(Activity activity) {

            Log.e("HJJ", "ArrayListFragment **** onAttach...");
            super.onAttach(activity);
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {

            Log.e("HJJ", "ArrayListFragment **** onCreate...");
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            Log.e("HJJ", "ArrayListFragment **** onCreateView...");
            return super.onCreateView(inflater, container, savedInstanceState);
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            Log.e("HJJ", "ArrayListFragment **** onActivityCreated...");
            String[] array = new String[]{"C++", "JAVA", "PYTHON"};
            setListAdapter(new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_1, array));
        }

        @Override
        public void onStart() {

            Log.e("HJJ", "ArrayListFragment **** onStart...");
            super.onStart();
        }

        @Override
        public void onResume() {
            Log.e("HJJ", "ArrayListFragment **** onResume...");

            super.onResume();
        }

        @Override
        public void onPause() {
            Log.e("HJJ", "ArrayListFragment **** onPause...");

            super.onPause();
        }

        @Override
        public void onStop() {
            Log.e("HJJ", "ArrayListFragment **** onStop...");

            super.onStop();
        }

        @Override
        public void onDestroyView() {
            Log.e("HJJ", "ArrayListFragment **** onDestroyView...");

            super.onDestroyView();
        }

        @Override
        public void onDestroy() {

            Log.e("HJJ", "ArrayListFragment **** onDestroy...");
            super.onDestroy();
        }

        @Override
        public void onDetach() {
            Log.e("HJJ", "ArrayListFragment **** onDetach...");

            super.onDetach();
        }

        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            Log.i("FragmentList", "Item clicked: " + id);
        }
    }
}
