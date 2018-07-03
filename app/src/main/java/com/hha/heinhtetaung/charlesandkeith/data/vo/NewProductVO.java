package com.hha.heinhtetaung.charlesandkeith.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by E5 on 6/28/2018.
 */

@Entity(tableName = "products")
public class NewProductVO {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "productId")
    @SerializedName("product-id")
    private String proudctId;

    @ColumnInfo(name = "productImage")
    @SerializedName("product-image")
    private String productImage;

    @ColumnInfo(name = "productTitle")
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
