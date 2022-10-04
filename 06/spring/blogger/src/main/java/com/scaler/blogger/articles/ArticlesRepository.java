package com.scaler.blogger.articles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticlesRepository extends JpaRepository<ArticleEntity, Integer> {

    List<ArticleEntity> findByHeadingContainsIgnoreCase(String heading);

    Optional<ArticleEntity> findBySlug(String slug);

}
