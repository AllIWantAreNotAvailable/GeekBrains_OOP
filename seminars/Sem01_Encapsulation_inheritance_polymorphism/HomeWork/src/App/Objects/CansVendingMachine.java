package App.Objects;

import App.AbstractClasses.Cassette;
import App.AbstractClasses.Product;
import App.AbstractClasses.VendingMachine;
import App.Interfaces.Vending;

import java.util.List;

public class CansVendingMachine extends VendingMachine implements Vending {

    public CansVendingMachine(String cansVendingMachineName, int capacity) {
        super(cansVendingMachineName, capacity);
    }

    @Override
    public boolean isEmpty() {
        boolean flag = true;
        if (super.assortment.size() == 0) return flag;
        for (Cassette cassette :
                super.assortment.values()) {
            if (!cassette.isEmpty()) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    @Override
    public boolean initProducts(List<Product> products) {
        if (!isEmpty()) return false;
        // TODO: 29.05.2023 Закончить метод
        return true;
    }

    @Override
    protected void calculateProfit(Product product) {

    }

    @Override
    public boolean putProduct(Product product) {
        return false;
    }

    @Override
    public boolean putProducts(List<Product> products) {
        return false;
    }

    @Override
    public Product getProduct(String name, float cash) {
        return null;
    }

    @Override
    public List<Product> getProducts(List<String> names, float cash) {
        return null;
    }
}
