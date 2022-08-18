package com.scaler.blogger.comments;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<CommentEntity, Integer> {
}