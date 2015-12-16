package jebouquine.domain.order.customerorder;

import jebouquine.domain.customer.Customer;
import jebouquine.domain.order.Order;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerOrder implements Order {
    private Integer id;
    private String customerName;
    private String customerPhone;
    private Date expeditionDate;
    private String paymentMethod;
    private String deliveryAddress;
    private Customer customer;
    private List<OrderItem> items;

    public CustomerOrder(Integer id, String customerName, String customerPhone, Date expeditionDate, String paymentMethod, String deliveryAddress, Customer customer, List<OrderItem> items) {
        this.id = id;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.expeditionDate = expeditionDate;
        this.paymentMethod = paymentMethod;
        this.deliveryAddress = deliveryAddress;
        this.customer = customer;
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerOrder that = (CustomerOrder) o;

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
        if (customer != null ? !customer.equals(that.customer) : that.customer != null)
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
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (items != null ? items.hashCode() : 0);
        return result;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Override
    public Date getExpeditionDate() {
        return expeditionDate;
    }

    public void setExpeditionDate(Date expeditionDate) {
        this.expeditionDate = expeditionDate;
    }

    @Override
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public List<OrderItem> getItems() {
        return items;
    }

    @Override
    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public static CustomerOrder nullObject() {
        return new CustomerOrder(0,
                "",
                "",
                Date.from(Instant.now()),
                "",
                "",
                Customer.nullObject(),
                new ArrayList<>());
    }

    public static Order from(Integer id, String customerName, String customerPhone, Date expeditionDate, String paymentMethod, String deliveryAddress, Customer customer, List<OrderItem> items) {
        return new CustomerOrder(id, customerName, customerPhone,
                expeditionDate,  paymentMethod, deliveryAddress, customer,
                items);
    }
}
