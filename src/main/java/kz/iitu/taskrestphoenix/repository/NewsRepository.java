package kz.iitu.taskrestphoenix.repository;

import kz.iitu.taskrestphoenix.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
