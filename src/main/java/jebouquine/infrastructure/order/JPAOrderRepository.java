package jebouquine.infrastructure.order;

import jebouquine.domain.order.Order;
import jebouquine.domain.order.OrderRepository;
import jebouquine.infrastructure.order.model.OrderEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class JPAOrderRepository implements OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addOrder(Order order) {
        //TODO:add test
        OrderEntity entity = OrderEntity.from(order);
        entityManager.persist(entity);
        order.setId(entity.getId());
    }
}
