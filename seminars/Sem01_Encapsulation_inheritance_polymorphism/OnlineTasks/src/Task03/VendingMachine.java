package Task03;

import java.util.LinkedList;
import java.util.Map;

public interface VendingMachine {
    Map<Integer, LinkedList<Product>> getProducts();
    Product getProduct(int id);
    void putProduct(int id, Product product);
    void putProducts(int id, LinkedList<Product> products);
    void loadMachine(Map<Integer, LinkedList<Product>> products);
}
