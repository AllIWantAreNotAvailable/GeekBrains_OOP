package Application.Abstract;

import Application.Enums.Units;
import Application.Objects.CoffeeBeans;
import Application.Enums.Temperature;
import Application.Enums.CupSizes;
import Application.Objects.Milk;
import Application.Objects.Water;

import java.util.Objects;

public abstract class AbsCoffeeDrinks extends AbsProduct {
    protected CoffeeBeans coffeeBeans;
    protected Water water;
    protected Milk milk;
    protected Temperature temp;
    protected CupSizes cupSize;

    public AbsCoffeeDrinks(String name, Float volume, CoffeeBeans coffeeBeans, Water water, Milk milk, Temperature temp, CupSizes size) {
        super(name, volume, Units.milliliters);
        this.coffeeBeans = coffeeBeans;
        this.water = water;
        this.milk = milk;
        this.temp = temp;
        this.cupSize = size;
    }

    public abstract CoffeeBeans getCoffeeBeans();

    public abstract void setCoffeeBeans(CoffeeBeans coffeeBeans);

    public abstract Water getWater();

    public abstract void setWater(Water water);

    public abstract Milk getMilk();

    public abstract void setMilk(Milk milk);

    public abstract Temperature getTemp();

    public abstract void setTemp(Temperature temp);

    public abstract CupSizes getCupSize();

    public abstract void setCupSize(CupSizes cupSize);

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            if (!(object instanceof AbsCoffeeDrinks that)) return false;
            return Objects.equals(coffeeBeans, that.coffeeBeans)
                    && Objects.equals(water, that.water)
                    && Objects.equals(milk, that.milk)
                    && temp == that.temp
                    && cupSize == that.cupSize;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coffeeBeans, water, milk, temp, cupSize);
    }

    @Override
    public String toString() {
        return "AbsCoffeeDrinks{" +
                "name='" + getName() + '\'' +
                ", size=" + getCupSize() +
                ", volume=" + getVolume() +
                ", unit=" + getUnit() +
                ", coffeeBeans=" + getCoffeeBeans() +
                ", water=" + getWater() +
                ", milk=" + getMilk() +
                ", temp=" + getTemp() +
                '}';
    }
}
