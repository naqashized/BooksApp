package com.javatester.book.dao;

import com.javatester.book.pojo1.Person;
import com.javatester.book.pojo1.PersonImpl;
import com.javatester.book.pojo2.Book;
import com.javatester.book.pojo2.BookImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    //@Autowired
    private Connection connection;

    public BookServiceImpl(){
        connection = BookDB.getInstance().getConnection();
    }

    @Override
    public List<Book> get() {
        List<Book> bookList = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select book.*, person.*, genre.* from book join person on book.author=person.id join genre on genre.id=book.genre");
            ResultSet rs = ps.executeQuery();

            while ( rs.next() )
            {
                Book book = new BookImpl();
                Person author = new PersonImpl();
                author.setFirstName(rs.getString("firstName"));
                author.setLastName(rs.getString("lastName"));
                author.setBirthDate(rs.getDate("born").toLocalDate());
                book.setAuthor(author);
                book.setTitle(rs.getString("title"));
                book.setISBN(rs.getLong("isbn"));
                book.setGenre(Book.Genre.valueOf(rs.getString("name")));
                book.setPages(rs.getInt("pages"));
                book.setPublishedDate(rs.getDate("published").toLocalDate());
                bookList.add(book);
            }
            rs.close();
            ps.close();
           // connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookList;
    }

    @Override
    public Book get(long isbn) {
        Book book = null;
        try {
            String selectBookByIsbn = "select book.*, person.*, genre.* from book join person on book.author=person.id join genre on genre.id= book.genre where book.isbn=?";
            PreparedStatement ps = connection.prepareStatement(selectBookByIsbn);
            ps.setLong(1, isbn);
            ResultSet rs = ps.executeQuery();

            while ( rs.next() )
            {
                book = new BookImpl();
                Person author = new PersonImpl();
                author.setFirstName(rs.getString("firstName"));
                author.setLastName(rs.getString("lastName"));
                author.setBirthDate(rs.getDate("born").toLocalDate());
                book.setAuthor(author);
                book.setTitle(rs.getString("title"));
                book.setISBN(rs.getLong("isbn"));
                book.setGenre(Book.Genre.valueOf(rs.getString("name")));
                book.setPages(rs.getInt("pages"));
                book.setPublishedDate(rs.getDate("published").toLocalDate());
            }
            rs.close();
            ps.close();
            //connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return book;
    }

    @Override
    public int delete(long isbn) {
        int row = 0;
        try {
            String deleteBookByIsbn = "DELETE FROM book where isbn=?";
            PreparedStatement ps = connection.prepareStatement(deleteBookByIsbn);
            ps.setLong(1, isbn);
            row = ps.executeUpdate();

            ps.close();
            //connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row;
    }


}
