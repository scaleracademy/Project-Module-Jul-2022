package com.scaler.blog_app.articles;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ArticlesControllerTests {

    @Autowired
    private ArticlesController articlesController;

    @Test
    public void getArticlesWorks() {
        var result = articlesController.getArticles();
        assertEquals(0, result.size());
    }
}
