package Application.Abstract;

import Application.Interface.Products;
import Application.Enums.Unit;

import java.util.Objects;

public abstract class Product implements Products {

    protected String name;
    protected Float volume;
    protected Unit unit;

    public Product(String name, Float volume, Unit unit) {
        setName(name);
        setVolume(volume);
        setUnit(unit);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Product product)) return false;
        return Objects.equals(getName(), product.getName())
                && Objects.equals(getVolume(), product.getVolume())
                && getUnit() == product.getUnit();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getVolume(), getUnit());
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + getName() + '\'' +
                ", volume=" + getVolume() +
                ", unit=" + getUnit() +
                '}';
    }
}
