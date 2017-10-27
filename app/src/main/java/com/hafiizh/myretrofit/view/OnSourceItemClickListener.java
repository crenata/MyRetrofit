package com.hafiizh.myretrofit.view;

import android.view.View;

import java.util.List;

/**
 * Created by HAFIIZH on 10/26/2017.
 * Author Havea Crenata
 * Email havea.crenata@gmail.com
 * Github https://github.com/crenata
 */

public interface OnSourceItemClickListener<T> {
    void onSourceItemClick(View v, int position, List<T> response);
}
