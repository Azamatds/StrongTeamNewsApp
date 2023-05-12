package com.example.strongteambackendassignment.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "url")
    private String url;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "source_id")
    private NewsSource source;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private NewsTopic topic;

    private LocalDateTime publicationDate;

    public News() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NewsSource getSource() {
        return source;
    }

    public void setSource(NewsSource source) {
        this.source = source;
    }

    public NewsTopic getTopic() {
        return topic;
    }

    public void setTopic(NewsTopic topic) {
        this.topic = topic;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }
}
