package App.AbstractClasses;

import java.util.HashMap;
import java.util.Map;

public abstract class PriceList {
    protected Map<String, Float> purchasePrice;
    protected Map<String, Float> salePrice;

    public PriceList() {
        this.purchasePrice = new HashMap<>();
        this.salePrice = new HashMap<>();
    }

    public abstract Float calculateSalePrice(Product product);
    public abstract Float getSalePrice(Product product);
    public abstract Float getPurchasePrice(Product product);
}
