package com.scaler.blog_app.articles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticlesRepository extends JpaRepository<ArticleEntity, Long> {

//    @Query("SELECT a FROM articles a WHERE a.slug = ?1")
//    List<ArticleEntity> findArticleEntitiesBySlugContaining(String slug);

    List<ArticleEntity> findArticleEntitiesBySlugContaining(String slug);
}
