package com.sevda.kozi.models;

import java.util.List;

/**
 * Created by Toshibaa on 13.2.2018.
 */
public class HomeResponseModel {
    private List<MakeupItem> itemList;
    private int statusCode;

    public List<MakeupItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<MakeupItem> itemList) {
        this.itemList = itemList;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
