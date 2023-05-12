package com.example.strongteambackendassignment.repository;

import com.example.strongteambackendassignment.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {

    Page<News> findAllBySourceId(Long sourceId, Pageable pageable);

    Page<News> findAllByTopicId(Long topicId, Pageable pageable);
}

