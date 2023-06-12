package Application.Objects.Products;

import Application.Abstract.CoffeeDrink;
import Application.Enums.Unit;
import Application.Objects.RawMaterials.CoffeeBeans;
import Application.Objects.RawMaterials.Water;

public class Espresso extends CoffeeDrink {
    public static Float defaultCoffeeBeansVolume;
    public static Float defaultWaterVolume;

    static {
        defaultCoffeeBeansVolume = 9f;
        defaultWaterVolume = 30f;
    }

    public Espresso(String name, Float volume, Unit unit, CoffeeBeans coffeeBeans, Water water) {
        super(name, volume, unit, coffeeBeans, water);
    }

    public Espresso(CoffeeBeans coffeeBeans, Water water) {
        this("Espresso", water.getVolume(), water.getUnit(), coffeeBeans, water);
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

    @Override
    public String toString() {
        return super.toString().replaceFirst(".+?\\{", "Espresso{");
    }
}
