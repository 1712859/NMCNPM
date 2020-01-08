package com.example.groupmanagement.apihelper.loginAccount;

import com.example.groupmanagement.model.Room;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface userClient {
   @POST("/rooms")
   Call<create_Room> createroom(@Header("Authorization") String auth,@Body create_Room create_room);



}
