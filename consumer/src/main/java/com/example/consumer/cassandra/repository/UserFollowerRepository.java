package com.example.consumer.cassandra.repository;

import com.example.consumer.cassandra.model.UserFollower;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserFollowerRepository extends CassandraRepository<UserFollower, String> {
}
