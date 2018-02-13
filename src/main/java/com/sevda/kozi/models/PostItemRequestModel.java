package com.sevda.kozi.models;

/**
 * Created by Toshibaa on 13.2.2018.
 */
public class PostItemRequestModel {

    private String name;

    private String description;

    private Double rate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
