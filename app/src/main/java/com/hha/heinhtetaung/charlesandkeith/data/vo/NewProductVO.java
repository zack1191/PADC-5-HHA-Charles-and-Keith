package com.hha.heinhtetaung.charlesandkeith.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by E5 on 6/28/2018.
 */

public class NewProductVO {

    @SerializedName("product-id")
    private String proudctId;

    @SerializedName("product-image")
    private String productImage;

    @SerializedName("product-title")
    private String productTitle;

    public String getProudctId() {
        return proudctId;
    }

    public void setProudctId(String proudctId) {
        this.proudctId = proudctId;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }
}
