package Application.Abstract;

import Application.Enums.Unit;
import Application.Interface.CoffeeDrinks;
import Application.Objects.RawMaterials.CoffeeBeans;
import Application.Objects.RawMaterials.Water;

import java.util.Objects;

public abstract class CoffeeDrink extends Product implements CoffeeDrinks {
    protected CoffeeBeans coffeeBeans;
    protected Water water;

    public CoffeeDrink(String name, Float volume, Unit unit, CoffeeBeans coffeeBeans, Water water) {
        super(name, volume, unit);
        setCoffeeBeans(coffeeBeans);
        setWater(water);
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            if (!(object instanceof CoffeeDrink that)) return false;
            return Objects.equals(getCoffeeBeans(), that.getCoffeeBeans())
                    && Objects.equals(getWater(), that.getWater());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCoffeeBeans(), getWater());
    }

    @Override
    public String toString() {
        return "CoffeeDrink{" +
                "name='" + getName() + '\'' +
                ", volume=" + getVolume() +
                ", unit=" + getUnit() +
                ", coffeeBeans=" + getCoffeeBeans() +
                ", water=" + getWater() +
                '}';
    }
}
