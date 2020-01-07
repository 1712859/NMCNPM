package com.example.groupmanagement.ui.home;


import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groupmanagement.R;
import com.example.groupmanagement.ui.notifications.Notification;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private List<Room> mListRoom = new ArrayList<>();
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        // get data tư api
        prepareRoomData();
        final ListView listView = (ListView) root.findViewById(R.id.lvRoom);
        listView.setAdapter(new AdapterRoom(getContext(), mListRoom));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(root.getContext(), room_detail.class);
                intent.putExtra("idRoom",mListRoom.get(position).getIdroom());
                startActivity(intent);
            }
        });
        return root;
    }

    private void prepareRoomData() {
        for (int i = 0; i < 15; i++) {
            Room notification = new Room("Notification " + i,i);
            mListRoom.add(notification);
        }
    }
}