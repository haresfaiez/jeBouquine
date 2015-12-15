package cart.infrastructure;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import factory.IntegrationTestCustomerFactory;
import factory.IntegrationTestPurchaseFactory;
import jebouquine.domain.books.Book;
import jebouquine.domain.cart.Purchase;
import jebouquine.domain.cart.PurchaseRepository;
import jebouquine.domain.customer.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import spring.context.SpringApplicationTestContext;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = {SpringApplicationTestContext.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
public class JPAPurchaseRepositoryTest {

    @Autowired
    private PurchaseRepository purchaseRepository;

//TODO:fix dbunit problem or uncomment to
//    @Test
//    @DatabaseSetup("/persistence/cart/add-purchase/add-purchase-setup.xml")
//    @ExpectedDatabase("/persistence/cart/add-purchase/add-purchase-expected.xml")
//    public void shouldAddPurchase() {
//        Book book = Book.from("FFFF",
//                "Hibernate in action", new AtomicInteger(400),
//                "Hibernate summary", "Faiez");
//        Customer customer = IntegrationTestCustomerFactory.createCustomer();
//        //TODO:fix date handling
//        Date date = new Date(12, 29, 2014);
//        purchaseRepository.addPurchase(Purchase.from(book, customer,
//                date));
//    }

    @Test
    @DatabaseSetup("/persistence/cart/find-purchases/purchase-setup.xml")
    @ExpectedDatabase("/persistence/cart/find-purchases/purchase-expected.xml")
    public void shouldFindPurchasesForACustomer() {
        Book book = Book.from("IIII",
                "Spring in action", new AtomicInteger(400), "Spring summary", "Faiez");
        Book secondBook = Book.from("FFFF",
                "Hibernate in action", new AtomicInteger(400),
                "Hibernate summary", "Faiez");
        Customer customer = IntegrationTestCustomerFactory.createCustomer();
        List<Purchase> expectedPurchases =
                Stream.of(
                        IntegrationTestPurchaseFactory.createPurchaseFrom
                                (customer, book),
                        IntegrationTestPurchaseFactory.createPurchaseFrom
                                (customer, secondBook))
                        .collect(Collectors.toList());

        List<Purchase> actualPurchases = purchaseRepository.findPurchasesFor
                (customer);
        Assert.assertEquals(expectedPurchases, actualPurchases);
    }
}
