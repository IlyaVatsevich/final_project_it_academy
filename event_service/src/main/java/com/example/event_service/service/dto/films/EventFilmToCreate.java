package com.example.event_service.service.dto.films;

import com.example.event_service.dao.enums.EventType;
import com.example.event_service.service.validation.ValidDate;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class EventFilmToCreate {

    private String title;

    private String description;

    private String country;

    private Integer releaseYear;

    private LocalDate releaseDate;

    private Integer duration;

    private Long dtEvent;

    private Long dtEndOfSale;

    private String status;

    private EventType type;

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    @NotEmpty(message = "Title of event can't be empty")
    @Length(min = 5,max = 55,message = "Title length must be between 5 and 55 characters")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotEmpty(message = "Title of event can't be empty")
    @Length(min = 5,max = 255,message = "Description length must be between 10 and 255 characters")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull(message = "Country must be filled")
    @Pattern(regexp = "[a-f\\d]{8}(?:-[a-f\\d]{4}){4}[a-f\\d]{8}",message = "Country filled not correct")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @NotNull(message = "Release year of film must be filled")
    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    @NotNull(message = "Release date must be filled")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @NotNull(message = "Duration of film must be filled")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
