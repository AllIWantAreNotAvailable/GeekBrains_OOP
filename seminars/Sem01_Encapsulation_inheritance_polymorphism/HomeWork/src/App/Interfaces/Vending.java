package App.Interfaces;

import App.AbstractClasses.Product;

import java.util.List;

public interface Vending {
    boolean putProduct(Product product);
    boolean putProducts(List<Product> products);
    Product getProduct(String name, float cash);
    List<Product> getProducts(List<String> names, float cash);
}
