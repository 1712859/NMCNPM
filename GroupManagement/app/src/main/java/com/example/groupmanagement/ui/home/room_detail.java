package com.example.groupmanagement.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

import com.example.groupmanagement.R;

import java.util.ArrayList;
import java.util.List;

public class room_detail extends AppCompatActivity {
    private List<Member> mListRoom = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_detail);
        prepareMemberData();
        setTitle("Tên Phòng");

        final ListView listView = (ListView)findViewById(R.id.listmember);
        listView.setAdapter(new MemberAdapter(this, mListRoom));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.room, menu);
        return true;

    }
    private void prepareMemberData() {
        for (int i = 0; i < 15; i++) {
            Member  notification = new Member(i, null,"name "+i,50+i,"chat "+i,100,100);
            mListRoom.add(notification);
        }
    }
}
