package com.hha.heinhtetaung.charlesandkeith.network.response;

import com.hha.heinhtetaung.charlesandkeith.data.vo.NewProductVO;

import java.util.List;

/**
 * Created by E5 on 6/29/2018.
 */

public class GetProductResponse {
    private int code;
    private String message;
    private String apiVersion;
    private int page;
    private List<NewProductVO> newProducts;

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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<NewProductVO> getNewProducts() {
        return newProducts;
    }

    public void setNewProducts(List<NewProductVO> newProducts) {
        this.newProducts = newProducts;
    }
}
