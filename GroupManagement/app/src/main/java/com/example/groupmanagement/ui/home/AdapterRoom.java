package com.example.groupmanagement.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groupmanagement.R;

import java.util.List;

public class AdapterRoom extends ArrayAdapter<Room> {

    private List<Room> roomList;
    private int mResource;
    private Context mContext;

    public AdapterRoom( Context context, int resource,  List<Room> objects) {
        super(context, resource, objects);
        this.roomList = objects;
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(viewHolder==null) {

            convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false);
            viewHolder.NameRoom = convertView.findViewById(R.id.name_room);
        }
        else
            viewHolder = (ViewHolder)convertView.getTag();
        final Room rom = roomList.get(position);

        return  convertView;

    }

    public class ViewHolder {
        TextView NameRoom;


    }
}



