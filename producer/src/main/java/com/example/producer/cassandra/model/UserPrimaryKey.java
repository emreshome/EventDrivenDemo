package com.example.producer.cassandra.model;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.time.LocalDateTime;
import java.util.UUID;

@PrimaryKeyClass
public class UserPrimaryKey {

    @PrimaryKeyColumn(name = "first_name", type = PrimaryKeyType.PARTITIONED)
    private String firstName;
    @PrimaryKeyColumn(name = "register_date", ordinal = 0)
    private LocalDateTime registerDate;
    @PrimaryKeyColumn(name = "person_id", ordinal = 1)
    private UUID id;

    public UserPrimaryKey() {
        this.id = UUID.randomUUID();
        this.registerDate = LocalDateTime.now();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
