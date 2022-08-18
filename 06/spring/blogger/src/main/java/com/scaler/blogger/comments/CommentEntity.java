package com.scaler.blogger.comments;

import com.scaler.blogger.articles.ArticleEntity;
import com.scaler.blogger.common.BaseEntity;
import com.scaler.blogger.users.UserEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "comments")
public class CommentEntity extends BaseEntity {
    private String title;

    @Column(nullable = false)
    @NonNull
    private String body;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserEntity author;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private ArticleEntity article;
}