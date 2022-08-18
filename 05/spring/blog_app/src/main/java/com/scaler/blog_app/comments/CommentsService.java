package com.scaler.blog_app.comments;

import org.springframework.stereotype.Service;

@Service
public class CommentsService {
    private CommentsRepository commentsRepository;

    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

}
