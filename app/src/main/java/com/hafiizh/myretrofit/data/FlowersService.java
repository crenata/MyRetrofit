package com.hafiizh.myretrofit.data;

import com.hafiizh.myretrofit.model.Flowers;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by HAFIIZH on 10/27/2017.
 * Author Havea Crenata
 * Email havea.crenata@gmail.com
 * Github https://github.com/crenata
 */

public interface FlowersService {
    @GET("flowers.json")
    Call<List<Flowers>> getFlowers();
}
