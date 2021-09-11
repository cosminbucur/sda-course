package com.sda.testing.tdd.shop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ShoppingCartTest {

    @Test
    void givenBook_whenAdd_thenReturnBook() {
        // given
        Basket basket = new Basket();
        Book book = new Book("game of thrones", "george martin", 20);

        // when
        basket.addBook(book);

        // then
        assertThat(basket.findAll().size()).isEqualTo(1);
    }

    @Test
    void given2Books_whenFindAll_thenReturnBooks() {
        // given
        Basket basket = new Basket();
        Book book1 = new Book("game of thrones 1", "george martin", 20);
        Book book2 = new Book("game of thrones 2", "george martin", 30);
        basket.addBook(book1);
        basket.addBook(book2);

        // when
        List<Book> actualBooks = basket.findAll();

        // then
        assertThat(actualBooks.size()).isEqualTo(2);
    }

    @Test
    void givenBook_whenClear_thenBasketShouldBeEmpty() {
        // given
        Basket basket = new Basket();
        Book book = new Book("game of thrones", "george martin", 20);
        basket.addBook(book);

        // when
        basket.clear();

        // then
        assertThat(basket.findAll().size()).isZero();
    }

    @Test
    void given2Books_whenSumPrices_thenReturnCorrectTotalPrice() {
        // given
        Basket basket = new Basket();
        Book book1 = new Book("game of thrones 1", "george martin", 20);
        Book book2 = new Book("game of thrones 2", "george martin", 30);
        basket.addBook(book1);
        basket.addBook(book2);

        // when
        int actualPrice = basket.sumPrices();

        // then
        assertThat(actualPrice).isEqualTo(50);
    }
}
