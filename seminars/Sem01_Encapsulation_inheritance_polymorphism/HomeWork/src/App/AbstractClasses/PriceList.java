package App.AbstractClasses;

import App.Interfaces.Pricing;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class PriceList implements Pricing {
    protected Map<String, Float> purchasePrice;
    protected Map<String, Float> salePrice;
    protected Integer morginality;

    public PriceList(Integer morginality) {
        this.morginality = morginality;
        this.purchasePrice = new HashMap<>();
        this.salePrice = new HashMap<>();
    }

    public PriceList() {
        this(200);
    }

    public abstract void update(Collection<Cassette> assortment);

}
