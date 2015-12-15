package jebouquine.service.cart.viewmodel;

import jebouquine.domain.cart.Purchase;

import java.util.Date;

public class PurchaseViewModel {

    private String bookISBN;
    private String bookTitle;
    private Date purchaseDate;
    private Integer price;

    public PurchaseViewModel() {
    }

    public PurchaseViewModel(String bookISBN, String bookTitle, Date purchaseDate, Integer price) {
        this.bookISBN = bookISBN;
        this.bookTitle = bookTitle;
        this.purchaseDate = purchaseDate;
        this.price = price;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchaseViewModel that = (PurchaseViewModel) o;

        if (bookISBN != null ? !bookISBN.equals(that.bookISBN) : that.bookISBN != null)
            return false;
        if (bookTitle != null ? !bookTitle.equals(that.bookTitle) : that.bookTitle != null)
            return false;
        //TODO:fix the comparison below
//        if (purchaseDate != null ? !purchaseDate.equals(that.purchaseDate) : that.purchaseDate != null)
//            return false;
        return !(price != null ? !price.equals(that.price) : that.price != null);

    }

    @Override
    public int hashCode() {
        int result = bookISBN != null ? bookISBN.hashCode() : 0;
        result = 31 * result + (bookTitle != null ? bookTitle.hashCode() : 0);
        result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
        return result;
    }

    public static PurchaseViewModel from(String bookISBN, String bookTitle, Date
            purchaseDate, Integer bookPrice) {
        return new PurchaseViewModel(bookISBN, bookTitle, purchaseDate, bookPrice);
    }

    public static PurchaseViewModel now(String bookISBN, String bookTitle,
                                        Integer bookPrice) {
        return new PurchaseViewModel(bookISBN, bookTitle, new Date(),
                bookPrice);
    }

    public static PurchaseViewModel from(Purchase purchase) {
        return new PurchaseViewModel(purchase.getBook().getISBN(),
                purchase.getBook().getTitle(),
                purchase.getDate(), purchase.getBook().getPrice().get());
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
