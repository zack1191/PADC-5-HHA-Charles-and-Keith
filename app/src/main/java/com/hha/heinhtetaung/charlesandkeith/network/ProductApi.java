package com.hha.heinhtetaung.charlesandkeith.network;

import com.hha.heinhtetaung.charlesandkeith.network.response.GetProductResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by E5 on 6/28/2018.
 */

public interface ProductApi {

    @FormUrlEncoded
    @POST("getNewProducts.php")
    Observable<GetProductResponse> loadProduct(
            @Field("page") int pageIndex,
            @Field("access_token") String accessToken);


}
