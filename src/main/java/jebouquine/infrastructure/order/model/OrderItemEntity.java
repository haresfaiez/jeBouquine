package jebouquine.infrastructure.order.model;

import jebouquine.domain.order.customerorder.OrderItem;
import jebouquine.infrastructure.books.model.BookEntity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "ORDER_ITEMS")
@Entity
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private BookEntity book;
    @ManyToOne
    private OrderEntity order;

    public OrderItemEntity(Date date, BookEntity book, OrderEntity order) {
        this.date = date;
        this.book = book;
        this.order = order;
    }

    public OrderItemEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemEntity that = (OrderItemEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        //TODO:// FIXME: 12/16/15
//        if (date != null ? !date.equals(that.date) : that.date != null)
//            return false;
        if (book != null ? !book.equals(that.book) : that.book != null)
            return false;
        return !(order != null ? !order.equals(that.order) : that.order != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (book != null ? book.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }

    public static OrderItemEntity from(OrderItem orderItem, OrderEntity
            orderEntity) {
        return new OrderItemEntity(orderItem.getDate(),
                BookEntity.from(orderItem.getBook()),orderEntity);
    }
}
