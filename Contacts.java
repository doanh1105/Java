package com.example.bttuan2;

public class Contacts {
    Long id;
    String imgAvatar;
    String name;
    Boolean online;

    public Contacts(Long id, String imgAvatar, String name, Boolean online) {
        this.id = id;
        this.imgAvatar = imgAvatar;
        this.name = name;
        this.online = online;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgAvatar() {
        return imgAvatar;
    }

    public void setImgAvatar(String imgAvatar) {
        this.imgAvatar = imgAvatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }
}
