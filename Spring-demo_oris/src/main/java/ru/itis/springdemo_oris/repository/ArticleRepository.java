package ru.itis.springdemo_oris.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.springdemo_oris.models.Article;
import ru.itis.springdemo_oris.models.Service;
import ru.itis.springdemo_oris.models.User;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    boolean existsByArticleIdAndLikesContaining(Long articleId, User user);
}
