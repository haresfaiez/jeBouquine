package jebouquine.infrastructure.order;

import jebouquine.domain.customer.Customer;
import jebouquine.domain.order.Order;
import jebouquine.domain.order.OrderRepository;
import jebouquine.infrastructure.order.model.OrderEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//TODO:add class tests
@Repository
@Transactional
public class JPAOrderRepository implements OrderRepository {

    private static final java.lang.String SEARCH_BY_CUSTOMER_NAMED_QUERY
            = "OrderEntity.searchByCustomer";
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addOrder(Order order) {
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
        //TODO:handle customer
        TypedQuery<OrderEntity> query = entityManager
                .createNamedQuery(SEARCH_BY_CUSTOMER_NAMED_QUERY,
                    OrderEntity.class);
        return query
                .getResultList()
                .stream()
                .map(orderEntity -> orderEntity.order())
                .collect(Collectors.toList());
    }
}
