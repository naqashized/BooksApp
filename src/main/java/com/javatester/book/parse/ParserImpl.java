package com.javatester.book.parse;

import com.javatester.book.pojo1.Person;
import com.javatester.book.pojo2.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class ParserImpl implements Parser{
    @Override
    public Map<Book.Genre, List<Book>> booksByGenre(List<Book> data, Person author) {
        //Objects.requireNonNull(author, "Author shall not be null");
        Objects.requireNonNull(data, "Book List shall never be null");
        return data.stream().filter(book -> book.getAuthor().equals(author)).collect(groupingBy(Book::getGenre, toList()));
    }

    @Override
    public Map<Book.Size, Long> countOfBooksBySize(List<Book> data) {
        Objects.requireNonNull(data, "Book List shall never be null");
        Map<Book.Size, Long> bookPages = data.stream()
                .collect(Collectors.groupingBy( book -> book.getPages() < 100 ? Book.Size.Small : (book.getPages() >= 300  ? Book.Size.Large : Book.Size.Medium), Collectors.counting()));
        return bookPages;
    }

    @Override
    public List<Book> dateError(List<Book> data) {
        Objects.requireNonNull(data);
        return data.stream().filter(book -> book.getPublishedDate().compareTo( book.getAuthor().getBirthDate()) < 1).collect(Collectors.toList());
    }

    public Book.Size getSize(int pages){
        return pages< 100 ? Book.Size.Small : (pages > 300 ? Book.Size.Large : Book.Size.Medium);
    }
}
