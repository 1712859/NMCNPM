package com.example.groupmanagement.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.groupmanagement.R;
import com.example.groupmanagement.model.Room;

import java.util.List;

public class AdapterRoom extends BaseAdapter {

    private List<Room> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public AdapterRoom(Context aContext, List<Room> listData) {
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
            convertView = layoutInflater.inflate(R.layout.room_item, null);
            holder = new ViewHolder();
            holder.image_room = (ImageView) convertView.findViewById(R.id.image_room);
            holder.name_room = (TextView) convertView.findViewById(R.id.name_room);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Room room = this.listData.get(position);
        holder.name_room.setText(room.getName());
        return convertView;
    }

    public class ViewHolder {
        TextView name_room;
        ImageView image_room;
    }
}

