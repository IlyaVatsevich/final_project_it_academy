package com.example.event_service.dao.entity.events;

import com.example.event_service.dao.enums.EventStatus;
import com.example.event_service.dao.enums.EventType;
import org.springframework.data.annotation.ReadOnlyProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Event implements Serializable {

    private UUID uuid;

    private LocalDateTime dtCreate;

    private LocalDateTime dtUpdate;

    private EventType type;

    private EventStatus status;

    private Map<String,String> username;

    @ElementCollection(targetClass = String.class,fetch = FetchType.EAGER)
    @JoinTable(name = "user_holder", joinColumns = @JoinColumn(name = "uuid"))
    @MapKeyColumn(name = "role")
    public Map<String,String> getUsername() {
        return username;
    }

    public void setUsername(Map<String,String> username) {
        this.username = username;
    }

    @Id
    @ReadOnlyProperty
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @ReadOnlyProperty
    @Column(name = "date_of_create")
    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(LocalDateTime dtCreate) {
        this.dtCreate = dtCreate;
    }

    @ReadOnlyProperty
    @Version
    @Column(name = "date_of_update")
    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    @Enumerated(EnumType.STRING)
    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    @Enumerated(EnumType.STRING)
    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }
}
