package Application.Interface.Factorys;

import Application.Enums.Units;
import Application.Objects.CoffeeBeans;

public interface CoffeeBeansFactory {
    CoffeeBeans create(String name, Float volume, Units unit, String place);
}
