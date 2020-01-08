package com.example.groupmanagement.apihelper.loginAccount;

import android.util.Log;

import com.example.groupmanagement.apihelper.BaseRetrofitIml;
import com.example.groupmanagement.listener.LoginListener;
import com.example.groupmanagement.model.Account;
import com.example.groupmanagement.model.Room;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginAccountApiIml extends BaseRetrofitIml {
    String TAG = LoginAccountApiIml.class.getSimpleName();
    LoginAccountApi loginAccountApi;
    Retrofit retrofit = getRetrofit();

    //Xác thực tài khoản
    public void authAccountAsync(String userName, String passWord, final LoginListener listener) {
        loginAccountApi = retrofit.create(LoginAccountApi.class);
        final JsonObject body = new JsonObject();
        body.addProperty("identifier", userName);
        body.addProperty("password", passWord);
        Call<ResponseBody> call = loginAccountApi.loginAccount(body);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //Kết quả trả về dạng String nên cần chuyển về dạng Json
                if (response.isSuccessful()) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        Boolean status = jsonObject.has("jwt");
                        if (status == true) {
                            String jwt = jsonObject.getString("jwt");
                            JSONObject user = jsonObject.getJSONObject("user");
                            String username = user.getString("username");
                            String email = user.getString("email");
                            String phone = null;
                            String avatar = null;
                            Account account = new Account(jwt, username, phone, email, avatar);
                            ArrayList<Room> rooms = new ArrayList<>();
                            JSONArray owner_of_rooms = user.getJSONArray("owner_of_rooms");
                            for (int i = 0; i < owner_of_rooms.length(); i++) {
                                String r_name = owner_of_rooms.getJSONObject(i).getString("name");
                                String r_id = owner_of_rooms.getJSONObject(i).getString("id");
                                rooms.add(new Room(r_name, r_id));
                            }
                            listener.getDataSuccess(account, rooms);
                        } else {
                            Log.d(TAG, "onResponse: " + jsonObject.toString());
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                listener.getMessageError(new Exception(t));
            }
        });
    }
//    public void createroom(String name, String,final LoginListener listener)
//    {
//        loginAccountApi = retrofit.create(LoginAccountApi.class);
//        final JsonObject body = new JsonObject();
//        body.addProperty("name", name);
//        Call<ResponseBody> call = loginAccountApi.loginAccount(body);
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//            }
//        });
//    }
}