package jebouquine.service.cart.viewmodel;

import java.util.Date;

public class PurchaseViewModel {

    private String bookISBN;
    private String bookTitle;
    private Date purchaseDate;

    public PurchaseViewModel() {
    }

    public PurchaseViewModel(String bookISBN, String bookTitle, Date purchaseDate) {
        this.bookISBN = bookISBN;
        this.bookTitle = bookTitle;
        this.purchaseDate = purchaseDate;
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
        return !(purchaseDate != null ? !purchaseDate.equals(that.purchaseDate) : that.purchaseDate != null);

    }

    @Override
    public int hashCode() {
        int result = bookISBN != null ? bookISBN.hashCode() : 0;
        result = 31 * result + (bookTitle != null ? bookTitle.hashCode() : 0);
        result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
        return result;
    }

    public static PurchaseViewModel from(String bookISBN, String bookTitle, Date
            purchaseDate) {
        return new PurchaseViewModel(bookISBN, bookTitle, purchaseDate);
    }

    public static PurchaseViewModel now(String bookISBN, String bookTitle) {
        return new PurchaseViewModel(bookISBN, bookTitle, new Date());
    }
}
