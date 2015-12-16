package acceptance.factory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PurchaseToBook {
    public static List<String> from(List<String> purchase, String bookISBN) {
        return Stream.of(bookISBN, purchase.get(0), purchase.get(1), "Some summary",
                "Faiez").collect(Collectors.toList());
    }
}
