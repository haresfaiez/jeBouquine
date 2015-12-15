package acceptance.factory;

import java.util.List;

public class ListToBook {
    public static String titleOf(List<String> bookEntry) {
        return bookEntry.get(1);
    }

    public static String ISBNOf(List<String> book) {
        return book.get(0);
    }
}
