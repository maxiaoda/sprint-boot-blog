package hello.entity;

import java.time.Instant;

public class User {
    Integer id;
    String username;
    String avatar;
    Instant createdAt;
    Instant updatedAt;

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
        this.avatar = "";
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
