package Application.Objects;

import Application.Abstract.AbsProduct;
import Application.Enums.Units;
import Application.Interface.RawMaterial;

import java.util.Objects;

public class Milk extends AbsProduct implements RawMaterial<Milk> {
    private Float fatPercentage;

    public Milk(String name, Float volume, Units unit, Float fatPercentage) {
        super(name, volume, unit);
        setFatPercentage(fatPercentage);
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

    @Override
    public Milk getPieceOfProduct(float amount) throws Exception {
        float newAmount = getVolume() - amount;
        if (0 <= newAmount) {
            setVolume(newAmount);
            return new Milk(getName(), amount, getUnit(), getFatPercentage());
        }
        throw new Exception("Not enough volume");
    }

    public Float getFatPercentage() {
        return fatPercentage;
    }

    public void setFatPercentage(Float fatPercentage) {
        this.fatPercentage = fatPercentage;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            if (!(object instanceof Milk milk)) return false;
            return Objects.equals(getFatPercentage(), milk.getFatPercentage());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFatPercentage());
    }

    @Override
    public String toString() {
        return "Milk{" +
                "name='" + getName() + '\'' +
                ", volume=" + getVolume() +
                ", unit=" + getUnit() +
                ", fatPercentage=" + getFatPercentage() +
                '}';
    }
}
