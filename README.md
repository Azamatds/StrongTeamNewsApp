*Java Project 
This is a Java project that aims to perform various operations related to news management.*

# Project Description
The Java project is built using the Spring Boot framework and provides functionality for storing, processing, and displaying news. It consists of three main parts: REST service, security with API token, and a scheduled statistical task.

## Part 1: REST Service
The application provides a RESTful API for managing news sources, news, and news topics. The following API endpoints are available:

### News Sources:

GET /api/news-sources: Get a list of all news sources.
POST /api/news-sources: Create a new news source.
PUT /api/news-sources/{id}: Update an existing news source.
DELETE /api/news-sources/{id}: Delete a news source.
### News:

GET /api/news: Get a list of all news with pagination support.
POST /api/news: Create a new news entry.
PUT /api/news/{id}: Update an existing news entry.
DELETE /api/news/{id}: Delete a news entry.
GET /api/news/source/{sourceId}: Get a list of news by source ID with pagination support.
GET /api/news/topic/{topicId}: Get a list of news by topic ID with pagination support.
### News Topics:

GET /api/news-topics: Get a list of all news topics.
POST /api/news-topics: Create a new news topic.
PUT /api/news-topics/{id}: Update an existing news topic.
DELETE /api/news-topics/{id}: Delete a news topic.
All API methods return data in JSON format.

## Part 2: Security with API Token
The application implements a security mechanism using client token authentication. Users authenticate themselves and receive an API token, which they can use to access protected API endpoints. The Spring Security framework is utilized to handle authentication and authorization.

## Part 3: Scheduled Statistical Task (Optional)
This part of the project includes a scheduled statistical task that runs daily at midnight. The task counts the number of news for each news source and creates a file containing the count for each source. The task utilizes multithreading for improved performance.
