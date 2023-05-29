package App.Objects;

import App.AbstractClasses.Cassette;
import App.AbstractClasses.Product;

import java.util.ArrayList;
import java.util.List;

public class CanCassette extends Cassette {

    public CanCassette(Integer capacity) {
        super(capacity);
    }

    public CanCassette() {
        this(10);
    }


    private void placeProduct(Product product) {
        super.cassette.addLast(product);
    }

    @Override
    public boolean putProduct(Product product) {
        if (product == null
                || !super.checkCapacity(1)) return false;
        placeProduct(product);
        return true;
    }

    @Override
    public boolean putProducts(List<Product> products) {
        if (products == null
                || products.size() == 0
                || !super.checkCapacity(products.size())) return false;
        for (Product product :
                products) {
            placeProduct(product);
        }
        products.clear();
        return true;
    }

    @Override
    public Product peekProduct() {
        return super.cassette.peekFirst();
    }

    @Override
    public Product popProduct() {
        return super.cassette.pollFirst();
    }

    @Override
    public List<Product> popProducts(int numberOfProducts) {
        List<Product> products = new ArrayList<>();
        if (super.cassette.size() < numberOfProducts
                || numberOfProducts == 0) return products;
        for (int i = 0; i < numberOfProducts; i++) {
            products.add(popProduct());
        }
        return products;
    }
}
