package Application.Interfaces;

import Application.Entities.Coffee;

public interface CoffeeVendingMachine extends HotDrinksVendingMachine<Coffee>{

    void roast();
}
