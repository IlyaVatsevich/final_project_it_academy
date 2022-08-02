package com.example.event_service.service.dto.concerts;

import com.example.event_service.dao.enums.EventType;
import com.example.event_service.service.validation.ValidDate;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class EventConcertToCreate {

    private String title;

    private String description;

    private Long dtEvent;

    private Long dtEndOfSale;

    private EventType type;

    private String status;
    private String category;

    @NotEmpty(message = "Title of event can't be empty")
    @Length(min = 2,max = 55,message = "Title length must be between 2 and 55 characters")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotEmpty(message = "Description of event can't be empty")
    @Length(min = 2,max = 255,message = "Description length must be between 2 and 255 characters")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull(message = "Date of event can't be empty")
    @ValidDate(message = "Date of event can't be in past")
    public Long getDtEvent() {
        return dtEvent;
    }

    public void setDtEvent(Long dtEvent) {
        this.dtEvent = dtEvent;
    }

    @NotNull(message = "Date of end of sale can't be empty")
    @ValidDate(message = "Date of end of sale can't be in past")
    public Long getDtEndOfSale() {
        return dtEndOfSale;
    }

    public void setDtEndOfSale(Long dtEndOfSale) {
        this.dtEndOfSale = dtEndOfSale;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @NotNull(message = "Category of concert must be filled")
    @Pattern(regexp = "[a-f\\d]{8}(?:-[a-f\\d]{4}){4}[a-f\\d]{8}",
            message = "Concert category filled not correct")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
