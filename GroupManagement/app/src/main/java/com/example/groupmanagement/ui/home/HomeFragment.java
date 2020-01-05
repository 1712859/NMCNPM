package com.example.groupmanagement.ui.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groupmanagement.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private List<Room> mListRoom = new ArrayList<>();
    private RecyclerView recyclerView;
    private AdapterRoom adapterRoom;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        // get data tư api
        prepareRoomData();
        recyclerView = root.findViewById(R.id.recycler_room);
        adapterRoom = new AdapterRoom(getActivity(),mListRoom);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(container.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterRoom);
        return root;

    }

    private void prepareRoomData() {
        Room movie = new Room("aaaaaa");
        mListRoom.add(movie);
        Room movie1 = new Room("bbbbb");
        mListRoom.add(movie);
        Room movie2 = new Room("vvvvv");
        mListRoom.add(movie);
    }

}