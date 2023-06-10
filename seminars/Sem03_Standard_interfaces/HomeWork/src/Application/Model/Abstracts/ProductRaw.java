package Application.Model.Abstracts;

import Application.Model.Interfaces.ProductsRaw;

import java.util.Objects;

public abstract class ProductRaw extends Product implements ProductsRaw {

    protected Float remainingVolume;

    public ProductRaw(String name, Float volume, Float buyingPrice) {
        super(name, volume, buyingPrice);
        setRemainingVolume(volume);
    }

    protected abstract void setRemainingVolume(Float remainingVolume);

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return object instanceof ProductRaw;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRemainingVolume());
    }
}
