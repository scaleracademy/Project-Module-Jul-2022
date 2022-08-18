package com.scaler.blog_app.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringModifierServiceTests {
    private StringModifierService strModSvc;

    public StringModifierServiceTests() {
        strModSvc = new StringModifierService();
    }

    @Test
    public void removeSpecialCharactersWorks() {
        var input = "Hello World!";
        var expected = "Hello World";
        var actual = strModSvc.removeSpecialCharacters(input);
        assertEquals(expected, actual);
    }

    @Test
    public void slugifyWorks() {
        var input = "Hello World!";
        var expected = "hello-world";
        var actual = strModSvc.slugify(input);
        assertEquals(expected, actual);
    }
}
