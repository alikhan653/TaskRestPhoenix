package kz.iitu.taskrestphoenix.service;

import kz.iitu.taskrestphoenix.model.News;
import kz.iitu.taskrestphoenix.repository.NewsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class NewsServiceImpl implements NewsService{

    private final NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> getNews() {
        List<News> result = newsRepository.findAll();
        log.info("IN getNews - {} news found", result.size());
        return result;
    }

    @Override
    public News getNewsById(Long id) {
        News result = newsRepository.findById(id).orElse(null);

        if(result == null){
            log.warn("IN getNewsById - no news found by id: {}", id);
            return null;
        }

        log.info("IN getNewsById - news: {} found by id: {}", result);
        return result;
    }

    @Override
    public News createNews(News news) {

        News news1 = newsRepository.save(news);

        log.info("IN createNews - news: {} succesfully created", news1);

        return news1;

    }



}
