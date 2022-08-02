package com.example.classifier_service.service.dto.countries;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CountryToCreate {

    private String title;

    private String description;

    public CountryToCreate(){}

    public CountryToCreate(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @NotEmpty(message = "Title of country should be filled")
    @Length(min = 2,max = 4,message = "Country title length must be between 2 and 4 character")
    @Pattern(regexp="^[a-zA-Z\\s]*$",message = "Title of country should contain only alphabet characters")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotEmpty(message = "Description of country should be filled")
    @Length(min = 2,max = 25,message = "Country description length must be between 2 and 10 character")
    @Pattern(regexp="^[a-zA-Z\\s]*",message = "Description of country should contain only alphabet characters")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
