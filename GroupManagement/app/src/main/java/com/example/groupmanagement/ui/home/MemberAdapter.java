package com.example.groupmanagement.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.groupmanagement.R;

import java.util.List;

public class MemberAdapter extends BaseAdapter {
    private List<Member> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public MemberAdapter(Context acontext, List<Member> listData) {
        this.listData = listData;
        this.context = acontext;
        layoutInflater = LayoutInflater.from(acontext);
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
        MemberAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.member_item, null);
            holder = new MemberAdapter.ViewHolder();
            holder.image_member= (ImageView) convertView.findViewById(R.id.room_avatar_member);
            holder.name_member = (TextView) convertView.findViewById(R.id.room_name_member);
            holder.speed = (TextView) convertView.findViewById(R.id.room_speed_member);
            holder.vitri = (TextView) convertView.findViewById(R.id.room_vitri_member);
            holder.mess= (TextView) convertView.findViewById(R.id.room_mess_member);

            convertView.setTag(holder);
        } else {
            holder = (MemberAdapter.ViewHolder) convertView.getTag();
        }

        Member member = this.listData.get(position);
        int vt = member.getSpeed();
        holder.name_member.setText(member.getName());
        holder.speed.setText(new Integer(vt).toString());
        holder.mess.setText(member.getChat());

        return convertView;
    }

    public class ViewHolder {
        TextView name_member,speed,vitri,mess;
        ImageView image_member;

    }
}
