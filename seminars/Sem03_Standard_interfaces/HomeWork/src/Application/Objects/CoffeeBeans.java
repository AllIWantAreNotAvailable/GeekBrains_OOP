package Application.Objects;

import Application.Abstract.AbsProduct;
import Application.Enums.Units;
import Application.Interface.RawMaterial;

import java.util.Objects;

public class CoffeeBeans extends AbsProduct implements RawMaterial<CoffeeBeans> {
    private String place;

    public CoffeeBeans(String name, Float volume, Units unit, String place) {
        super(name, volume, unit);
        setPlace(place);
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public void setName(String name) {
        super.name = name;
    }

    @Override
    public Float getVolume() {
        return super.volume;
    }

    @Override
    public void setVolume(Float volume) {
        super.volume = volume;
    }

    @Override
    public Units getUnit() {
        return super.unit;
    }

    @Override
    public void setUnit(Units unit) {
        super.unit = unit;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public CoffeeBeans getPieceOfProduct(float amount) throws Exception {
        float newAmount = getVolume() - amount;
        if (0 <= newAmount) {
            setVolume(newAmount);
            return new CoffeeBeans(getName(), amount, getUnit(), getPlace());
        }
        throw new Exception("Not enough volume");
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            if (!(object instanceof CoffeeBeans that)) return false;
            return Objects.equals(getPlace(), that.getPlace());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPlace());
    }

    @Override
    public String toString() {
        return "CoffeeBeans{" +
                "name='" + getName() + '\'' +
                ", volume=" + getVolume() +
                ", unit=" + getUnit() +
                ", place='" + getPlace() + '\'' +
                '}';
    }
}
