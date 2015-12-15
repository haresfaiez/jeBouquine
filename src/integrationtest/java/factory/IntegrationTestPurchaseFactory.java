package factory;

import jebouquine.service.cart.viewmodel.PurchaseViewModel;

public class IntegrationTestPurchaseFactory {
    public static PurchaseViewModel createRandomPurchaseViewModel() {
        final String bookISBN = String.format("ISBN %s", Math.random());
        final String bookTitle = String.format("title %s", Math.random());
        return PurchaseViewModel.now(bookISBN, bookTitle);
    }
}
