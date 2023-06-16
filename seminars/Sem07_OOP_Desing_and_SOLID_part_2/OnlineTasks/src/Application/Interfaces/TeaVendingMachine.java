package Application.Interfaces;

import Application.Entities.Tea;

public interface TeaVendingMachine extends HotDrinksVendingMachine<Tea> {
    void putWater();
}
