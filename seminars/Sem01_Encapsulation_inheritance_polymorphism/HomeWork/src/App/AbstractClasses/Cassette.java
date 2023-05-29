package App.AbstractClasses;

import java.util.LinkedList;
import java.util.List;

public abstract class Cassette {
    protected Integer capacity;
    protected LinkedList<Product> cassette;
    protected Float purchasePrice;

    public Cassette(Integer capacity) {
        this.capacity = capacity;
        this.cassette = new LinkedList<>();
        this.purchasePrice = 0.0f;
    }

    protected boolean checkCapacity(Integer numberOfProducts) {
        return capacity < cassette.size() + numberOfProducts;
    }

    public boolean isEmpty() {
        return cassette.isEmpty();
    }

    public abstract boolean putProduct(Product product);
    public abstract boolean putProducts(List<Product> products);
    public abstract Product peekProduct();
    public abstract Product popProduct();
    public abstract List<Product> popProducts(int numberOfProducts);

    public Float getPurchasePrice() {
        return purchasePrice;
    }

    protected void calculatePurchasePrice() {
        if (cassette.size() == 0) {
            purchasePrice = 0.0f;
            return;
        }

        Float purchaseSum = 0.0f;
        for (Product product : cassette) purchaseSum += product.getPurchasePrice();

        Float newPurchasePrice = purchaseSum / cassette.size();
        if (purchasePrice < newPurchasePrice) purchasePrice = newPurchasePrice;
    }
}
