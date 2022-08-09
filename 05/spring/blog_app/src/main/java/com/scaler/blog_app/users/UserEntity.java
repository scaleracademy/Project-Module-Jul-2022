package com.scaler.blog_app.users;

import com.scaler.blog_app.articles.ArticleEntity;
import com.scaler.blog_app.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    String username;
    @Column(nullable = false)
    @Setter
    String password;
    @Column(nullable = false, unique = true)
    String email;
    @Nullable
    @Setter
    String bio;
    @Nullable
    @Setter
    String image;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Set<ArticleEntity> authoredArticles;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "likers")
    Set<ArticleEntity> likedArticles;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "followers",
            joinColumns = @JoinColumn(name = "following_id"),
            inverseJoinColumns = @JoinColumn(name = "follower_id"))
    Set<UserEntity> followers;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "followers")
    Set<UserEntity> following;
}
