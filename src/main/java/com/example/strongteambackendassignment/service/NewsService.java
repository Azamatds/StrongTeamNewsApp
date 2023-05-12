package com.example.strongteambackendassignment.service;

import com.example.strongteambackendassignment.entity.News;
import com.example.strongteambackendassignment.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public Page<News> getAllNews(Pageable pageable) {
        return newsRepository.findAll(pageable);
    }

    public Page<News> getNewsBySourceId(Long sourceId, Pageable pageable) {
        return newsRepository.findAllBySourceId(sourceId, pageable);
    }

    public Page<News> getNewsByTopicId(Long topicId, Pageable pageable) {
        return newsRepository.findAllByTopicId(topicId, pageable);
    }

    public News getNewsById(Long id) {
        return newsRepository.findById(id).orElse(null);
    }

    public News saveNews(News news) {
        return newsRepository.save(news);
    }

    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }
}

