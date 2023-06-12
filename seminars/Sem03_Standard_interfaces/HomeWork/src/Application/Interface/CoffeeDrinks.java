package Application.Interface;

import Application.Objects.RawMaterials.CoffeeBeans;
import Application.Objects.RawMaterials.Water;

public interface CoffeeDrinks {

    CoffeeBeans getCoffeeBeans();

    void setCoffeeBeans(CoffeeBeans coffeeBeans);

    Water getWater();

    void setWater(Water water);

}
