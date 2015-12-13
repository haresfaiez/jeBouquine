package jebouquine.domain.books;


import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> findBookByISBN(String ISBN);
    void addBook(Book expectedBook);
    List<Book> findBooksByTitle(String title);
}
