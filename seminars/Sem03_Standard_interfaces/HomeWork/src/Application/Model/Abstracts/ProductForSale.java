package Application.Model.Abstracts;

import Application.Model.Interfaces.ProductsForSale;

public abstract class ProductForSale extends Product implements ProductsForSale, Comparable<ProductForSale> {

    protected Float sellingPrice;

    public ProductForSale(String name, Float volume, Float buyingPrice, Float sellingPrice) {
        super(name, volume, buyingPrice);
        setSellingPrice(sellingPrice);
    }

    protected abstract void setSellingPrice(Float sellingPrice);
}
