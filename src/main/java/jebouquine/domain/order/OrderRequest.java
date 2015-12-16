package jebouquine.domain.order;

import java.time.Instant;
import java.util.Date;

public class OrderRequest {
    private String customerName;
    private String customerPhone;
    private Date expeditionDate;
    private String paymentMethod;
    private String deliveryAddress;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderRequest that = (OrderRequest) o;

        if (customerName != null ? !customerName.equals(that.customerName) : that.customerName != null)
            return false;
        if (customerPhone != null ? !customerPhone.equals(that.customerPhone) : that.customerPhone != null)
            return false;
        //TODO:fix this
//        if (expeditionDate != null ? !expeditionDate.equals(that.expeditionDate) : that.expeditionDate != null)
//            return false;
        if (paymentMethod != null ? !paymentMethod.equals(that.paymentMethod) : that.paymentMethod != null)
            return false;
        return !(deliveryAddress != null ? !deliveryAddress.equals(that.deliveryAddress) : that.deliveryAddress != null);

    }

    @Override
    public int hashCode() {
        int result = customerName != null ? customerName.hashCode() : 0;
        result = 31 * result + (customerPhone != null ? customerPhone.hashCode() : 0);
        result = 31 * result + (expeditionDate != null ? expeditionDate.hashCode() : 0);
        result = 31 * result + (paymentMethod != null ? paymentMethod.hashCode() : 0);
        result = 31 * result + (deliveryAddress != null ? deliveryAddress.hashCode() : 0);
        return result;
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

    public OrderRequest(String customerName, String customerPhone, Date expeditionDate, String paymentMethod, String deliveryAddress) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.expeditionDate = expeditionDate;
        this.paymentMethod = paymentMethod;
        this.deliveryAddress = deliveryAddress;
    }

    public static OrderRequest nullObject() {
        return new OrderRequest("","",Date.from(Instant.now()),"","");
    }
}
