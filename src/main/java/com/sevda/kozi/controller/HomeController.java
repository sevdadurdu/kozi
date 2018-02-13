package com.sevda.kozi.controller;

import com.sevda.kozi.repository.MakeupItemRepository;
import com.sevda.kozi.models.*;
import com.sevda.kozi.service.HomeService;
import com.sevda.kozi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {


    @Autowired
    MakeupItemRepository makeupItemRepository;

    @Autowired
    HomeService homeService;

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = {"/home", "/"})
    public HomeResponseModel home() {

        return homeService.getHomeResponse();
    }

    @RequestMapping(value = "/item/{id}")
    public ItemResponseModel getById(@PathVariable Long id) {

        return itemService.getById(id);
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
    public DeleteItemResponseModel delete(@PathVariable Long id) {

        return itemService.delete(id);
    }

    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public PostItemResponseModel post(@RequestBody PostItemRequestModel postItemRequestModel) {
        MakeupItem makeupItem = new MakeupItem();
        makeupItem.setDescription(postItemRequestModel.getDescription());
        makeupItem.setName(postItemRequestModel.getName());
        makeupItem.setRate(postItemRequestModel.getRate());
        return itemService.post(makeupItem);
    }
}
