package kz.iitu.taskrestphoenix.service;

import kz.iitu.taskrestphoenix.model.News;

import java.util.List;

public interface NewsService {
    List<News> getNews();
    News getNewsById(Long id);
    News createNews(News news);
}
