package com.hafiizh.myretrofit.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by HAFIIZH on 10/11/2017.
 * Author Havea Crenata
 * Email havea.crenata@gmail.com
 * Github https://github.com/crenata
 */

public class Flowers {
    @SerializedName("category")
    public String category;
    @SerializedName("price")
    public String price;
    @SerializedName("instructions")
    public String instructions;
    @SerializedName("photo")
    public String photo;
    @SerializedName("name")
    public String name;
    @SerializedName("productId")
    public String productId;
}
