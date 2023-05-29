package App.Objects;

import App.AbstractClasses.Cassette;
import App.AbstractClasses.Product;
import App.AbstractClasses.VendingMachine;
import App.Interfaces.Vending;

import java.util.List;
import java.util.Map;

public class CansVendingMachine extends VendingMachine implements Vending {

    public CansVendingMachine(String cansVendingMachineName, int capacity) {
        super(cansVendingMachineName, capacity);
    }

    @Override
    public boolean isEmpty() {
        return super.assortment.size() == 0;
    }

    @Override
    public boolean isFull() {
        return super.assortment.size() == super.capacity;
    }

    @Override
    public boolean initProducts(List<Product> products) {
        boolean allPlaced = false;
        if (isEmpty()) {
            allPlaced = putProducts(products);
        }
        super.priceList.update(this.assortment.values());
        return allPlaced;
    }

    @Override
    protected boolean putProduct(Product product) {
        boolean success = false;
        String item = product.getProductName();
        if (!assortment.containsKey(item)) {
            if (!isFull()) {
                Cassette cassette = new CanCassette();
                success = cassette.putProduct(product);
                assortment.put(item, cassette);
            }
            return success;
        }
        Cassette cassette = assortment.get(item);
        if (cassette.isFull()) return success;
        success = cassette.putProduct(product);
        return success;
    }

    @Override
    public boolean putProducts(List<Product> products) {
        for (int i = products.size() - 1; i >= 0; i--) {
            if (putProduct(products.get(i))) products.remove(i);
        }
        super.priceList.update(this.assortment.values());
        return products.size() == 0;
    }

    @Override
    protected void calculateProfit(Product product) {

    }

    @Override
    public Product getProduct(String name, float cash) {
        return null;
    }

    @Override
    public List<Product> getProducts(Map<String, Integer> specification, float cash) {
        return null;
    }
}
