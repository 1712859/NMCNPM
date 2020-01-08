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
import com.example.groupmanagement.R;
import com.example.groupmanagement.apihelper.loginAccount.LoginAccountApiIml;
import com.example.groupmanagement.apihelper.loginAccount.userClient;
import com.example.groupmanagement.listener.LoginListener;
import com.example.groupmanagement.model.Account;
import com.example.groupmanagement.model.Room;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeFragment extends Fragment {
    String jwt;
    String userName;
    String passWord;

    private List<Room> mListRoom = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        prepareRoomData();
        //Receive data from login
        if (getArguments() != null) {
            Bundle args = getArguments();
            jwt = args.getString("jwt");
            userName = args.getString("userName");
            passWord = args.getString("passWord");
            mListRoom = (ArrayList<Room>)args.getSerializable("rooms");
        }
        final ListView listView = (ListView) getActivity().findViewById(R.id.lvRoom);
        listView.setAdapter(new AdapterRoom(getContext(), mListRoom));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), room_detail.class);
                intent.putExtra("idRoom", mListRoom.get(position).getIdroom());
                startActivity(intent);
            }
        });
        registerForContextMenu(listView);
        setHasOptionsMenu(true);
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
<<<<<<< HEAD
    private void prepareRoomData() {
        for (int i = 0; i < 15; i++) {
            Room notification = new Room("Room " + i, i);
            mListRoom.add(notification);
        }
=======

    private void prepareRoomData(String jwt, String userName, String passWord) {
        new LoginAccountApiIml().authAccountAsync(userName, passWord, new LoginListener() {
            @Override
            public void getDataSuccess(Account account, ArrayList<Room> rooms) {
                mListRoom = rooms;
                final ListView listView = (ListView) getActivity().findViewById(R.id.lvRoom);
                listView.setAdapter(new AdapterRoom(getContext(), mListRoom));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getContext(), room_detail.class);
                        intent.putExtra("idRoom", mListRoom.get(position).getIdroom());
                        startActivity(intent);
                    }
                });
                registerForContextMenu(listView);
            }

            @Override
            public void getMessageError(Exception e) {
                Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();
                throw new Error(e);
            }
        });
>>>>>>> 299bdb8d3ff8de522cb4e4d633b2c3b30af6705d
    }
    private void prepareRoomData(String jwt) {


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        prepareRoomData(jwt, userName, passWord);
        super.onActivityCreated(savedInstanceState);
    }
}