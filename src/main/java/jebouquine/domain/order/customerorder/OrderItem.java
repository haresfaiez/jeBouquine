package jebouquine.domain.order.customerorder;

import jebouquine.domain.books.Book;
import jebouquine.domain.cart.Purchase;

import java.util.Date;

public class OrderItem {
    private Integer id;
    private final Date date;
    private final Book book;

    public OrderItem(Integer id, Date date, Book book) {
        this.id = id;
        this.date = date;
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        if (id != null ? !id.equals(orderItem.id) : orderItem.id != null)
            return false;
        //TODO:// FIXME: 12/16/15
//        if (date != null ? !date.equals(orderItem.date) : orderItem.date != null)
//            return false;
        return !(book != null ? !book.equals(orderItem.book) : orderItem.book != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (book != null ? book.hashCode() : 0);
        return result;
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

    public Book getBook() {
        return book;
    }

    public static OrderItem from(Purchase purchase) {
        return new OrderItem(purchase.getId(), purchase.getDate(), purchase.getBook());
    }
}
