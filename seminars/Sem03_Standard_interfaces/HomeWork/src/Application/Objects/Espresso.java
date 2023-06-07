package Application.Objects;

import Application.Abstract.AbsCoffeeDrinks;
import Application.Enums.CupSizes;
import Application.Enums.Temperature;
import Application.Enums.Units;

public class Espresso extends AbsCoffeeDrinks {
    public Espresso(String name, Float volume, CoffeeBeans coffeeBeans, Water water, Milk milk) {
        super(name, volume, coffeeBeans, water, milk, Temperature.hot, CupSizes.small);
    }

    @Override
    public CoffeeBeans getCoffeeBeans() {
        return super.coffeeBeans;
    }

    @Override
    public void setCoffeeBeans(CoffeeBeans coffeeBeans) {
        super.coffeeBeans = coffeeBeans;
    }

    @Override
    public Water getWater() {
        return super.water;
    }

    @Override
    public void setWater(Water water) {
        super.water = water;
    }

    @Override
    public Milk getMilk() {
        return super.milk;
    }

    @Override
    public void setMilk(Milk milk) {
        super.milk = milk;
    }

    @Override
    public Temperature getTemp() {
        return super.temp;
    }

    @Override
    public void setTemp(Temperature temp) {
        super.temp = temp;
    }

    @Override
    public CupSizes getCupSize() {
        return super.cupSize;
    }

    @Override
    public void setCupSize(CupSizes cupSize) {
        super.cupSize = cupSize;
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
    public String toString() {
        return "Espresso{" +
                "name='" + getName() + '\'' +
                ", cupSize=" + getCupSize() +
                ", volume=" + getVolume() +
                ", unit=" + getUnit() +
                ", coffeeBeans=" + getCoffeeBeans() +
                ", water=" + getWater() +
                ", milk=" + getMilk() +
                ", temp=" + getTemp() +
                '}';
    }
}
