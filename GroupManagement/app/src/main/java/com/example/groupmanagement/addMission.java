package com.example.groupmanagement;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.groupmanagement.ui.home.room_detail;

public class addMission extends AppCompatActivity {
    Button map,huy,oke;
    EditText Title,Location,start,end;
    String sourceName;
    double sourceLas, sourceLong;
    static int GET_START_POINT_REQUEST_CODE = 2;
    static int GET_END_POINT_REQUEST_CODE = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mission);
        Anhxaj();
        buttoncontroll();
        setTitle("Thêm nhiệm vụ");

        Intent intent = getIntent();


        sourceName = intent.getStringExtra("sourceName");
        sourceLas = intent.getDoubleExtra("sourceLas", 0);
        sourceLong = intent.getDoubleExtra("sourceLong", 0);
        Title.setText(sourceName);


    }

    private void buttoncontroll() {
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addMission.this, MapsActivity.class);
                startActivityForResult(intent, GET_START_POINT_REQUEST_CODE);
            }
        });
        oke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addMission.this, room_detail.class);
                startActivity(intent);
            }
        });
        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addMission.this, room_detail.class);
                startActivity(intent);
            }
        });
    }

    private void Anhxaj() {
        Location = (EditText)findViewById(R.id.location);
        map = findViewById(R.id.buttonmap);
        oke = findViewById(R.id.mission_oke);
        huy = findViewById(R.id.mission_huy);
        start = findViewById(R.id.mission_start);
        end = findViewById(R.id.mission_end);
        Title = findViewById(R.id.mission_title);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == GET_START_POINT_REQUEST_CODE) {
                sourceName = data.getStringExtra("name");
                sourceLas = data.getDoubleExtra("las", 0);
                sourceLong = data.getDoubleExtra("long", 0);
                Location.setText(sourceName);
            }

        }
    }
}

