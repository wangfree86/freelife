package w.com.wk.freelife.adapter;

import android.content.Context;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import w.com.wk.freelife.R;
import w.com.wk.freelife.base.PithyBaseAdapter;
import w.com.wk.freelife.bean.Common;
import w.com.wk.freelife.utils.DateTool;

/**
 * 粉丝列表适配器
 */
public class CommonAdapter extends PithyBaseAdapter {
    private Context context;
    private List<Common> CommonList = new ArrayList<Common>();
Boolean isAllList=false;

    public CommonAdapter(Context context, List<Common> CommonList) {
        super(context, CommonList);
        this.context = context;
        this.CommonList = CommonList;

    }


    public void setAllList(Boolean isAllList) {
        this.isAllList=isAllList;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Common Common = CommonList.get(position);
        ViewHolder holder;
        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.item_widget_1, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
   //     holder.mYear.setText(Common.y);
        holder.mMoney.setText(Common.m);

//        Long l=Long.parseLong(Common.y);
//        SimpleDateFormat df = null;//设置日期格式
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
//            df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        }
        if(!isAllList){
            String st = DateTool.getShortTime(context, Common.y);
            if (Common.reviewcount != 0) {
                st = st + "----复习次数" + Common.reviewcount;
            } else {

            }
            int ii=DateTool.getMemoryTime(context, Common.y)-Common.reviewcount;
            if(ii>0){
                st = st + "----复习次数" + Common.reviewcount+ "----又忘记复习的了"+ii;
            }
            holder.flag.setText(st);
        }


        return convertView;
    }

    public class ViewHolder {
        @BindView(R.id.year)
        TextView mYear;
        @BindView(R.id.money)
        TextView mMoney;
        @BindView(R.id.flag)
        TextView flag;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }


    }

}
