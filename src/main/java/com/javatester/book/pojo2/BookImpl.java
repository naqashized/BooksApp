package com.javatester.book.pojo2;

import com.javatester.book.pojo1.Person;

import java.time.LocalDate;
import java.util.Objects;

public class BookImpl implements Book{
    private String title;
    private long isbn;
    private Person author;
    private Genre genre;
    private int pages;
    private LocalDate publishedDate;

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public long getISBN() {
        return this.isbn;
    }

    @Override
    public void setISBN(long isbn) {
        this.isbn = isbn;
    }

    @Override
    public Person getAuthor() {
        return this.author;
    }

    @Override
    public void setAuthor(Person author) {
        this.author = author;
    }

    @Override
    public Genre getGenre() {
        return this.genre;
    }

    @Override
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public int getPages() {
        return this.pages;
    }

    @Override
    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public LocalDate getPublishedDate() {
        return this.publishedDate;
    }

    @Override
    public void setPublishedDate(LocalDate published) {
        this.publishedDate = published;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookImpl book = (BookImpl) o;
        return isbn == book.isbn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
