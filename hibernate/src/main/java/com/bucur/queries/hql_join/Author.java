package com.bucur.queries.hql_join;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "author_name")
    private String authorName;

    @OneToMany(
        mappedBy = "author",
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    // helper methods

    public void addBook(Book book) {
        books.add(book);
        book.setAuthor(this);
    }

    public void removeChild(Book book) {
        books.remove(book);
        book.setAuthor(null);
    }

    @Override
    public String toString() {
        return "Author{" +
            "id=" + id +
            ", authorName='" + authorName + '\'' +
            ", books=" + books +
            '}';
    }
}
