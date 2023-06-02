package Application.Abstracts;

import Application.Enums.CupSizes;
import Application.Enums.Temperature;
import Application.Interfaces.FinalProducts;
import Application.Objects.CoffeeBeans;
import Application.Objects.Water;

import java.util.HashMap;
import java.util.Map;

public abstract class CoffeeDrink extends Product implements FinalProducts {
    protected CupSizes size;
    protected Temperature temperature;
    protected CoffeeBeans coffeeBeans;
    protected Water water;

    public CoffeeDrink(String name, Float volume, CupSizes size, Temperature temperature, CoffeeBeans coffeeBeans, Water water) {
        super(name, volume);
        this.size = size;
        this.temperature = temperature;
        this.coffeeBeans = coffeeBeans;
        this.water = water;
    }

    public abstract Map<CupSizes, Map<String, Float>> getRecipe();
}
