package App.Objects;

import App.AbstractClasses.Cassette;
import App.AbstractClasses.PriceList;
import App.AbstractClasses.Product;
import App.Interfaces.Pricing;

import java.util.Collection;

public class VendingPriceList extends PriceList implements Pricing {

    public VendingPriceList() {
        super();
    }

    @Override
    public void update(Collection<Cassette> assortment) {
        for (Cassette cassette :
                assortment) {
            addProduct(cassette.peekProduct(), cassette.getPurchasePrice());
        }
    }

    @Override
    public Float getSalePrice(Product product) {
        String item = product.getProductName();
        if (!super.salePrice.containsKey(item)) return null;
        return super.salePrice.get(item);
    }

    @Override
    public boolean addProduct(Product product, Float purchasePrice) {
        if (purchasePrice == null) return false;

        String item = product.getProductName();
        Float previousPurchasePrice = super.purchasePrice.getOrDefault(item, 0.0f);
        super.purchasePrice.put(item, Math.max(previousPurchasePrice, purchasePrice));
        super.salePrice.put(item, super.purchasePrice.get(item) * (super.morginality / 100));

        return true;
    }

    @Override
    public boolean addProduct(Product product) {
        if (product == null) return false;
        return addProduct(product, product.getPurchasePrice());
    }
}
