package books.web.books;

import jebouquine.service.books.viewmodel.AddBookViewModel;
import jebouquine.service.books.viewmodel.BookViewModel;

import java.util.concurrent.atomic.AtomicInteger;

public class BookFactory {

    //Book test sample
    final static String bookISBN = "AAAA";
    final static String bookTitle = "Hello Spring Test";
    final static AtomicInteger bookPrice = new AtomicInteger(500);
    final static String bookSummary = "Spring summary";
    final static String bookAuthor = "Faiez";


    public static BookViewModel createBookViewModel() {
        return BookViewModel.from(bookISBN, bookTitle, bookPrice,
                    bookSummary, bookAuthor);
    }

    public static AddBookViewModel createAddBookViewModel() {
        return AddBookViewModel.from(bookISBN, bookTitle, bookPrice.get(),
                    bookSummary, bookAuthor);
    }
}
