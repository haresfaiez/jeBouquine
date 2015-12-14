package jebouquine.infrastructure.cart;

import jebouquine.domain.cart.Purchase;
import jebouquine.domain.cart.PurchaseRepository;
import jebouquine.infrastructure.cart.model.PurchaseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class JPAPurchaseRepository implements PurchaseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addPurchase(Purchase purchase) {
        entityManager.persist(PurchaseEntity.from(purchase));
    }
}
