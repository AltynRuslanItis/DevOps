package ru.itis.springdemo_oris.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springdemo_oris.dto.ArticleDto;
import ru.itis.springdemo_oris.dto.ArticleForm;
import ru.itis.springdemo_oris.dto.ServiceDto;
import ru.itis.springdemo_oris.models.Article;
import ru.itis.springdemo_oris.models.User;
import ru.itis.springdemo_oris.repository.ArticleRepository;
import ru.itis.springdemo_oris.repository.UsersRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Component
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ArticleRepository articleRepository;

//    @Override
//    public ArticleDto addArticle(ArticleForm articleForm) {
//        Article article = Article.builder()
//                .name(articleForm.getName())
//                .type(articleForm.getType())
//                .text(articleForm.getText())
//                .author(usersRepository.findByEmail("qwe@mail.com").orElseThrow(() -> new EntityNotFoundException("Нет")))
//                .build();
//        articleRepository.save(article);
//        return ArticleDto.from(article);
//    }



    @Override
    public List<ArticleDto> getAll() {
        System.out.println("++++++++++++");
        return ArticleDto.of(articleRepository.findAll());
    }

    @Override
    public List<ArticleDto> getByUser(Long userId) {
        User user = usersRepository.getOne(userId);
        List<Article> articlesOfUser = user.getCreatedArticles();
        return ArticleDto.articleList(articlesOfUser);
    }


    @Override
    public ArticleDto addArticle(String username, ArticleForm articleForm) {
        User user = usersRepository.findByEmail(username).orElseThrow(()-> new EntityNotFoundException("not found"));

        Article newArticle = Article.builder()
                .name(articleForm.getName())
                .type(articleForm.getType())
                .text(articleForm.getText())
                .author(user)
                .build();

        articleRepository.save(newArticle);
        return ArticleDto.from(newArticle);
    }

    @Override
    public ArticleDto like(String username, Long articleId) {
        User user = usersRepository.findByEmail(username).orElseThrow(() -> new EntityNotFoundException("Not found"));
        Article article = articleRepository.getOne(articleId);
        if (articleRepository.existsByArticleIdAndLikesContaining(articleId, user)) {
            article.getLikes().remove(user);
        } else {
            article.getLikes().add(user);
        }
        articleRepository.save(article);
        return ArticleDto.from(article);
    }
}
