package books.stub;

import jebouquine.domain.books.Book;
import jebouquine.domain.books.BookRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InMemoryBookRepository implements BookRepository {

    private final List<Book> bookList;

    public static InMemoryBookRepository create() {
        return new InMemoryBookRepository(generateBooks());
    }

    private static List<Book> generateBooks() {
        List<Book> bookList;
        bookList = Stream.of(
                Book.from("ISBN1", "title1", new AtomicInteger(1), "summary1",
                        "author1"),
                Book.from("ISBN2", "title2", new AtomicInteger(2), "summary2",
                        "author2"),
                Book.from("ISBN3", "title3", new AtomicInteger(3), "summary3",
                        "author3")
        ).collect(Collectors.toList());
        return bookList;
    }

    public Book getAnExistingBook() {
        return bookList.get(0);
    }

    public InMemoryBookRepository(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public Optional<Book> findBookByISBN(String ISBN) {
        return bookList.stream().filter(book -> book.getISBN().equals(ISBN))
                .findFirst();
    }

    @Override
    public void addBook(Book book) {
        bookList.add(book);
    }

    @Override
    public List<Book> findBooksByTitle(String title) {
        return bookList.stream().filter(book -> book.getTitle().equals(title))
                .collect(Collectors.toList());
    }

}
