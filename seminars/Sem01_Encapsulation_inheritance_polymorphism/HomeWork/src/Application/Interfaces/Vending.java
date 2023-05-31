package Application.Interfaces;

import Application.Abstracts.Product;

import java.util.List;

public interface Vending {
    void putProduct(Products product);
    void putProducts(List<Products> products);
    Products getProduct(String name);
}
