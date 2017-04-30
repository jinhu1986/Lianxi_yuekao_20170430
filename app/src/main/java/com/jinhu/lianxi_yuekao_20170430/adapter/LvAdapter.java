package com.jinhu.lianxi_yuekao_20170430.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jinhu.lianxi_yuekao_20170430.R;
import com.jinhu.lianxi_yuekao_20170430.beans.JsonBean;
import com.jinhu.lianxi_yuekao_20170430.util.ImageUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * 类的用途：
 * Created by jinhu
 * 2017/4/30  11:12
 */

public class LvAdapter extends BaseAdapter {
    List<JsonBean.ResultBean.BookListBean> list = new ArrayList<>();
    Context mContext;

    public LvAdapter(List<JsonBean.ResultBean.BookListBean> list, Context context) {
        this.list = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.item, null);
            holder.image = (ImageView) convertView.findViewById(R.id.image_item);
            holder.text_01 = (TextView) convertView.findViewById(R.id.text_item_01);
            holder.text_02 = (TextView) convertView.findViewById(R.id.text_item_02);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ImageLoader.getInstance().displayImage(list.get(position).getCoverImg(), holder.image, ImageUtils.getOptions());
        holder.text_01.setText(list.get(position).getName());
        holder.text_02.setText(list.get(position).getType());
        return convertView;
    }

    class ViewHolder {
        ImageView image;
        TextView text_01;
        TextView text_02;
    }
}
