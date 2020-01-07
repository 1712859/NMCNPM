package com.example.groupmanagement.apihelper.loginAccount;

import com.example.groupmanagement.config.Constant;
import com.google.gson.JsonObject;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginAccountApi {
    @POST(Constant.URL_LOGIN)
    Call<ResponseBody> loginAccount(@Body JsonObject body);
}
