package cart.service;

import jebouquine.domain.books.Book;
import jebouquine.domain.books.BookRepository;
import jebouquine.domain.cart.Cart;
import jebouquine.domain.cart.Purchase;
import jebouquine.domain.customer.Customer;
import jebouquine.domain.order.OrderRepository;
import jebouquine.service.cart.CustomerCartService;
import jebouquine.service.cart.viewmodel.PurchaseViewModel;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

public class CustomerCartServiceTest {

    private CustomerCartService cartService;
    private Cart cartMock;
    private Customer customer;
    private List<Purchase> cartPurchases;

    @Test
    public void shouldRemoveAnExistingBookPurchaseFromCart() {
        Book expectedBook = cartPurchases.get(0).getBook();

        cartService.removeBookFromCart(expectedBook.getISBN());

        verify(cartMock, times(1)).removeBook(expectedBook);
    }

    @Test
    public void shouldCalculateCurrentCustomerPurchasesSum() {
        Integer expectedSum
                = cartPurchases
                .stream()
                .mapToInt(purchase -> purchase.getBook().getPrice().intValue())
                .sum();

        Integer actualSum = cartService.purchasesSum();

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void shouldReturnCurrentCustomerPurchases() {
        List<PurchaseViewModel> expectedPurchaseListViewModel
                = cartPurchases
                .stream()
                .map(purchase -> PurchaseViewModel.from(purchase))
                .collect(Collectors.toList());

        List<PurchaseViewModel> actualPurchaseListViewModel
                = cartService.purchases();

        assertEquals(expectedPurchaseListViewModel, actualPurchaseListViewModel);

    }

    @Test
    public void shouldAddABookToTheCatalogWhenGivenAnExistingBookISBN() {
        Book expectedBook = cartPurchases.get(0).getBook();

        cartService.addBookToCart(expectedBook.getISBN());

        verify(cartMock, times(1)).addBook(expectedBook);
    }

    @Before
    public void setUp() {
        OrderRepository orderRepository = mock(OrderRepository.class);
        customer = Customer.nullObject();
        createDummyCartPurchases();
        BookRepository bookRepository = createBookRepositoryMock();
        createCartMock();
        cartService = new CustomerCartService(cartMock,
                                                bookRepository,
                                                orderRepository);
    }

    private BookRepository createBookRepositoryMock() {
        BookRepository bookRepository
                = mock(BookRepository.class);
        cartPurchases
                .stream()
                .forEach(purchase ->
                        when(bookRepository
                                .findBookByISBN(purchase.getBook().getISBN()))
                                .thenReturn(Optional.of(purchase.getBook())));
        return bookRepository;
    }

    private void createCartMock() {
        cartMock = mock(Cart.class);
        when(cartMock.purchases()).thenReturn(cartPurchases);
    }

    private void createDummyCartPurchases() {
        cartPurchases = new ArrayList<>();
        Book expectedBook = Book.nullObject();
        Purchase expectedPurchase = Purchase.now(expectedBook, customer);
        cartPurchases.add(expectedPurchase);
    }
}
