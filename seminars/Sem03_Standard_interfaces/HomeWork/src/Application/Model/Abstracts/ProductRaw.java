package Application.Model.Abstracts;

import Application.Model.Interfaces.ProductsRaw;

public abstract class ProductRaw extends Product implements ProductsRaw {

    protected Float remainingVolume;

    public ProductRaw(String name, Float volume, Float buyingPrice) {
        super(name, volume, buyingPrice);
        setRemainingVolume(volume);
    }

    protected abstract void setRemainingVolume(Float remainingVolume);
}
