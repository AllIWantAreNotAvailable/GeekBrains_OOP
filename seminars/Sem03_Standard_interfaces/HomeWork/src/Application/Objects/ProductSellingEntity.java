package Application.Objects;

import Application.Abstract.ProductForSale;
import Application.Enums.CoffeeAssortment;
import Application.Enums.Unit;
import Application.Interface.Products;

import java.util.Objects;

public class ProductSellingEntity extends ProductForSale<CoffeeAssortment> {
    public ProductSellingEntity(Enum<CoffeeAssortment> assortmentCode, Products linkedProduct, Float price) {
        super(assortmentCode, linkedProduct, price);
    }

    @Override
    public Enum<CoffeeAssortment> getAssortmentCode() {
        return assortmentCode;
    }

    @Override
    protected void setAssortmentCode(Enum<CoffeeAssortment> assortmentCode) {
        this.assortmentCode = assortmentCode;
    }

    @Override
    public Products getLinkedProduct() {
        return linkedProduct;
    }

    @Override
    protected void setLinkedProduct(Products linkedProduct) {
        this.linkedProduct = linkedProduct;
    }

    @Override
    public Float getPrice() {
        return price;
    }

    @Override
    protected void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String getName() {
        return getLinkedProduct().getName();
    }

    @Override
    public void setName(String name) {
        getLinkedProduct().setName(name);
    }

    @Override
    public Float getVolume() {
        return getLinkedProduct().getVolume();
    }

    @Override
    public void setVolume(Float volume) {
        getLinkedProduct().setVolume(volume);
    }

    @Override
    public Unit getUnit() {
        return getLinkedProduct().getUnit();
    }

    @Override
    public void setUnit(Unit unit) {
        getLinkedProduct().setUnit(unit);
    }

    @Override
    public int compareTo(ProductForSale<CoffeeAssortment> o) {
        return getPrice().compareTo(o.getPrice());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ProductForSale<?> that)) return false;
        return Objects.equals(getAssortmentCode(), that.getAssortmentCode())
                && Objects.equals(getLinkedProduct(), that.getLinkedProduct()) && Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAssortmentCode(), getLinkedProduct(), getPrice());
    }

    @Override
    public String toString() {
        return "ProductSellingEntity{" +
                "assortmentCode=" + getAssortmentCode() +
                ", price=" + getPrice() +
                ", linkedProduct=" + getLinkedProduct() +
                '}';
    }
}
