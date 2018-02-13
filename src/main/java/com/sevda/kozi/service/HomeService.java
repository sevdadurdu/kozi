package com.sevda.kozi.service;

import com.sevda.kozi.repository.MakeupItemRepository;
import com.sevda.kozi.models.HomeResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Created by Toshibaa on 13.2.2018.
 */
@Service
public class HomeService {

    @Autowired
    MakeupItemRepository makeupItemRepository;

    public HomeResponseModel getHomeResponse(){
        HomeResponseModel homeResponseModel = new HomeResponseModel();
        try {
            homeResponseModel.setItemList(makeupItemRepository.findAll());
            homeResponseModel.setStatusCode(HttpStatus.OK.value());
        }
        catch (Exception ex){
            homeResponseModel.setItemList(null);
            homeResponseModel.setStatusCode(HttpStatus.BAD_REQUEST.value());
        }
        return homeResponseModel;
    }
}
