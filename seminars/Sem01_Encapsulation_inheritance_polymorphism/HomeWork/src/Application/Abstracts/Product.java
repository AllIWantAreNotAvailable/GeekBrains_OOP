package Application.Abstracts;

import Application.Enums.Units;
import Application.Interfaces.Products;

import java.util.Objects;

public abstract class Product implements Products {
    protected String name;
    protected Float volume;
    protected Units unit;

    public Product(String name, Float volume, Units unit) {
        this.name = name;
        this.volume = volume == null ? 0.0f : volume;
        this.unit = unit == null ? Units.piece : unit;
    }

    public Product(String name, Float volume) {
        this(name, volume, null);
    }

    public Product(String productName) {
        this(productName, null, null);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Product that)) return false;
        return Objects.equals(this.getName(), that.getName())
                && Objects.equals(this.getVolume(), that.getVolume())
                && this.getUnit() == that.getUnit();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getUnit());
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                ", unit=" + unit +
                '}';
    }
}
