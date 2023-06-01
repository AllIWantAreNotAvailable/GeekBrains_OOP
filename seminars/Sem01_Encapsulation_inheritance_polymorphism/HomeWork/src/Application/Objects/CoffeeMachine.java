package Application.Objects;

import Application.Abstracts.CoffeeDrink;
import Application.Enums.CupSizes;
import Application.Interfaces.Products;
import Application.Interfaces.Vending;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeMachine implements Vending {
    Map<String, Integer> assortment;
    Milk milk;
    Milk stashedMilk;
    CoffeeBeans coffeeBeans;
    CoffeeBeans stashedCoffeeBeans;
    Water water;
    Water stashedWater;

    public CoffeeMachine(CoffeeBeans coffeeBeans, Water water, Milk milk) {
        this.coffeeBeans = coffeeBeans;
        this.water = water;
        this.milk = milk;
        this.assortment = new HashMap<>() {{
            put("Espresso", 1);
            put("Americano", 2);
            put("Cappuccino", 3);
            put("Latte", 4);
            put("Frappe", 5);
        }};
    }

    @Override
    public void putProduct(Products product) {

    }

    @Override
    public void putProducts(List<Products> products) {

    }

    private CoffeeBeans getStashed(CoffeeBeans coffeeBeans, float amount) {
        if (stashedCoffeeBeans == null) {
            if (coffeeBeans != null && amount <= coffeeBeans.getVolume()) {
                coffeeBeans.setVolume(coffeeBeans.getVolume() - amount);
                stashedCoffeeBeans = new CoffeeBeans(coffeeBeans.getName(), amount, coffeeBeans.getUnit(), coffeeBeans.getPlace());
                return stashedCoffeeBeans;
            } else {
                stashedCoffeeBeans = coffeeBeans;
                this.coffeeBeans = null;
            }
        } else {
            if (amount == stashedCoffeeBeans.getVolume()) {
                return stashedCoffeeBeans;
            } else if (amount < stashedCoffeeBeans.getVolume()) {
                float tailedStashedVolume = stashedCoffeeBeans.getVolume() - amount;
                stashedCoffeeBeans = new CoffeeBeans(stashedCoffeeBeans.getName(), amount, stashedCoffeeBeans.getUnit(), stashedCoffeeBeans.getPlace());
                this.coffeeBeans.setVolume(this.coffeeBeans.getVolume() + tailedStashedVolume);
                return stashedCoffeeBeans;
            } else if (amount < stashedCoffeeBeans.getVolume() + coffeeBeans.getVolume()) {
                float missingVolume = amount - stashedCoffeeBeans.getVolume();
                coffeeBeans.setVolume(coffeeBeans.getVolume() - missingVolume);
                stashedCoffeeBeans.setVolume(stashedCoffeeBeans.getVolume() + missingVolume);
            } else if (amount == stashedCoffeeBeans.getVolume() + coffeeBeans.getVolume()) {
                stashedCoffeeBeans.setVolume(stashedCoffeeBeans.getVolume() + coffeeBeans.getVolume());
                this.coffeeBeans = null;
                return stashedCoffeeBeans;
            } else {
                stashedCoffeeBeans.setVolume(stashedCoffeeBeans.getVolume() + coffeeBeans.getVolume());
                this.coffeeBeans = null;
                return null;
            }
        }
        return null;
    }

    private Milk getStashed(Milk milk, float amount) {
        if (stashedMilk == null) {
            if (milk != null && amount <= milk.getVolume()) {
                milk.setVolume(milk.getVolume() - amount);
                stashedMilk = new Milk(milk.getName(), amount, milk.getUnit(), milk.getPlace());
                return stashedMilk;
            } else {
                stashedMilk = milk;
                this.milk = null;
            }
        } else {
            if (amount == stashedMilk.getVolume()) {
                return stashedMilk;
            } else if (amount < stashedMilk.getVolume()) {
                float tailedStashedVolume = stashedMilk.getVolume() - amount;
                stashedMilk = new Milk(stashedMilk.getName(), amount, stashedMilk.getUnit(), stashedMilk.getPlace());
                this.milk.setVolume(this.milk.getVolume() + tailedStashedVolume);
                return stashedMilk;
            } else if (amount < stashedMilk.getVolume() + milk.getVolume()) {
                float missingVolume = amount - stashedMilk.getVolume();
                milk.setVolume(milk.getVolume() - missingVolume);
                stashedMilk.setVolume(stashedMilk.getVolume() + missingVolume);
            } else if (amount == stashedMilk.getVolume() + milk.getVolume()) {
                stashedMilk.setVolume(stashedMilk.getVolume() + milk.getVolume());
                this.milk = null;
                return stashedMilk;
            } else {
                stashedMilk.setVolume(stashedMilk.getVolume() + milk.getVolume());
                this.milk = null;
                return null;
            }
        }
        return null;
    }

    private Water getStashed(Water water, float amount) {
        if (stashedWater == null) {
            if (water != null && amount <= water.getVolume()) {
                water.setVolume(water.getVolume() - amount);
                stashedWater = new Water(water.getName(), amount, water.getUnit(), water.getPlace());
                return stashedWater;
            } else {
                stashedWater = water;
                this.water = null;
            }
        } else {
            if (amount == stashedWater.getVolume()) {
                return stashedWater;
            } else if (amount < stashedWater.getVolume()) {
                float tailedStashedVolume = stashedWater.getVolume() - amount;
                stashedWater = new Water(stashedWater.getName(), amount, stashedWater.getUnit(), stashedWater.getPlace());
                this.water.setVolume(this.water.getVolume() + tailedStashedVolume);
                return stashedWater;
            } else if (amount < stashedWater.getVolume() + water.getVolume()) {
                float missingVolume = amount - stashedWater.getVolume();
                water.setVolume(water.getVolume() - missingVolume);
                stashedWater.setVolume(stashedWater.getVolume() + missingVolume);
            } else if (amount == stashedWater.getVolume() + water.getVolume()) {
                stashedWater.setVolume(stashedWater.getVolume() + water.getVolume());
                this.water = null;
                return stashedWater;
            } else {
                stashedWater.setVolume(stashedWater.getVolume() + water.getVolume());
                this.water = null;
                return null;
            }
        }
        return null;
    }

    private CoffeeDrink getEspresso(CupSizes cupSize) {
        return null;
    }

    private CoffeeDrink getEspresso() {
        return getEspresso(CupSizes.small);
    }

    private CoffeeDrink getAmericano(CupSizes cupSize) {
        return null;
    }

    private CoffeeDrink getAmericano() {
        return getAmericano(CupSizes.small);
    }
    
    private CoffeeDrink getCappuccino(CupSizes cupSize) {
        CoffeeBeans portionCoffeeBeans = getStashed(this.coffeeBeans, 30.f);
        Water portionWater = getStashed(this.water, 70.0f);
        Milk portionMilk = getStashed(this.milk, 30.0f);
        if (portionCoffeeBeans == null || portionWater == null || portionMilk == null) {
            return null;
        }
        CoffeeDrink coffeeDrink = new Cappuccino(cupSize, 100.0f, portionCoffeeBeans, portionWater, portionMilk);
        stashedCoffeeBeans = null;
        stashedWater = null;
        stashedMilk = null;
        return coffeeDrink;
    }

    private CoffeeDrink getCappuccino() {
        return getCappuccino(CupSizes.small);
    }

    private CoffeeDrink getLatte(CupSizes cupSize) {
        return null;
    }

    private CoffeeDrink getLatte() {
        return getLatte(CupSizes.small);
    }

    private CoffeeDrink getFrappe(CupSizes cupSize) {
        return null;
    }

    private CoffeeDrink getFrappe() {
        return getFrappe(CupSizes.small);
    }

    public Products getProduct(String name, CupSizes cupSize) {
        return switch (assortment.get(name)) {
            case 1 -> cupSize == null ?  getEspresso() : getEspresso(cupSize);
            case 2 -> cupSize == null ?  getAmericano() : getAmericano(cupSize);
            case 3 -> cupSize == null ?  getCappuccino() : getCappuccino(cupSize);
            case 4 -> cupSize == null ?  getLatte() : getLatte(cupSize);
            case 5 -> cupSize == null ?  getFrappe() : getFrappe(cupSize);
            default -> null;
        };
    }

    @Override
    public Products getProduct(String name) {
        return switch (assortment.get(name)) {
            case 1 -> getEspresso();
            case 2 -> getAmericano();
            case 3 -> getCappuccino();
            case 4 -> getLatte();
            case 5 -> getFrappe();
            default -> null;
        };
    }
}
