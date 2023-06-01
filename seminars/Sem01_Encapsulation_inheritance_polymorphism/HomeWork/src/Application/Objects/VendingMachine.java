package Application.Objects;

import Application.Interfaces.FinalProducts;
import Application.Interfaces.Products;
import Application.Interfaces.Vending;

import java.util.*;

public class VendingMachine implements Vending {

    Map<String, Queue<Products>> assortment;

    public VendingMachine(List<Products> products) {
        this.assortment = new HashMap<>();
        putProducts(products);
    }

    public boolean isEmpty() {
        for (Queue<Products> queue :
                assortment.values()) {
            if (!queue.isEmpty()) return false;
        }
        return true;
    }

    @Override
    public void putProduct(Products product) {
        if (product instanceof FinalProducts) {
            if (assortment.containsKey(product.getName())) assortment.get(product.getName()).offer(product);
            else assortment.put(
                    product.getName(),
                    new LinkedList<>() {{
                        offer(product);
                    }}
            );
        }
    }

    @Override
    public void putProducts(List<Products> products) {
        for (int i = products.size() - 1; i >= 0; i--) {
            if (products.get(i) instanceof FinalProducts) {
                putProduct(products.remove(i));
            }
        }
    }

    @Override
    public Products getProduct(String name) {
        if (!assortment.containsKey(name)) return null;
        return assortment.get(name).poll();
    }

    public Products getProduct(String name, float volume) {
        if (!assortment.containsKey(name)) return null;
        Queue<Products> queue = assortment.get(name);
        return !queue.isEmpty() && queue.peek().getVolume() == volume ? queue.poll() : null;
    }
}
