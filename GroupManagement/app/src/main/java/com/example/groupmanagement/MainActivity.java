package com.example.groupmanagement;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.groupmanagement.apihelper.loginAccount.LoginAccountApiIml;
import com.example.groupmanagement.listener.LoginListener;
import com.example.groupmanagement.model.Account;
import com.example.groupmanagement.model.Room;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edittextuser)
    EditText edtUsername;
    @BindView(R.id.edittextpass)
    EditText edtPassword;

    Button login,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Tắt Action Bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //Buttnife
        ButterKnife.bind(this);
        //Click Login Button
        edtUsername.setText("Tu98");
        edtPassword.setText("123456");
        if(edtPassword != null & edtUsername != null){
            login = (Button) findViewById(R.id.buttonDangNhap);
            logout = findViewById(R.id.buttonDangKi);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Get Api for authenticating

<<<<<<< HEAD
                    final String userName = edtUsername.getText().toString().trim();
                    final String passWord = edtPassword.getText().toString().trim();
                    new LoginAccountApiIml().authAccount(userName, passWord, new LoginListener() {
                        @Override
                        public void getDataSuccess(Account account) {
                            Intent intent = new Intent(MainActivity.this, main_app.class);
                            Bundle bundle = new Bundle();
                            bundle.putString("jwt", account.getJwt());
                            intent.putExtras(bundle);
                            startActivity(intent);
                        }
=======
                final String userName = edtUsername.getText().toString().trim();
                final String passWord = edtPassword.getText().toString().trim();
                new LoginAccountApiIml().authAccountAsync(userName, passWord, new LoginListener() {
                    @Override
                    public void getDataSuccess(Account account, ArrayList<Room> rooms) {
                        Intent intent = new Intent(MainActivity.this,main_app.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("jwt", account.getJwt());
                        bundle.putSerializable("rooms", rooms);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
>>>>>>> 299bdb8d3ff8de522cb4e4d633b2c3b30af6705d

                        @Override
                        public void getMessageError(Exception e) {
                            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
                            //throw new Error(e);
                        }
                    });
                }
            });
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, create_account.class);
                    startActivity(intent);
                }
            });
        }
        else
        {
            Toast.makeText(MainActivity.this,"xin nhập đủ thông tin đăng nhập", Toast.LENGTH_LONG).show();
        }

    }
}
