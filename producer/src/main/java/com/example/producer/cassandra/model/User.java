package com.example.producer.cassandra.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Table("user")
public class User implements Serializable {
    @PrimaryKey
    private UserPrimaryKey key;
    private String lastName;

    public User(String name, String surname) {
        this.key = new UserPrimaryKey();
        this.key.setFirstName(name);
        this.lastName = surname;
    }
    public UserPrimaryKey getKey() {
        return key;
    }

    public void setKey(UserPrimaryKey key) {
        this.key = key;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s [%s]", key.getFirstName(), lastName, key.getId());
    }
}
