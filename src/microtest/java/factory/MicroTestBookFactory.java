package factory;

import jebouquine.domain.books.Book;

import java.util.concurrent.atomic.AtomicInteger;

public class MicroTestBookFactory {

    //Book test sample
    public final static String bookISBN = "AAAA";
    public final static String bookTitle = "Hello Spring Test";
    public final static AtomicInteger bookPrice = new AtomicInteger(500);
    public final static String bookSummary = "Spring summary";
    public final static String bookAuthor = "Faiez";

    public static Book createBook() {
        return Book.from(bookISBN, bookTitle, bookPrice,
                    bookSummary, bookAuthor);
    }

}
