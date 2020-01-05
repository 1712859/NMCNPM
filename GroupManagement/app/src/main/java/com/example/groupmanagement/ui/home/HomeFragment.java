package com.example.groupmanagement.ui.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groupmanagement.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    List roomlist = new ArrayList<>() ;

    public View onCreateView( LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        recyclerView.findViewById(R.id.list);
        onsetdata();

        return inflater.inflate(R.layout.fragment_home,container,false);

    }

    @Override
    public void onStart() {
        super.onStart();
        AdapterRoom adapterRoom = new AdapterRoom(getContext(),R.layout.fragment_home,roomlist);
        recyclerView.setAdapter(adapterRoom);
    }

    private void onsetdata()
    {
        roomlist.add(new Room("nhóm 1"));
        roomlist.add(new Room("nhóm 2"));
        roomlist.add(new Room("nhóm 3"));
        roomlist.add(new Room("nhóm 4"));
    }



}