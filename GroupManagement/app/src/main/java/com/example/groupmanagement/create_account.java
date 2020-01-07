package com.example.groupmanagement;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class create_account extends AppCompatActivity {
    Spinner editgender;
    Button oke,huy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        // tắt acction bav
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Anhxa();
        buttoncontroll();
        // tạo mảng cho phái

        String[] items = new String[]{"Nữ","Nam"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(create_account.this,
                R.layout.spinner_item,items);
        editgender.setAdapter(adapter);
    }

    private void buttoncontroll() {
        oke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(create_account.this, "Đăng ký thành công với Id: " , Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(create_account.this,MainActivity.class);
                startActivity(intent);
            }
        });
        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(create_account.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Anhxa() {
        editgender = (Spinner)findViewById(R.id.spinner1);
        oke = (Button)findViewById(R.id.buttonDangKi_dangki);
        huy = (Button)findViewById(R.id.buttonDangKi_huy);
    }
}
