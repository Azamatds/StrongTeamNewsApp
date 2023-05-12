package com.example.strongteambackendassignment.controller;

import com.example.strongteambackendassignment.entity.NewsSource;
import com.example.strongteambackendassignment.service.NewsSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news-sources")
public class NewsSourceController {
    private final NewsSourceService newsSourceService;

    @Autowired
    public NewsSourceController(NewsSourceService newsSourceService) {
        this.newsSourceService = newsSourceService;
    }

    @GetMapping
    public ResponseEntity<?> getAllNewsSources() {
        return ResponseEntity.ok(newsSourceService.getAllNewsSources());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNewsSourceById(@PathVariable Long id) {
        NewsSource newsSource = newsSourceService.getNewsSourceById(id);
        if (newsSource != null) {
            return ResponseEntity.ok(newsSource);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> createNewsSource(@RequestBody NewsSource newsSource) {
        NewsSource createdNewsSource = newsSourceService.saveNewsSource(newsSource);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNewsSource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateNewsSource(@PathVariable Long id, @RequestBody NewsSource newsSource) {
        NewsSource existingNewsSource = newsSourceService.getNewsSourceById(id);
        if (existingNewsSource != null) {
            newsSource.setId(id);
            NewsSource updatedNewsSource = newsSourceService.saveNewsSource(newsSource);
            return ResponseEntity.ok(updatedNewsSource);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNewsSource(@PathVariable Long id) {
        NewsSource existingNewsSource = newsSourceService.getNewsSourceById(id);
        if (existingNewsSource != null) {
            newsSourceService.deleteNewsSource(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

