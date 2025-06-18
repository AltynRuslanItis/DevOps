package ru.itis.springdemo_oris.services;

import ru.itis.springdemo_oris.dto.ArticleDto;
import ru.itis.springdemo_oris.dto.ArticleForm;
import ru.itis.springdemo_oris.dto.ServiceDto;

import java.util.List;

public interface ArticleService {

//    ArticleDto addArticle(ArticleForm articleForm);

    List<ArticleDto> getAll();

    List<ArticleDto> getByUser(Long userId);

    ArticleDto addArticle(String username, ArticleForm articleForm);

    ArticleDto like(String username, Long articleId);
}
