package com.example.classifier_service.dao.entity;


import javax.persistence.*;


@Entity
@Table(name = "concert_categories",schema = "final_project_classifier")
public class ConcertCategory extends Classifier  {


    private static final long serialVersionUID = 33L;

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
