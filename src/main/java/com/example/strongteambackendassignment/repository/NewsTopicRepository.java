package com.example.strongteambackendassignment.repository;

import com.example.strongteambackendassignment.entity.NewsTopic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsTopicRepository extends JpaRepository<NewsTopic, Long> {
    // No additional methods needed as JpaRepository provides basic CRUD operations
}

