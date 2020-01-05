package com.example.groupmanagement.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.groupmanagement.R;

import java.util.List;

public class AdapterRoom extends RecyclerView.Adapter<AdapterRoom.MyViewHolder> {

    private List<Room> roomList;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public AdapterRoom(Context context, List<Room> roomList) {
        this.roomList = roomList;
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.recycler_room).findViewById(R.id.name_room);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, name.getText(), Toast.LENGTH_SHORT).show();
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Toast.makeText(mContext, "Long item clicked " + name.getText(), Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = mLayoutInflater.inflate(R.layout.fragment_home, parent, false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Room room1 = roomList.get(position);
        holder.name.setText(room1.getName());

    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }


}
