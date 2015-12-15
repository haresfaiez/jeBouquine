package jebouquine.infrastructure.cart.model;

import jebouquine.domain.cart.Purchase;
import jebouquine.domain.customer.Customer;
import jebouquine.infrastructure.books.model.BookEntity;

import javax.persistence.*;
import java.util.Date;

@NamedQueries({
        @NamedQuery(name = "PurchaseEntity.searchByCustomer",
                query = "SELECT purchaseEntity " +
                        "FROM PurchaseEntity  purchaseEntity")
})
@Table(name = "PURCHASES")
@Entity
public class PurchaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PURCHASE_ID")
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne
    private BookEntity book;

    public PurchaseEntity(Date date, BookEntity book) {
        this.date = date;
        this.book = book;
    }

    public PurchaseEntity() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchaseEntity that = (PurchaseEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null)
            return false;
        return !(book != null ? !book.equals(that.book) : that.book != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (book != null ? book.hashCode() : 0);
        return result;
    }

    public static PurchaseEntity from(Purchase purchase) {
        return new PurchaseEntity(purchase.getDate(),
                BookEntity.from(purchase.getBook()));
    }

    public Purchase purchase() {
        //TODO:handle customer
        return Purchase.from(book.book(), Customer.nullObject(), getDate());
    }
}
