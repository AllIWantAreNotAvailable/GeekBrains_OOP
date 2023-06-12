package Application.Interface.Factorys;

import Application.Enums.Units;
import Application.Objects.Water;

public interface WaterFactory {
    Water create(String name, Float volume, Units unit, Float pH);
}
