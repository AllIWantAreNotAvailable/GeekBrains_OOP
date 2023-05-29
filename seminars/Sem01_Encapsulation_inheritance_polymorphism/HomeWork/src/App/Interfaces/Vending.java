package App.Interfaces;

import App.AbstractClasses.Product;

import java.util.List;
import java.util.Map;

public interface Vending {
    boolean putProducts(List<Product> products);
    Product getProduct(String name, float cash);
    List<Product> getProducts(Map<String, Integer> specification, float cash);
}
