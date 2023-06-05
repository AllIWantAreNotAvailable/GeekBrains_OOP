package Application.Abstracts;

import Application.Enums.CupSizes;
import Application.Enums.Temperature;
import Application.Enums.Units;
import Application.Interfaces.FinalProducts;
import Application.Objects.CoffeeBeans;
import Application.Objects.Water;


public abstract class CoffeeDrink extends Product implements FinalProducts {
    protected CupSizes size;
    protected Temperature temperature;
    protected CoffeeBeans coffeeBeans;
    protected Water water;


    public CoffeeDrink(String name, Float volume, CupSizes size, Temperature temperature, CoffeeBeans coffeeBeans, Water water) {
        super(name, volume, Units.milliliters);
        this.size = size;
        this.temperature = temperature;
        this.coffeeBeans = coffeeBeans;
        this.water = water;
    }

    @Override
    public String toString() {
        return "CoffeeDrink{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", coffeeBeans=" + coffeeBeans +
                ", volume=" + volume +
                ", unit=" + unit +
                ", water=" + water +
                ", temperature=" + temperature +
                '}';
    }
}
