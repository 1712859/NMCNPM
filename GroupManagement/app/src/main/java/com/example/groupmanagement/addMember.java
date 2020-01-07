package com.example.groupmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.groupmanagement.R;
import com.example.groupmanagement.ui.home.room_detail;

public class addMember extends AppCompatActivity {
    Button oke, huy;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
        Anhxa();
        buttoncontrol();
        setTitle("Thêm thành viên");
    }

    private void Anhxa() {
        huy = findViewById(R.id.addMember_huy);
        oke = findViewById(R.id.addMember_oke);
        email = findViewById(R.id.addMember_email);
    }

    private void buttoncontrol() {
        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addMember.this, room_detail.class);
                startActivity(intent);
            }
        });
        oke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addMember.this, room_detail.class);
                startActivity(intent);
            }
        });

    }
}
