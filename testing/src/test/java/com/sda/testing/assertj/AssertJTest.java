package com.sda.testing.assertj;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class AssertJTest {

    @Test
    public void assertJTest() {
        String text = "abc";
        assertThat(text).isEqualTo("abc");

        String[] stringArray = {"abc", "cde", "efg"};
        assertThat(stringArray)
                .hasSize(3)
                .contains("cde")
                .doesNotContain("xyz");

        List<String> books = new ArrayList<>();
        books.add("book1");
        books.add("book2");
        books.add(null);
        books.add("book3");
        assertThat(books)
                .hasSize(4)
                .contains("book1", "book2")
                .containsNull();
    }
}
