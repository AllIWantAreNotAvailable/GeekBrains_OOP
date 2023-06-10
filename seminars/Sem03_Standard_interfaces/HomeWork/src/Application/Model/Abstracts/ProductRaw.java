package Application.Model.Abstracts;

import Application.Model.Enumerations.ConsiderVolume;
import Application.Model.Interfaces.ProductRawInterface;

import java.util.Objects;

public abstract class ProductRaw extends Product implements ProductRawInterface {

    protected Float remainingVolume;
    protected ConsiderVolume considerVolume;

    public ProductRaw(String name, Float volume, Float buyingPrice) {
        super(name, volume, buyingPrice);
        setRemainingVolume(volume);
    }

    protected abstract void setConsiderVolume(ConsiderVolume considerVolume);

    public abstract ConsiderVolume getConsiderVolume();

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
