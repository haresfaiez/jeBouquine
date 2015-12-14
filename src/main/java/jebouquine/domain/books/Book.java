package jebouquine.domain.books;

import java.util.concurrent.atomic.AtomicInteger;

public class Book {
    private String ISBN;
    private String title;
    private AtomicInteger price;
    private String summary;
    private String author;

    public Book(String ISBN, String title, AtomicInteger price, String summary, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.price = price;
        this.summary = summary;
        this.author = author;
    }

    public Book() {
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

        Book book = (Book) o;

        if (ISBN != null ? !ISBN.equals(book.ISBN) : book.ISBN != null)
            return false;
        if (title != null ? !title.equals(book.title) : book.title != null)
            return false;
        if (price != null ? !new Integer(price.get()).equals(book.price.get()) : book
                .price !=
                null)
            return false;
        if (summary != null ? !summary.equals(book.summary) : book.summary != null)
            return false;
        return !(author != null ? !author.equals(book.author) : book.author != null);

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

    public static Book from(String ISBN, String title, AtomicInteger price,
                            String summary, String author) {
        return new Book(ISBN, title, price, summary, author);
    }
}
