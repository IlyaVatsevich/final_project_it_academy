package com.example.classifier_service.service.exceptions;

import java.util.ArrayList;
import java.util.List;

public class PageSizeIndexException extends RuntimeException {

    private final List<String> exceptionList;

    public PageSizeIndexException(int page,int size){

        exceptionList = new ArrayList<>();

        if (page<=0&&size<=0) {
            exceptionList.add("Page size must be not less then 1");
            exceptionList.add("Page index must be not less then 1");
        } else if (page<=0) {
            exceptionList.add("Page index must be not less then 1");
        } else {
            exceptionList.add("Page size must be not less then 1");
        }
    }

    public List<String> getExceptionList() {
        return exceptionList;
    }
}
