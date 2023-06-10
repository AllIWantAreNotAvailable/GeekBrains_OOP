package Application.Model.Abstracts;

import Application.Model.Interfaces.ProductInterface;

import java.util.Objects;

public abstract class Product implements ProductInterface {

    static long nextUUID;

    protected Long uuid;
    protected String name;
    protected Float volume;
    protected Float buyingPrice;

    public Product(String name, Float volume, Float buyingPrice) {
        setUuid(nextUUID++);
        setName(name);
        setVolume(volume);
        setBuyingPrice(buyingPrice);
    }

    protected abstract void setBuyingPrice(Float buyingPrice);
    protected abstract void setUuid(Long uuid);
    protected abstract void setName(String name);
    protected abstract void setVolume(Float volume);

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Product that)) return false;
        return Objects.equals(this.getName(), that.getName())
                && Objects.equals(this.getVolume(), that.getVolume());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getName(), getVolume(), getBuyingPrice());
    }
}
