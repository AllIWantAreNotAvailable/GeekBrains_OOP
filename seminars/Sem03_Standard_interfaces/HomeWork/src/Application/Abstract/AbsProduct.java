package Application.Abstract;

import Application.Enums.Units;
import Application.Interface.Products;

import java.util.Objects;

public abstract class AbsProduct implements Products {
    protected String name;
    protected Float volume;
    protected Units unit;

    public AbsProduct(String name, Float volume, Units unit) {
        setName(name);
        setVolume(volume);
        setUnit(unit);
    }

    public AbsProduct(String name, Float volume) {
        this(name, volume, Units.piece);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof AbsProduct that)) return false;
        return Objects.equals(getName(), that.getName())
                && Objects.equals(getVolume(), that.getVolume())
                && getUnit() == that.getUnit();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getVolume(), getUnit());
    }
}
