package jebouquine.domain.cart;

import jebouquine.domain.books.Book;
import jebouquine.domain.customer.Customer;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Purchase {

    private AtomicInteger id;
    private final Date date;
    private final Book book;
    private final Customer customer;

    public Purchase(Integer id, Book book, Customer customer, Date date) {
        this.id = new AtomicInteger(id);
        this.date = date;
        this.book = book;
        this.customer = customer;
    }

    public void setId(Integer id) {
        this.id = new AtomicInteger(id);
    }

    public Date getDate() {
        return date;
    }

    public Book getBook() {
        return book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Integer getId() {
        return id.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        if (id != null ? !id.equals(purchase.id) : purchase.id != null)
            return false;
        //TODO:fix comparison
//        if (date != null ? !date.equals(purchase.date) : purchase.date != null)
//            return false;
        if (book != null ? !book.equals(purchase.book) : purchase.book != null)
            return false;
        return !(customer != null ? !customer.equals(purchase.customer) : purchase.customer != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (book != null ? book.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        return result;
    }

    public static Purchase now(Book book, Customer customer) {
        return new Purchase(0, book, customer, new Date());
    }

    public static Purchase from(Integer id, Book book, Customer customer, Date date) {
        return new Purchase(id, book, customer, date);
    }

}
