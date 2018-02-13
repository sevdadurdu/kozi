package com.sevda.kozi.models;

/**
 * Created by Toshibaa on 13.2.2018.
 */
public class PostItemResponseModel {

    private MakeupItem item;
    private int statusCode;

    public MakeupItem getItem() {
        return item;
    }

    public void setItem(MakeupItem item) {
        this.item = item;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
