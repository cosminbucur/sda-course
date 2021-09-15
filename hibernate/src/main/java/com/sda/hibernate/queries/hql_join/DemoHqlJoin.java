package com.sda.hibernate.queries.hql_join;

import java.util.List;

// https://dzone.com/articles/how-to-decide-between-join-and-join-fetch
public class DemoHqlJoin {

    public static void main(String[] args) {

        // given
        // author 1:
        //      book1 - 30
        // author 2:
        //      book2 - 20
        //      book3 - 30
        // author 3:
        //      no books
        // should return 2 authors with book price = 30
        Book book1 = new Book();
        book1.setTitle("Test One");
        book1.setPrice(30);

        Book book2 = new Book();
        book2.setTitle("Test Two");
        book2.setPrice(20);

        Book book3 = new Book();
        book3.setTitle("Test Three");
        book3.setPrice(30);

        Author author1 = new Author();
        author1.setAuthorName("author1");
        author1.addBook(book1);

        Author author2 = new Author();
        author2.setAuthorName("author2");
        author2.addBook(book2);
        author2.addBook(book3);

        Author author3 = new Author();
        author3.setAuthorName("author3");

        AuthorDao authorDao = new AuthorDao();
        authorDao.create(author1);
        authorDao.create(author2);
        authorDao.create(author3);

//        List<Author> result = authorDao.findAuthorsWithBookPriceInnerJoin(30);
        List<Author> result = authorDao.findAuthorsWithBookPriceJoinFetch(30);
        System.out.println(result);
    }
}
