package com.hafiizh.myretrofit.data;

import com.hafiizh.myretrofit.utilities.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HAFIIZH on 10/27/2017.
 * Author Havea Crenata
 * Email havea.crenata@gmail.com
 * Github https://github.com/crenata
 */

public class Injector {
    private static Retrofit provideRetrofit(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static FlowersService getService() {
        return provideRetrofit(Constants.FEEDS).create(FlowersService.class);
    }
}
