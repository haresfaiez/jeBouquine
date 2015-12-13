package jebouquine.infrastructure.books.model;

import jebouquine.domain.books.Book;

import javax.persistence.*;

//TODO:add attributes validation
@NamedQueries({
        @NamedQuery(name = "BookEntity.searchByTitle",
                query = "SELECT bookEntity FROM BookEntity bookEntity" +
                        " WHERE bookEntity.title like :bookTitle")
})
@Table(name = "BOOKS")
@Entity
public class BookEntity {

    @Id
    private String ISBN;
    private String title;

    public BookEntity(String ISBN, String title) {
        this.ISBN = ISBN;
        this.title = title;
    }

    public BookEntity(Book book) {
        this.ISBN = book.getISBN();
        this.title = book.getTitle();
    }

    public BookEntity() {
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity bookEntity = (BookEntity) o;

        if (!ISBN.equals(bookEntity.ISBN)) return false;
        if (!title.equals(bookEntity.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ISBN.hashCode();
        result = 31 * result + title.hashCode();
        return result;
    }

    public Book createBook() {
        return new Book(ISBN, title);
    }

    public static BookEntity newInstance(String ISBN, String title) {
        return new BookEntity(ISBN, title);
    }

    public static BookEntity nullObject() {
        return new BookEntity("", "");
    }
}
