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
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.groupmanagement.Adapter.AdapterRoom;
import com.example.groupmanagement.AddRoom;
import com.example.groupmanagement.MainActivity;
import com.example.groupmanagement.R;
import com.example.groupmanagement.apihelper.loginAccount.LoginAccountApiIml;
import com.example.groupmanagement.listener.LoginListener;
import com.example.groupmanagement.main_app;
import com.example.groupmanagement.model.Account;
import com.example.groupmanagement.model.Room;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    String jwt;
    String userName;
    String passWord;

    private List<Room> mListRoom = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        //Receive data from login
        if (getArguments() != null) {
            Bundle args = getArguments();
            jwt = args.getString("jwt");
            userName = args.getString("userName");
            passWord = args.getString("passWord");
        }
        setHasOptionsMenu(true);
        final ListView listView = (ListView) root.findViewById(R.id.lvRoom);
        listView.setAdapter(new AdapterRoom(getContext(), mListRoom));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(root.getContext(), room_detail.class);
                intent.putExtra("idRoom", mListRoom.get(position).getIdroom());
                startActivity(intent);
            }
        });
        registerForContextMenu(listView);
        return root;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.btnAddRoom:
                Intent intent = new Intent(getContext(), AddRoom.class);
                Bundle bundle = new Bundle();
                bundle.putString("jwt", jwt);
                intent.putExtras(bundle);
                startActivity(intent);
                return true;
        }

        return false;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.room_action_bar, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void prepareRoomData(String jwt, String userName, String passWord) {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }
}