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
import w.com.wk.freelife.bean.Common;

/**
 * 粉丝列表适配器
 */
public class CountAdapter extends RecyclerView.Adapter<CountAdapter.ViewHolder> {
    //    public String[] datas = null;
    List<Common> lc;

    public CountAdapter(List<Common> lc) {
        this.lc = lc;
    }
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
    public  interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int position);
    }



    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.count_item, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.mYear.setText(lc.get(position).y);
        viewHolder.mMoney.setText(lc.get(position).m);
        viewHolder.itemView.setTag(lc.get(position));
//        viewHolder.flag.setText(lc.get(position).y);
    }


    //获取数据的数量
    @Override
    public int getItemCount() {
        return lc.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.year)
        TextView mYear;
        @BindView(R.id.money)
        TextView mMoney;
        @BindView(R.id.flag)
        TextView flag;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, getPosition());
            }
        }
    }


}