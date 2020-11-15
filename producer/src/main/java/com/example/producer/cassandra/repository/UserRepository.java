package com.example.producer.cassandra.repository;

import com.example.producer.cassandra.model.User;
import com.example.producer.cassandra.model.UserPrimaryKey;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserRepository extends CassandraRepository<User, UserPrimaryKey> {
}
