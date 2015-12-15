package jebouquine.domain.cart;

import jebouquine.domain.books.Book;
import jebouquine.domain.customer.Customer;

import java.util.Date;

public class Purchase {

    private final Date date;
    private final Book book;
    private final Customer customer;

    public Purchase(Book book, Customer customer, Date date) {
        this.date = date;
        this.book = book;
        this.customer = customer;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        //TODO:fix date comparison
//        if (date != null ? !(date.compareTo(purchase.date) == 0) : purchase
//                .date !=
//                null)
//            return false;
        if (book != null ? !book.equals(purchase.book) : purchase.book != null)
            return false;
        return !(customer != null ? !customer.equals(purchase.customer) : purchase.customer != null);

    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (book != null ? book.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        return result;
    }

    public static Purchase now(Book book, Customer customer) {
        return new Purchase(book, customer, new Date());
    }

    public static Purchase from(Book book, Customer customer, Date date) {
        return new Purchase(book, customer, date);
    }

}
