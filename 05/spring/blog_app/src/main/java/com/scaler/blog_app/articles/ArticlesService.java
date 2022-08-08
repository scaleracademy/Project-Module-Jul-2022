package com.scaler.blog_app.articles;

import org.springframework.stereotype.Service;

@Service
public class ArticlesService {
    private ArticlesRepository articlesRepository;

    public ArticlesService(ArticlesRepository articlesRepository) {
        this.articlesRepository = articlesRepository;
    }

    void getAllArticles() {
        articlesRepository.findAll();
    }

    void getArticleById(Long id) {
        articlesRepository.findById(id);
    }

    void getArticleBySlug(String slug) {
        articlesRepository.findArticleEntitiesBySlugContaining(slug);
    }
}
