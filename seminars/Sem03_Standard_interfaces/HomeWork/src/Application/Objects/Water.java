package Application.Objects;

import Application.Abstract.AbsProduct;
import Application.Enums.Units;
import Application.Interface.RawMaterial;

import java.util.Objects;

public class Water extends AbsProduct implements RawMaterial<Water> {
    Float pH;

    public Water(String name, Float volume, Units unit, Float pH) {
        super(name, volume, unit);
        this.pH = pH;
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
    public Water getPieceOfProduct(float amount) throws Exception {
        float newAmount = getVolume() - amount;
        if (0 <= newAmount) {
            setVolume(newAmount);
            return new Water(getName(), amount, getUnit(), getPH());
        }
        throw new Exception("Not enough volume");
    }

    public Float getPH() {
        return pH;
    }

    public void setPH(Float pH) {
        this.pH = pH;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            if (this == object) return true;
            if (!(object instanceof Water water)) return false;
            return Objects.equals(pH, water.pH);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pH);
    }

    @Override
    public String toString() {
        return "Water{" +
                "name='" + getName() + '\'' +
                ", volume=" + getVolume() +
                ", unit=" + getUnit() +
                ", pH=" + getPH() +
                '}';
    }
}
