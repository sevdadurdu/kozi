package com.sevda.kozi.service;

import com.sevda.kozi.models.MakeupItem;
import com.sevda.kozi.repository.MakeupItemRepository;
import com.sevda.kozi.models.DeleteItemResponseModel;
import com.sevda.kozi.models.ItemResponseModel;
import com.sevda.kozi.models.PostItemResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Created by Toshibaa on 13.2.2018.
 */

@Service
public class ItemService {

    @Autowired
    private MakeupItemRepository makeupItemRepository;

    public ItemResponseModel getById(long itemId) {
        ItemResponseModel itemResponseModel = new ItemResponseModel();
        try {
            MakeupItem makeupItem = makeupItemRepository.findOne(itemId);
            itemResponseModel.setItem(makeupItem);
            if (makeupItem == null)
                itemResponseModel.setStatusCode(HttpStatus.NO_CONTENT.value());
            else
                itemResponseModel.setStatusCode(HttpStatus.OK.value());

        } catch (Exception ex) {
            itemResponseModel.setItem(null);
            itemResponseModel.setStatusCode(HttpStatus.BAD_REQUEST.value());
        }
        return itemResponseModel;
    }

    public DeleteItemResponseModel delete(long itemId) {
        DeleteItemResponseModel deleteItemResponseModel = new DeleteItemResponseModel();
        try {
            makeupItemRepository.delete(itemId);
            MakeupItem makeupItem = makeupItemRepository.findOne(itemId);
            if (makeupItem == null)
                deleteItemResponseModel.setStatusCode(HttpStatus.OK.value());
            else
                deleteItemResponseModel.setStatusCode(HttpStatus.BAD_REQUEST.value());
        } catch (Exception ex) {
            deleteItemResponseModel.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return deleteItemResponseModel;
    }

    public PostItemResponseModel post(MakeupItem makeupItem) {
        PostItemResponseModel postItemResponseModel = new PostItemResponseModel();
        try {
            MakeupItem makeupItemCheck = makeupItemRepository.save(makeupItem);
            if (makeupItemCheck == null) {
                postItemResponseModel.setStatusCode(HttpStatus.BAD_REQUEST.value());
            } else
                postItemResponseModel.setStatusCode(HttpStatus.OK.value());

            postItemResponseModel.setItem(makeupItemCheck);

        } catch (Exception ex) {
            postItemResponseModel.setItem(null);
            postItemResponseModel.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());

        }
        return postItemResponseModel;
    }

}

