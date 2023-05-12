package com.example.strongteambackendassignment.controller;

import com.example.strongteambackendassignment.entity.News;
import com.example.strongteambackendassignment.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
public class NewsController {
    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public ResponseEntity<Page<News>> getAllNews(Pageable pageable) {
        Page<News> newsPage = newsService.getAllNews(pageable);
        return ResponseEntity.ok(newsPage);
    }

    @GetMapping("/sources/{sourceId}")
    public ResponseEntity<Page<News>> getNewsBySourceId(@PathVariable Long sourceId, Pageable pageable) {
        Page<News> newsPage = newsService.getNewsBySourceId(sourceId, pageable);
        return ResponseEntity.ok(newsPage);
    }

    @GetMapping("/topics/{topicId}")
    public ResponseEntity<Page<News>> getNewsByTopicId(@PathVariable Long topicId, Pageable pageable) {
        Page<News> newsPage = newsService.getNewsByTopicId(topicId, pageable);
        return ResponseEntity.ok(newsPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNewsById(@PathVariable Long id) {
        News news = newsService.getNewsById(id);
        if (news != null) {
            return ResponseEntity.ok(news);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<News> createNews(@RequestBody News news) {
        News createdNews = newsService.saveNews(news);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNews);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateNews(@PathVariable Long id, @RequestBody News news) {
        News existingNews = newsService.getNewsById(id);
        if (existingNews != null) {
            news.setId(id);
            News updatedNews = newsService.saveNews(news);
            return ResponseEntity.ok(updatedNews);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNews(@PathVariable Long id) {
        News existingNews = newsService.getNewsById(id);
        if (existingNews != null) {
            newsService.deleteNews(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}