package jebouquine.service.books.viewmodel;


import jebouquine.domain.books.Book;

import java.util.concurrent.atomic.AtomicInteger;

public class BookViewModel {

    private String ISBN;
    private String title;
    private AtomicInteger price;
    private String summary;
    private String author;

    public BookViewModel() {
    }

    public BookViewModel(String ISBN, String title, AtomicInteger price, String summary, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.price = price;
        this.summary = summary;
        this.author = author;
    }

    public BookViewModel(Book book) {
        this.ISBN = book.getISBN();
        this.title = book.getTitle();
        this.price = book.getPrice();
        this.summary =book.getSummary();
        this.author = book.getAuthor();
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

        BookViewModel that = (BookViewModel) o;

        if (ISBN != null ? !ISBN.equals(that.ISBN) : that.ISBN != null)
            return false;
        if (title != null ? !title.equals(that.title) : that.title != null)
            return false;
        if (price != null ? !price.equals(that.price) : that.price != null)
            return false;
        if (summary != null ? !summary.equals(that.summary) : that.summary != null)
            return false;
        return !(author != null ? !author.equals(that.author) : that.author != null);

    }

    @Override
    public int hashCode() {
        int result = ISBN != null ? ISBN.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }

    public AtomicInteger getPrice() {
        return price;
    }

    public void setPrice(AtomicInteger price) {
        this.price = price;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static BookViewModel from(Book book) {
        return new BookViewModel(book);
    }

    public static BookViewModel create(String ISBN, String title, Integer
            price, String summary, String author) {
        return new BookViewModel(ISBN, title, new AtomicInteger(price),
                                    summary, author);
    }

    public static BookViewModel from(String ISBN, String title, AtomicInteger price, String summary, String author) {
        return new BookViewModel(ISBN, title, price, summary, author);
    }
}
