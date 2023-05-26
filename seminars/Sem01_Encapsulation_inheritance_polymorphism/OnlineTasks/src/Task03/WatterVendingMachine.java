package Task03;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class WatterVendingMachine implements VendingMachine{

    private Map<Integer, LinkedList<Product>> hashProducts;

    public WatterVendingMachine(Map<Integer, LinkedList<Product>> hashProducts) {
        this.hashProducts = hashProducts;
    }

    public WatterVendingMachine() {
        this(new HashMap<>());
    }

    @Override
    public Map<Integer, LinkedList<Product>> getProducts() {
        return this.hashProducts;
    }

    @Override
    public Product getProduct(int id) {
        return this.hashProducts.get(id).getLast();
    }

    @Override
    public void putProduct(int id, Product product) {
        this.hashProducts.get(id).addFirst(product);
    }

    @Override
    public void putProducts(int id, LinkedList<Product> products) {
        this.hashProducts.put(id, products);
    }

    @Override
    public void loadMachine(Map<Integer, LinkedList<Product>> products) {
        this.hashProducts = products;
    }
}
