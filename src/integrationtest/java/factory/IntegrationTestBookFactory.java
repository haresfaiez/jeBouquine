package factory;

import jebouquine.domain.books.Book;
import jebouquine.service.books.viewmodel.AddBookViewModel;
import jebouquine.service.books.viewmodel.BookViewModel;

import java.util.concurrent.atomic.AtomicInteger;

public class IntegrationTestBookFactory {

    //Book test sample
    public final static String bookISBN = "AAAA";
    public final static String bookTitle = "Hello Spring Test";
    public final static AtomicInteger bookPrice = new AtomicInteger(500);
    public final static String bookSummary = "Spring summary";
    public final static String bookAuthor = "Faiez";


    public static BookViewModel createBookViewModel() {
        return BookViewModel.from(bookISBN, bookTitle, bookPrice,
                    bookSummary, bookAuthor);
    }

    public static AddBookViewModel createAddBookViewModel() {
        return AddBookViewModel.from(bookISBN, bookTitle, bookPrice.get(),
                    bookSummary, bookAuthor);
    }

    public static Book createBook() {
        return Book.from(bookISBN, bookTitle, bookPrice, bookSummary,
                bookAuthor);
    }

}
