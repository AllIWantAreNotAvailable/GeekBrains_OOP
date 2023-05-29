package App.Interfaces;

import App.AbstractClasses.Product;

public interface Pricing {
    Float getSalePrice(Product product);
    boolean addProduct(Product product);
    boolean addProduct(Product product, Float purchasePrice);
}
