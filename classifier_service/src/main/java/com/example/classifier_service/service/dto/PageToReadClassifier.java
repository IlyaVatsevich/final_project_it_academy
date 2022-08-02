package com.example.classifier_service.service.dto;

import com.example.classifier_service.service.dto.api.IPage;

import java.util.List;

public class PageToReadClassifier<T> implements IPage<T> {

    private int number;

    private int size;

    private int totalPages;

    private long totalElements;

    private boolean first;

    private int numberOfElements;

    private boolean last;

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

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    @Override
    public List<T> getContent() {
        return content;
    }
}
