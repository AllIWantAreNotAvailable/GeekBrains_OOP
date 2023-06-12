package Application.Interface.Factorys;

import Application.Enums.Units;
import Application.Objects.Milk;

public interface MilkFactory {
    Milk create(String name, Float volume, Units unit, Float fatPercentage);
}
