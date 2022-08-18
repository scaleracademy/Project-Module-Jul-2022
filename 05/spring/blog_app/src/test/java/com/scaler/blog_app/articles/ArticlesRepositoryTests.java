package com.scaler.blog_app.articles;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ArticlesRepositoryTests {
    @Autowired
    private ArticlesRepository articlesRepository;


    @Test
    public void findAllArticlesWorks() {
        var articles = articlesRepository.findAll();
    }
}
