package org.workoutShuffle.entity;

import jakarta.persistence.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Entity
@Table(name="users_information")
public class UserEntity {
    @Id
    @Column(name="user_id")
    int userId;
    @Column(name="username")
    String username;
    @Column(name="password")
    String password;

    public UserEntity() {
    }

    public UserEntity(String username, String password) {
        try {
            this.username = username;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            this.password = messageDigest.digest().toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public UserEntity(int userId, String username, String password) {
        try {
            this.userId = userId;
            this.username = username;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            this.password = messageDigest.digest().toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
