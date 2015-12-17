package jebouquine.infrastructure.order;

import jebouquine.domain.customer.Customer;
import jebouquine.domain.order.Order;
import jebouquine.domain.order.OrderRepository;
import jebouquine.infrastructure.order.model.OrderEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Order> findOrderById(Integer id) {
        return Optional
                .of(entityManager.find(OrderEntity.class, id))
                .map(orderEntity -> orderEntity.order());
    }

    @Override
    public List<Order> findOrdersFor(Customer customer) {
        return null;
    }
}
