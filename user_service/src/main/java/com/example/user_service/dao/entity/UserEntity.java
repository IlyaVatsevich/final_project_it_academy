package com.example.user_service.dao.entity;

import com.example.user_service.dao.enums.UserRole;
import com.example.user_service.dao.enums.UserStatus;
import org.springframework.data.annotation.ReadOnlyProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users",schema = "final_project_user")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 84661L;

    private UUID uuid;

    private LocalDateTime dtCreate;

    private LocalDateTime dtUpdate;

    private String mail;

    private String nick;

    private UserStatus status;

    private Set<UserRole> role;

    private String password;

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

    @Column(unique = true)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Enumerated(EnumType.STRING)
    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @ElementCollection(targetClass = UserRole.class,fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "uuid"))
    @Enumerated(EnumType.STRING)
    public Set<UserRole> getRole() {
        return role;
    }

    public void setRole(Set<UserRole> role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
