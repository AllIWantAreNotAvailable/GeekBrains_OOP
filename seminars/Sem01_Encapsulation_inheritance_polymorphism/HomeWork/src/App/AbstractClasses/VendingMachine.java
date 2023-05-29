package App.AbstractClasses;

import App.Objects.VendingPriceList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class VendingMachine {
    protected String name;
    protected Integer capacity;
    protected Map<String, Cassette> assortment;
    protected PriceList priceList;
    protected Float revenue;
    protected Float profit;

    public VendingMachine(String vendingMachineName, int capacity) {
        this.name = vendingMachineName;
        this.capacity = capacity;
        this.assortment = new HashMap<>();
        this.priceList = new VendingPriceList();
        this.revenue = 0.0f;
        this.profit = 0.0f;
    }

    public abstract boolean initProducts(List<Product> products);

    public abstract boolean isEmpty();

    protected abstract void calculateProfit(Product product);

    public String getName() {
        return name;
    }

    public Float getRevenue() {
        return revenue;
    }

    public Float getProfit() {
        return profit;
    }
}
