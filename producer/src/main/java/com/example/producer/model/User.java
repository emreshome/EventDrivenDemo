package com.example.producer.model;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    Long id;
    String name;
    List<Long> followers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Long> followers) {
        this.followers = followers;
    }

    @Override
    public String toString() {
        return String.format("%s [%d]", name, id);
    }
}
