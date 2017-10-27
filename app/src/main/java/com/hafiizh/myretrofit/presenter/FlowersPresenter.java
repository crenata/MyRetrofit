package com.hafiizh.myretrofit.presenter;

import com.hafiizh.myretrofit.data.FlowersService;
import com.hafiizh.myretrofit.model.Flowers;
import com.hafiizh.myretrofit.view.FlowerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by HAFIIZH on 10/26/2017.
 * Author Havea Crenata
 * Email havea.crenata@gmail.com
 * Github https://github.com/crenata
 */

public class FlowersPresenter {
    private FlowersService flowersService;
    private FlowerView flowerView;

    public FlowersPresenter(FlowersService flowersService, FlowerView flowerView) {
        this.flowersService = flowersService;
        this.flowerView = flowerView;
    }

    public void getFlower() {
        flowerView.onProgress();
        flowersService.getFlowers().enqueue(new Callback<List<Flowers>>() {
            @Override
            public void onResponse(Call<List<Flowers>> call, Response<List<Flowers>> response) {
                if (response.isSuccessful()) {
                    flowerView.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Flowers>> call, Throwable t) {
                flowerView.onFailed();
                flowerView.onErrorMessage(t.getMessage());
            }
        });
    }
}
