package com.example.groupmanagement.apihelper;

import com.example.groupmanagement.config.Constant;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseRetrofitIml {
    private Retrofit retrofit;

    protected Retrofit getRetrofit() {
        if (retrofit == null)
            return new Retrofit.Builder()
                    .baseUrl(Constant.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        else return retrofit;
    }

}