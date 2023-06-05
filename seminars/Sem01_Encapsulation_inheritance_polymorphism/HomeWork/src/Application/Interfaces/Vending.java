package Application.Interfaces;

import java.util.List;

public interface Vending {
    boolean isWorking();
    void putProduct(Products product);
    void putProducts(List<Products> products);
    Products getProduct(String name);
}
