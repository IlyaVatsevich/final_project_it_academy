package com.example.classifier_service.dao.entity;



import javax.persistence.*;


@Entity
@Table(name = "countries",schema = "final_project_classifier")
public class Country extends Classifier {


    private static final long serialVersionUID = 3L;

    private String title;

    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
