package w.com.wk.freelife.base;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 对BaseAdapter的简洁处理,处理getview方法都保持在父类,简化代码
 *
 * @author Administrator
 *         <p/>
 *         list<Arraylist> 填充的数据
 */
public abstract class PithyBaseAdapter extends BaseAdapter {
    public Context context;
    public List lists;
    public View Q;


    public PithyBaseAdapter(Context context, List lists) {
        super();
        this.context = context;
        this.lists = lists;
    }


    public PithyBaseAdapter() {
        super();
    }

    @Override
    public int getCount() {

        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


}
