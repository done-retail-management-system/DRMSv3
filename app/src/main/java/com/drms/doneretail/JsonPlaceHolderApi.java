package com.drms.doneretail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("http://196.252.124.54/api/product_warehouse/read.php")
    Call<List<product_warehouse>> getWarehouseProducts();
}
