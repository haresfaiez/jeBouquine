package jebouquine.infrastructure.cart;

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

    public static final String SEARCH_BY_BOOK_NAMED_QUERY
            = "PurchaseEntity.searchByBook";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addPurchase(Purchase purchase) {
        entityManager.persist(PurchaseEntity.from(purchase));
    }

    @Override
    public List<Purchase> findPurchasesFor(Customer customer) {
        //TODO:add customer handling
        TypedQuery<PurchaseEntity> query = entityManager
                .createNamedQuery(SEARCH_BY_BOOK_NAMED_QUERY, PurchaseEntity.class);
        return  query
                .getResultList()
                .stream()
                .map(purchaseEntity -> purchaseEntity.purchase())
                .collect(Collectors.toList());
    }
}
