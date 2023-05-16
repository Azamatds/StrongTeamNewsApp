package com.example.strongteambackendassignment.schedule;

import com.example.strongteambackendassignment.entity.News;
import com.example.strongteambackendassignment.repository.NewsRepository;
import com.example.strongteambackendassignment.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class NewsStatisticsTask {

    @Autowired
    NewsRepository newsRepository;


    @Scheduled(cron = "0 * * ? * *")
    public void countNewsBySource() {
        List<News> allNews = newsRepository.findAll();

        Map<String, Integer> sourceCounts = new HashMap<>();

        for (News news : allNews) {
            String source = String.valueOf(news.getSource());

            if (sourceCounts.containsKey(source)) {
                sourceCounts.put(source, sourceCounts.get(source) + 1);
            } else {
                sourceCounts.put(source, 1);
            }
        }

        saveCountsToFile(sourceCounts);
    }

    private void saveCountsToFile(Map<String, Integer> sourceCounts) {
        try (FileWriter writer = new FileWriter("news_counts.csv")) {
            writer.write("Source,Count\n");

            for (Map.Entry<String, Integer> entry : sourceCounts.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }

            System.out.println("News counts saved to file.");
        } catch (IOException e) {
            System.err.println("Failed to save news counts to file: " + e.getMessage());
        }
    }
}

