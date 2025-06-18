package ru.itis.springdemo_oris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.springdemo_oris.dto.*;
import ru.itis.springdemo_oris.repository.ArticleRepository;
import ru.itis.springdemo_oris.services.ArticleService;

import java.util.List;


@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/addArticle")
    public String addArticle(Model model) {
        System.out.println("*******");
        model.addAttribute("articles", articleService.getAll());
        return "addArticle";
    }

    @GetMapping("/allArticle")
    @ResponseBody
    public ResponseEntity<List<ArticleDto>> allArticle() {
        return ResponseEntity.ok(articleService.getAll());
    }

    @PostMapping("/addArticle")
    @ResponseBody
    public ResponseEntity<ArticleDto> addArticle(@RequestBody ArticleForm articleForm) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(articleService.addArticle(userDetails.getUsername(), articleForm));
    }

    @PostMapping("/likeArticle")
    @ResponseBody
    public ResponseEntity<ArticleDto> likeArticle(@RequestBody ArticleInfoForm articleInfoForm) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ArticleDto articleDto = articleService.like(userDetails.getUsername(), articleInfoForm.getArticleId());
        return ResponseEntity.ok(articleDto);
    }
}
