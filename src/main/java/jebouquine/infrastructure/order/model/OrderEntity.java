package jebouquine.infrastructure.order.model;

import jebouquine.domain.customer.Customer;
import jebouquine.domain.order.Order;
import jebouquine.domain.order.customerorder.CustomerOrder;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@NamedQueries({
        @NamedQuery(name = "OrderEntity.searchByCustomer",
                query = "SELECT orderEntity " +
                        "FROM OrderEntity orderEntity")
})
@Table(name = "ORDERS")
@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String customerName;
    private String customerPhone;
    @Temporal(TemporalType.DATE)
    private Date expeditionDate;
    private String paymentMethod;
    private String deliveryAddress;
    //TODO:add customer relation
    @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE)
    private List<OrderItemEntity> items;

    public OrderEntity(String customerName, String customerPhone, Date expeditionDate, String paymentMethod, String deliveryAddress, List<OrderItemEntity> items) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.expeditionDate = expeditionDate;
        this.paymentMethod = paymentMethod;
        this.deliveryAddress = deliveryAddress;
        this.items = items;
    }

    public OrderEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Date getExpeditionDate() {
        return expeditionDate;
    }

    public void setExpeditionDate(Date expeditionDate) {
        this.expeditionDate = expeditionDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<OrderItemEntity> getItems() {
        return items;
    }

    public void setItems(List<OrderItemEntity> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (customerName != null ? !customerName.equals(that.customerName) : that.customerName != null)
            return false;
        if (customerPhone != null ? !customerPhone.equals(that.customerPhone) : that.customerPhone != null)
            return false;
        //TODO:// FIXME: 12/16/15
//        if (expeditionDate != null ? !expeditionDate.equals(that.expeditionDate) : that.expeditionDate != null)
//            return false;
        if (paymentMethod != null ? !paymentMethod.equals(that.paymentMethod) : that.paymentMethod != null)
            return false;
        if (deliveryAddress != null ? !deliveryAddress.equals(that.deliveryAddress) : that.deliveryAddress != null)
            return false;
        return !(items != null ? !items.equals(that.items) : that.items != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (customerPhone != null ? customerPhone.hashCode() : 0);
        result = 31 * result + (expeditionDate != null ? expeditionDate.hashCode() : 0);
        result = 31 * result + (paymentMethod != null ? paymentMethod.hashCode() : 0);
        result = 31 * result + (deliveryAddress != null ? deliveryAddress.hashCode() : 0);
        result = 31 * result + (items != null ? items.hashCode() : 0);
        return result;
    }

    public static OrderEntity from(Order order) {
        OrderEntity orderEntity = new OrderEntity(order.getCustomerName(),
                order.getCustomerPhone(),
                order.getExpeditionDate(),
                order.getPaymentMethod(),
                order.getDeliveryAddress(),
                null);
        List<OrderItemEntity> orderItems =
                order.getItems().stream().map(orderItem -> OrderItemEntity
                        .from(orderItem, orderEntity)).collect(Collectors.toList());
        orderEntity.setItems(orderItems);
        return orderEntity;
    }

    public Order order() {
        //TODO:fix customer handling
        return CustomerOrder.from(
                getId(),
                getCustomerName(),
                getCustomerPhone(),
                getExpeditionDate(),
                getPaymentMethod(),
                getDeliveryAddress(),
                Customer.nullObject(),
                getItems().stream().map(orderItemEntity -> orderItemEntity
                        .orderItem()).collect(Collectors.toList())
        );
    }
}
