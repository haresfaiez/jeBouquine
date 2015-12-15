package jebouquine.service.cart.viewmodel;

import java.util.List;

public class CartViewModel {

    private List<PurchaseViewModel> purchases;
    private Integer purchasesSum;

    public CartViewModel(List<PurchaseViewModel> purchases, Integer purchasesSum) {
        this.purchases = purchases;
        this.purchasesSum = purchasesSum;
    }

    public CartViewModel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartViewModel that = (CartViewModel) o;

        if (purchases != null ? !purchases.equals(that.purchases) : that.purchases != null)
            return false;
        return !(purchasesSum != null ? !purchasesSum.equals(that
                .purchasesSum) : that.purchasesSum != null);
    }

    @Override
    public int hashCode() {
        int result = purchases != null ? purchases.hashCode() : 0;
        result = 31 * result + (purchasesSum != null ? purchasesSum.hashCode() : 0);
        return result;
    }

    public List<PurchaseViewModel> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<PurchaseViewModel> purchases) {
        this.purchases = purchases;
    }

    public Integer getPurchasesSum() {
        return purchasesSum;
    }

    public void setPurchasesSum(Integer purchasesSum) {
        this.purchasesSum = purchasesSum;
    }

    public static CartViewModel from(List<PurchaseViewModel> purchases,
                                     Integer purchasesSum) {
        return new CartViewModel(purchases, purchasesSum);
    }
}
