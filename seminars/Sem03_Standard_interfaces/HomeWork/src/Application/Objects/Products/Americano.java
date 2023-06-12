package Application.Objects.Products;

import Application.Abstract.EspressoBasedDrinks;
import Application.Enums.Unit;
import Application.Objects.RawMaterials.Water;

import java.util.Objects;

public class Americano extends EspressoBasedDrinks {

    public static Float defaultWaterVolume;

    static {
        defaultWaterVolume = 70f;
    }

    private Water water;

    public Americano(Espresso espresso, Water water) {
        super("Americano", espresso);
        setWater(water);
        setVolume(getVolume() + water.getVolume());
    }

    @Override
    public Espresso getEspresso() {
        return super.espresso;
    }

    @Override
    public void setEspresso(Espresso espresso) {
        super.espresso  = espresso;
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
    public Unit getUnit() {
        return super.unit;
    }

    @Override
    public void setUnit(Unit unit) {
        super.unit = unit;
    }

    public Water getWater() {
        return water;
    }

    public void setWater(Water water) {
        this.water = water;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            if (!(object instanceof Americano americano)) return false;
            return Objects.equals(getWater(), americano.getWater());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWater());
    }

    @Override
    public String toString() {
        return "Americano{" +
                "name='" + getName() + '\'' +
                ", volume=" + getVolume() +
                ", unit=" + getUnit() +
                ", espresso=" + getEspresso() +
                ", water=" + getWater() +
                '}';
    }
}
