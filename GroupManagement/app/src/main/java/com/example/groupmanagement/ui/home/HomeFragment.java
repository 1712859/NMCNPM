package com.example.groupmanagement.ui.home;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import androidx.fragment.app.Fragment;


import com.example.groupmanagement.Adapter.AdapterRoom;
import com.example.groupmanagement.AddRoom;
import com.example.groupmanagement.R;
import com.example.groupmanagement.model.Room;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private List<Room> mListRoom = new ArrayList<>();
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        // get data tư api
        prepareRoomData();
        setHasOptionsMenu(true);
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.btnAddRoom:
                Intent intent = new Intent(getContext(), AddRoom.class);
                startActivity(intent);
                return true;
        }

        return false;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.room_action_bar, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }
    private void prepareRoomData() {
        for (int i = 0; i < 15; i++) {
            Room notification = new Room("Room " + i, i);
            mListRoom.add(notification);
        }
    }
}