package com.example.event_service.dao.entity.events;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "events_films",schema = "final_project")
public class EventFilm extends Event {

    private static final long serialVersionUID = 991283975612391283L;

    private String title;

    private String description;

    private Long dtEvent;

    private Long dtEndOfSale;

    private UUID country;

    private Integer releaseYear;

    private LocalDate releaseDate;

    private Integer duration;

    protected EventFilm(){}

    private EventFilm(String title, String description,
                      Long dtEvent, Long dtEndOfSale, UUID country, Integer releaseYear,
                      LocalDate releaseDate, Integer duration) {
        this.title = title;
        this.description = description;
        this.dtEvent = dtEvent;
        this.dtEndOfSale = dtEndOfSale;
        this.country = country;
        this.releaseYear = releaseYear;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }




    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getDtEvent() {
        return dtEvent;
    }

    public Long getDtEndOfSale() {
        return dtEndOfSale;
    }



    public UUID getCountry() {
        return country;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDtEvent(Long dtEvent) {
        this.dtEvent = dtEvent;
    }

    public void setDtEndOfSale(Long dtEndOfSale) {
        this.dtEndOfSale = dtEndOfSale;
    }

    public void setCountry(UUID country) {
        this.country = country;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public static class Builder {

        private  String title;

        private  String description;

        private Long dtEvent;

        private Long dtEndOfSale;

        private  UUID country;

        private  Integer releaseYear;

        private LocalDate releaseDate;

        private  Integer duration;


        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setDtEvent(Long dtEvent) {
            this.dtEvent = dtEvent;
            return this;
        }

        public Builder setDtEndOfSale(Long dtEndOfSale) {
            this.dtEndOfSale = dtEndOfSale;
            return this;
        }


        public Builder setCountry(UUID country) {
            this.country = country;
            return this;
        }

        public Builder setReleaseYear(Integer releaseYear) {
            this.releaseYear = releaseYear;
            return this;
        }

        public Builder setReleaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Builder setDuration(Integer duration) {
            this.duration = duration;
            return this;
        }

        public static Builder create() {
            return new Builder();
        }

        public EventFilm build(){
            return new EventFilm(title,description,dtEvent, dtEndOfSale,country,releaseYear,releaseDate,duration);
        }
    }
}
