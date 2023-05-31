package Application;

import java.util.*;

public class VendingMachine {
    Map<String, Queue<Product>> products;

    public VendingMachine(List<Product> products) {
        this.products = new HashMap<>();
        for (Product product :
                products) {
            String key = product.getProductName();
            if (this.products.containsKey(key)) this.products.get(key).add(product);
            else this.products.put(key, new LinkedList<>(){{offer(product);}});
        }
    }

    public Product getProduct(String name) {
        if (name != null
                && products.containsKey(name)) {
            Queue<Product> cassette = products.get(name);
            return cassette.poll();
        }
        return null;
    }
}
