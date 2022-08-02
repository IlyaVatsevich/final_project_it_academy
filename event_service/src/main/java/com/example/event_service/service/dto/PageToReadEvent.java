package com.example.event_service.service.dto;

import com.example.event_service.service.dto.api.IPage;

import java.util.List;

public class PageToReadEvent<T> implements IPage<T> {

    private int number;

    private int size;

    private int totalPages;

    private int totalElements;

    private boolean isFirst;

    private int numberOfElements;

    private boolean isLast;
    private List<T> content;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    @Override
    public List<T> getContent() {
        return content;
    }
}
