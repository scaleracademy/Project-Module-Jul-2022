package com.scaler.blog_app.common;

import org.springframework.stereotype.Service;

@Service
public class StringModifierService {

    public String removeSpecialCharacters(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", " ").trim();
    }

    public String slugify(String input) {
        return removeSpecialCharacters(input)
                .toLowerCase()
                .replaceAll("[^a-zA-Z0-9]", "-");
    }
}
