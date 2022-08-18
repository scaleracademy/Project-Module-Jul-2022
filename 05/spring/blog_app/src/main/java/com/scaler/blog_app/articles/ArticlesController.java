package com.scaler.blog_app.articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticlesController {

    private ArticlesService articlesService;

    public ArticlesController(ArticlesService articlesService) {
        this.articlesService = articlesService;
    }

    @GetMapping("")
    public List<ArticleEntity> getArticles() {
        return articlesService.getAllArticles();
    }
}
