package jebouquine.service.books.viewmodel;

import jebouquine.domain.books.Book;

public class AddBookViewModel {

    private String ISBN;
    private String title;

    public AddBookViewModel() {
    }

    public AddBookViewModel(String ISBN, String title) {
        this.ISBN = ISBN;
        this.title = title;
    }

    public AddBookViewModel(Book book) {
        this.ISBN = book.getISBN();
        this.title = book.getTitle();
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

        AddBookViewModel that = (AddBookViewModel) o;

        if (ISBN != null ? !ISBN.equals(that.ISBN) : that.ISBN != null)
            return false;
        return !(title != null ? !title.equals(that.title) : that.title != null);

    }

    @Override
    public int hashCode() {
        int result = ISBN != null ? ISBN.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    public static AddBookViewModel from(Book book) {
        return new AddBookViewModel(book);
    }

    public Book book() {
        return new Book(ISBN, title);
    }
}
