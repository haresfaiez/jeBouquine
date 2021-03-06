package jebouquine.service.cart;

import jebouquine.domain.books.BookRepository;
import jebouquine.domain.cart.Cart;
import jebouquine.domain.order.OrderRepository;
import jebouquine.service.order.viewmodel.OrderPassingViewModel;
import jebouquine.service.cart.viewmodel.PurchaseViewModel;
import jebouquine.service.order.OrderPassingService;
import jebouquine.service.order.CustomerOrderPassingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerCartService implements CartService {

    private final Cart cart;
    private final BookRepository bookRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public CustomerCartService(Cart cart,
                               BookRepository bookRepository,
                               OrderRepository orderRepository) {
        this.cart = cart;
        this.bookRepository = bookRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void addBookToCart(String bookISBN) {
        cart.addBook(bookRepository.findBookByISBN(bookISBN).get());
    }

    @Override
    public List<PurchaseViewModel> purchases() {
        return cart
                .purchases()
                .stream()
                .map(purchase -> PurchaseViewModel.from(purchase))
                .collect(Collectors.toList());
    }

    @Override
    public Integer purchasesSum() {
        return purchases()
                .stream()
                .mapToInt(purchaseViewModel -> purchaseViewModel.getPrice())
                .sum();
    }

    @Override
    public void removeBookFromCart(String bookISBN) {
        bookRepository
                .findBookByISBN(bookISBN)
                .ifPresent(book -> cart.removeBook(book));
    }

    @Override
    public OrderPassingService orderServiceOf(OrderPassingViewModel orderPassingViewModel) {
        return CustomerOrderPassingService.from
                (orderPassingViewModel.orderRequest(),
                        cart,
                        orderRepository);
    }
}
