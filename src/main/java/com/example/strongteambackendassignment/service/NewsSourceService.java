package com.example.strongteambackendassignment.service;

import com.example.strongteambackendassignment.entity.NewsSource;
import com.example.strongteambackendassignment.repository.NewsSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NewsSourceService {
    private final NewsSourceRepository newsSourceRepository;

    @Autowired
    public NewsSourceService(NewsSourceRepository newsSourceRepository) {
        this.newsSourceRepository = newsSourceRepository;
    }

    public List<NewsSource> getAllNewsSources() {
        return newsSourceRepository.findAll();
    }

    public NewsSource getNewsSourceById(Long id) {
        return newsSourceRepository.findById(id).orElse(null);
    }

    public NewsSource saveNewsSource(NewsSource newsSource) {
        return newsSourceRepository.save(newsSource);
    }

    public void deleteNewsSource(Long id) {
        newsSourceRepository.deleteById(id);
    }
}

