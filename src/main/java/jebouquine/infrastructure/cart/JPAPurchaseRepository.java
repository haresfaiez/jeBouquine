package jebouquine.infrastructure.cart;

import jebouquine.domain.books.Book;
import jebouquine.domain.cart.Purchase;
import jebouquine.domain.cart.PurchaseRepository;
import jebouquine.domain.customer.Customer;
import jebouquine.infrastructure.cart.model.PurchaseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class JPAPurchaseRepository implements PurchaseRepository {

    public static final String SEARCH_BY_CUSTOMER_NAMED_QUERY
            = "PurchaseEntity.searchByCustomer";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addPurchase(Purchase purchase) {
        PurchaseEntity entity = PurchaseEntity.from(purchase);
        entityManager.persist(entity);
        purchase.setId(entity.getId());
    }

    @Override
    public List<Purchase> findPurchasesFor(Customer customer) {
        //TODO:add customer handling
        TypedQuery<PurchaseEntity> query = entityManager
                .createNamedQuery(SEARCH_BY_CUSTOMER_NAMED_QUERY, PurchaseEntity.class);
        return query
                .getResultList()
                .stream()
                .map(purchaseEntity -> purchaseEntity.purchase())
                .collect(Collectors.toList());
    }

    @Override
    public void removePurchase(Purchase purchase) {
        //TODO:add test
        PurchaseEntity purchaseEntity = entityManager.find
                (PurchaseEntity.class, purchase.getId());
        entityManager.remove(purchaseEntity);
    }

    @Override
    public Purchase findPurchase(Customer currentCustomer, Book book) {
        return null;
    }
}
