package cart.infrastructure;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import factory.IntegrationTestBookFactory;
import factory.IntegrationTestCustomerFactory;
import jebouquine.domain.books.Book;
import jebouquine.domain.cart.Purchase;
import jebouquine.domain.cart.PurchaseRepository;
import jebouquine.domain.customer.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import spring.context.SpringApplicationTestContext;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = {SpringApplicationTestContext.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
public class JPAPurchaseRepositoryTest {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Test
    @DatabaseSetup("/persistence/cart/add-purchase/add-purchase-setup.xml")
    @ExpectedDatabase("/persistence/cart/add-purchase/add-purchase-expected.xml")
    public void shouldAddPurchase() {
        Book actualBook = IntegrationTestBookFactory.createBook();
        Customer customer = IntegrationTestCustomerFactory.createCustomer();
        //TODO:fix date handling
        Date date = new Date(12, 29, 2014);
        purchaseRepository.addPurchase(Purchase.from(actualBook, customer,
                date));
    }
}
