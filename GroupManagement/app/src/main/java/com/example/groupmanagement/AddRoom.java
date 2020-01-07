package com.example.groupmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.groupmanagement.apihelper.loginAccount.LoginAccountApiIml;
import com.example.groupmanagement.apihelper.loginAccount.create_Room;
import com.example.groupmanagement.apihelper.loginAccount.userClient;
import com.example.groupmanagement.listener.LoginListener;
import com.example.groupmanagement.ui.home.room_detail;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddRoom extends AppCompatActivity {
    String jwt;
    EditText name;
    Button oke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);
        oke = findViewById(R.id.btn_create);
        name = findViewById(R.id.Ten_phong_add);

        final Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        //...............................
        if (bundle != null) {
            jwt = bundle.getString("jwt");
        }

        oke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit builder = new Retrofit.Builder()
                        .baseUrl("http://group-management.herokuapp.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                create_Room create_room = new create_Room(name.getText().toString());
                userClient client = builder.create((userClient.class));
                String term = "Bearer " + jwt;
                Call<create_Room> call = client.createroom(term, create_room);
                call.enqueue(new Callback<create_Room>() {
                    @Override
                    public void onResponse(Call<create_Room> call, Response<create_Room> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(AddRoom.this, response.message(), Toast.LENGTH_LONG).show();
                            return;
                        } else {
                            Intent intent = new Intent(AddRoom.this, room_detail.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("jwt", jwt);
                            intent.putExtras(bundle);
                            bundle.putString("id_room", response.body().getId());
                            intent.putExtras(bundle);
                            startActivity(intent);
                            Toast.makeText(AddRoom.this, "Tạo phòng thành công", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<create_Room> call, Throwable t) {
                        Toast.makeText(AddRoom.this, "Tạo phòng không thành công", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });


    }
}
