package com.hha.heinhtetaung.charlesandkeith.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.hha.heinhtetaung.charlesandkeith.data.vo.NewProductVO;

import java.util.List;

/**
 * Created by E5 on 6/29/2018.
 */

public class GetProductResponse {
    @SerializedName("code")
    @Expose
    private int code;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("apiVersion")
    @Expose
    private String apiVersion;

    @SerializedName("page")
    @Expose
    private String page;

    @SerializedName("newProducts")
    @Expose
    private List<NewProductVO> newProductVOList;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<NewProductVO> getNewProductVOList() {
        return newProductVOList;
    }

    public void setNewProductVOList(List<NewProductVO> newProductVOList) {
        this.newProductVOList = newProductVOList;
    }
}
