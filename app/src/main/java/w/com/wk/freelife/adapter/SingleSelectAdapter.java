package w.com.wk.freelife.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import w.com.wk.freelife.R;

/**
 * 单选选择列表
 */
public class SingleSelectAdapter extends RecyclerView.Adapter<SingleSelectAdapter.ViewHolder> {
    List<String> lc;
   MyItemOnClickListener mListener;
    public SingleSelectAdapter(List<String> lc) {
        this.lc = lc;
    }
    //RecyclerView点击事件的实现 3、获取到接口实例化
    public void setItemOnClickListener(MyItemOnClickListener listener) {
        mListener = listener;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.select_item, viewGroup, false);
       //RecyclerView点击事件的实现 4、在Adapter中绑定ViewHolder时传入接口实例化后的类mListener
        ViewHolder vh = new ViewHolder(view, mListener);


        return vh;
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.select.setText(lc.get(position) + "");
    }


    //获取数据的数量
    @Override
    public int getItemCount() {
        return lc.size();
    }


    //自定义的ViewHolder，持有每个Item的的所有界面元素
    //RecyclerView点击事件的实现5.在ViewHolder中实现单击监听：
//    在View实现setOnClickListener，

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.select)
        TextView select;
        MyItemOnClickListener mListener;

        public ViewHolder(View view, MyItemOnClickListener mListener) {
            super(view);
            this.mListener = mListener;
            ButterKnife.bind(this, view);
            //实现点击事件
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // RecyclerView点击事件的实现6.在OnClick中接受接口实例化传入的具体处理事件，即mListener。调用onItemOnClick方法
            if (mListener != null) {
                mListener.onItemOnClick(view, getPosition());
            }
        }
    }

    //RecyclerView点击事件的实现1、定义接口：在接口中，定义接口方法onItemOnClick方法，在里面实现具体的点击响应事件，
    // 同时传入两个参数：view和postion。和ListView中item的点击一样。
    public interface MyItemOnClickListener {
        void onItemOnClick(View view,int postion);
    }
}

