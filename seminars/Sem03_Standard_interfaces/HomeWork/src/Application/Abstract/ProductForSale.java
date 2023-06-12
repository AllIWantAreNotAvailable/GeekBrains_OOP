package Application.Abstract;


import Application.Interface.Products;

public abstract class ProductForSale<T extends Enum<T>> implements Products, Comparable<ProductForSale<T>> {

    protected Enum<T> assortmentCode;
    protected Products linkedProduct;
    protected Float price;

    public ProductForSale(Enum<T> assortmentCode, Products linkedProduct, Float price) {
        setAssortmentCode(assortmentCode);
        setLinkedProduct(linkedProduct);
        setPrice(price);
    }

    public abstract Enum<T> getAssortmentCode();

    protected abstract void setAssortmentCode(Enum<T> assortmentCode);

    public abstract Products getLinkedProduct();

    protected abstract void setLinkedProduct(Products linkedProduct);

    public abstract Float getPrice();

    protected abstract void setPrice(Float price);

}
