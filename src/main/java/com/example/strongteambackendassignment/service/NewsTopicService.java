package com.example.strongteambackendassignment.service;

import com.example.strongteambackendassignment.entity.NewsTopic;
import com.example.strongteambackendassignment.repository.NewsTopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NewsTopicService {
    private final NewsTopicRepository newsTopicRepository;

    @Autowired
    public NewsTopicService(NewsTopicRepository newsTopicRepository) {
        this.newsTopicRepository = newsTopicRepository;
    }

    public List<NewsTopic> getAllNewsTopics() {
        return newsTopicRepository.findAll();
    }

    public NewsTopic getNewsTopicById(Long id) {
        return newsTopicRepository.findById(id).orElse(null);
    }

    public NewsTopic saveNewsTopic(NewsTopic newsTopic) {
        return newsTopicRepository.save(newsTopic);
    }

    public void deleteNewsTopic(Long id) {
        newsTopicRepository.deleteById(id);
    }
}
