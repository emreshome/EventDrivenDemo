package com.example.consumer.messages;

import java.io.Serializable;
import java.util.List;

public class UserFollowerMessage implements Serializable {
    private String id;
    private List<String> followers;

    public UserFollowerMessage() {
    }

    public UserFollowerMessage(String id, List<String> followers) {
        this.id = id;
        this.followers = followers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getFollowers() {
        return followers;
    }

    public void setFollowers(List<String> followers) {
        this.followers = followers;
    }

    @Override
    public String toString() {
        return String.format("[%s]", id);

    }
}
