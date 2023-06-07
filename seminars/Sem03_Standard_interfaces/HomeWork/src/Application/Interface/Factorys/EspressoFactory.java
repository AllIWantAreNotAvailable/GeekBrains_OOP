package Application.Interface.Factorys;

import Application.Objects.CoffeeBeans;
import Application.Objects.Espresso;
import Application.Objects.Milk;
import Application.Objects.Water;

public interface EspressoFactory {
    Espresso create(String name, Float volume, CoffeeBeans coffeeBeans, Water water, Milk milk);
}
