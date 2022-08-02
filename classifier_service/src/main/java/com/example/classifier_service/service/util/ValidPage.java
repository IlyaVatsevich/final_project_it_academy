package com.example.classifier_service.service.util;

import com.example.classifier_service.service.exceptions.PageSizeIndexException;

public class ValidPage {

    private ValidPage(){}

    public static void pageSizeValid(int page,int size) {
        if (page<=0||size<=0) {
            throw new PageSizeIndexException(page,size);
        }
    }
}
