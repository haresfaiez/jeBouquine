package jebouquine.service.cart.viewmodel;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class OrderViewModel {
    private Integer id;
    private String customerName;
    private String customerPhone;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date expeditionDate;
    private String paymentMethod;
    private String deliveryAddress;

    public OrderViewModel() {
    }

    public OrderViewModel(Integer id, String customerName, String customerPhone, Date expeditionDate, String paymentMethod, String deliveryAddress) {
        this.id = id;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.expeditionDate = expeditionDate;
        this.paymentMethod = paymentMethod;
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderViewModel that = (OrderViewModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (customerName != null ? !customerName.equals(that.customerName) : that.customerName != null)
            return false;
        if (customerPhone != null ? !customerPhone.equals(that.customerPhone) : that.customerPhone != null)
            return false;
        //TODO:fix date comparison
//        if (expeditionDate != null ? !expeditionDate.equals(that.expeditionDate) : that.expeditionDate != null)
//            return false;
        if (paymentMethod != null ? !paymentMethod.equals(that.paymentMethod) : that.paymentMethod != null)
            return false;
        return !(deliveryAddress != null ? !deliveryAddress.equals(that.deliveryAddress) : that.deliveryAddress != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (customerPhone != null ? customerPhone.hashCode() : 0);
        result = 31 * result + (expeditionDate != null ? expeditionDate.hashCode() : 0);
        result = 31 * result + (paymentMethod != null ? paymentMethod.hashCode() : 0);
        result = 31 * result + (deliveryAddress != null ? deliveryAddress.hashCode() : 0);
        return result;
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

    public static OrderViewModel from(Integer id, OrderPassingViewModel
                                              orderPassingViewModel) {
        return new OrderViewModel(id, orderPassingViewModel.getCustomerName(),
                orderPassingViewModel.getCustomerPhone(),
                orderPassingViewModel.getExpeditionDate(),
                orderPassingViewModel.getPaymentMethod(),
                orderPassingViewModel.getDeliveryAddress());
    }


}
