package jebouquine.domain.books;

public class Book {
    private String ISBN;
    private String title;

    public Book(String ISBN, String title) {
        this.ISBN = ISBN;
        this.title = title;
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

        if (!ISBN.equals(book.ISBN)) return false;
        if (!title.equals(book.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ISBN.hashCode();
        result = 31 * result + title.hashCode();
        return result;
    }
}