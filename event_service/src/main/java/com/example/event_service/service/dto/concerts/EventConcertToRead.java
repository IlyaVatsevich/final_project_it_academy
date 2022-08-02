package com.example.event_service.service.dto.concerts;

import com.example.event_service.dao.enums.EventStatus;
import com.example.event_service.dao.enums.EventType;

import java.time.LocalDateTime;
import java.util.UUID;

public class EventConcertToRead {

    private UUID uuid;

    private LocalDateTime dtCreate;

    private LocalDateTime dtUpdate;

    private String title;

    private String description;

    private Long dtEvent;

    private Long dtEndOfSale;

    private EventType type;

    private EventStatus status;

    private UUID category;

    protected EventConcertToRead(){}

    public EventConcertToRead(UUID uuid, LocalDateTime dtCreate, LocalDateTime dtUpdate, String title,
                              String description, Long dtEvent, Long dtEndOfSale,
                              EventType type, EventStatus status, UUID category) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.title = title;
        this.description = description;
        this.dtEvent = dtEvent;
        this.dtEndOfSale = dtEndOfSale;
        this.type = type;
        this.status = status;
        this.category = category;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(LocalDateTime dtCreate) {
        this.dtCreate = dtCreate;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
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

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    public UUID getCategory() {
        return category;
    }

    public void setCategory(UUID category) {
        this.category = category;
    }

    public static class Builder {

        private UUID uuid;

        private LocalDateTime dtCreate;

        private LocalDateTime dtUpdate;

        private String title;

        private String description;

        private Long dtEvent;

        private Long dtEndOfSale;

        private EventType type;

        private EventStatus status;

        private UUID category;

        public Builder setUuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public Builder setDtCreate(LocalDateTime dtCreate) {
            this.dtCreate = dtCreate;
            return this;
        }

        public Builder setDtUpdate(LocalDateTime dtUpdate) {
            this.dtUpdate = dtUpdate;
            return this;
        }

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

        public Builder setType(EventType type) {
            this.type = type;
            return this;
        }

        public Builder setStatus(EventStatus status) {
            this.status = status;
            return this;
        }

        public Builder setCategory(UUID category) {
            this.category = category;
            return this;
        }

        public static Builder create() {
            return new Builder();
        }
        public EventConcertToRead build() {
            return new EventConcertToRead(uuid,dtCreate,dtUpdate,title,description,dtEvent,dtEndOfSale,type,status,category);
        }
    }
}
