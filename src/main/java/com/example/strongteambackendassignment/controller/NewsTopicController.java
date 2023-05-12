package com.example.strongteambackendassignment.controller;

import com.example.strongteambackendassignment.entity.NewsTopic;
import com.example.strongteambackendassignment.service.NewsTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news-topics")
public class NewsTopicController {
    private final NewsTopicService newsTopicService;

    @Autowired
    public NewsTopicController(NewsTopicService newsTopicService) {
        this.newsTopicService = newsTopicService;
    }

    @GetMapping
    public ResponseEntity<?> getAllNewsTopics() {
        return ResponseEntity.ok(newsTopicService.getAllNewsTopics());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNewsTopicById(@PathVariable Long id) {
        NewsTopic newsTopic = newsTopicService.getNewsTopicById(id);
        if (newsTopic != null) {
            return ResponseEntity.ok(newsTopic);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> createNewsTopic(@RequestBody NewsTopic newsTopic) {
        NewsTopic createdNewsTopic = newsTopicService.saveNewsTopic(newsTopic);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNewsTopic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateNewsTopic(@PathVariable Long id, @RequestBody NewsTopic newsTopic) {
        NewsTopic existingNewsTopic = newsTopicService.getNewsTopicById(id);
        if (existingNewsTopic != null) {
            newsTopic.setId(id);
            NewsTopic updatedNewsTopic = newsTopicService.saveNewsTopic(newsTopic);
            return ResponseEntity.ok(updatedNewsTopic);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNewsTopic(@PathVariable Long id) {
        NewsTopic existingNewsTopic = newsTopicService.getNewsTopicById(id);
        if (existingNewsTopic != null) {
            newsTopicService.deleteNewsTopic(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

