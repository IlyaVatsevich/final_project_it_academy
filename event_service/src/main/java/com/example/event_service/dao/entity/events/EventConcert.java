package com.example.event_service.dao.entity.events;




import javax.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "events_concerts",schema = "final_project")
public class EventConcert extends Event {

    private static final long serialVersionUID = 90123987826991238L;

    private String title;

    private String description;

    private Long dtEvent;

    private Long dtEndOfSale;

    private UUID category;

    protected EventConcert(){}

    public EventConcert(String title, String description, Long dtEvent,
                        Long dtEndOfSale, UUID category) {

        this.title = title;
        this.description = description;
        this.dtEvent = dtEvent;
        this.dtEndOfSale = dtEndOfSale;
        this.category = category;
    }


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

    public Long getDtEvent() {
        return dtEvent;
    }

    public void setDtEvent(Long dtEvent) {
        this.dtEvent = dtEvent;
    }

    public Long getDtEndOfSale() {
        return dtEndOfSale;
    }

    public void setDtEndOfSale(Long dtEndOfSale) {
        this.dtEndOfSale = dtEndOfSale;
    }

    public UUID getCategory() {
        return category;
    }

    public void setCategory(UUID category) {
        this.category = category;
    }

    public static class Builder {

        private String title;

        private String description;

        private Long dtEvent;

        private Long dtEndOfSale;

        private UUID category;

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

        public Builder setCategory(UUID category) {
            this.category = category;
            return this;
        }
        public static Builder create() {
            return new Builder();
        }

        public EventConcert build() {
            return new EventConcert(title,description,dtEvent,dtEndOfSale,category);
        }
    }
}
