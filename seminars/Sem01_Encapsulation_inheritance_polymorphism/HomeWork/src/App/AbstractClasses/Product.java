package App.AbstractClasses;


public abstract class Product {
    protected String productName;
    protected Float purchasePrice;

    public Product(String productName, Float purchasePrice) {
        this.productName = productName;
        this.purchasePrice = purchasePrice;
    }

    public Product(String productName) {
        this(productName, 0.0f);
    }

    public void setPurchasePrice(Float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Float getPurchasePrice() {
        return purchasePrice;
    }

    public String getProductName() {
        return productName;
    }
}
