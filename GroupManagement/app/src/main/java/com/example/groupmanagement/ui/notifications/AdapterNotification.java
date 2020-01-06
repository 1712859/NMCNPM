package com.example.groupmanagement.ui.notifications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.groupmanagement.R;

import java.util.List;

public class AdapterNotification extends BaseAdapter {

    private List<Notification> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public AdapterNotification(Context aContext, List<Notification> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.notification_item, null);
            holder = new ViewHolder();
            holder.icon_notification = (ImageView) convertView.findViewById(R.id.ivIcon);
            holder.title_notification = (TextView) convertView.findViewById(R.id.tvTitleNotification);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Notification notification = this.listData.get(position);
        holder.title_notification.setText(notification.getTitle());
        return convertView;
    }

    static class ViewHolder {
        ImageView icon_notification;
        TextView title_notification;
    }

}
