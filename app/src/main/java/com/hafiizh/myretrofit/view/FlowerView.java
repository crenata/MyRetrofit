package com.hafiizh.myretrofit.view;

import com.hafiizh.myretrofit.model.Flowers;

import java.util.List;

/**
 * Created by HAFIIZH on 10/27/2017.
 * Author Havea Crenata
 * Email havea.crenata@gmail.com
 * Github https://github.com/crenata
 */

public interface FlowerView {
    void onProgress();

    void onSuccess(List<Flowers> flowers);

    void onFailed();

    void onErrorMessage(String message);
}
