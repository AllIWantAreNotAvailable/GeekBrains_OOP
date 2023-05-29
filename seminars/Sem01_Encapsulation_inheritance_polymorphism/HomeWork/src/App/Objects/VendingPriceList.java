package App.Objects;

import App.AbstractClasses.PriceList;
import App.AbstractClasses.Product;

public class VendingPriceList extends PriceList {

    public VendingPriceList() {
        super();
    }

    @Override
    public Float calculateSalePrice(Product product) {
        return null;
    }

    @Override
    public Float getSalePrice(Product product) {
        return null;
    }

    @Override
    public Float getPurchasePrice(Product product) {
        return null;
    }
}
