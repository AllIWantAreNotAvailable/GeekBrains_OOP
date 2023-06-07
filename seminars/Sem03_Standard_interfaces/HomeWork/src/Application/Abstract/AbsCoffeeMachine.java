package Application.Abstract;

import Application.Interface.VendingMachine;
import Application.Objects.CoffeeBeans;
import Application.Objects.Milk;
import Application.Objects.Water;

public abstract class AbsCoffeeMachine implements VendingMachine<AbsCoffeeDrinks> {
    protected enum Status {
        working,
        ok,
        outOfIngredients,
        stopped
    }

    protected Status status;
    protected CoffeeBeans coffeeBeans;
    protected CoffeeBeans stashedCoffeeBeans;
    protected Water water;
    protected Water stashedWater;
    protected Milk milk;
    protected Milk stashedMilk;

    public AbsCoffeeMachine(CoffeeBeans coffeeBeans, Water water, Milk milk) {
        this.status = Status.stopped;
        this.coffeeBeans = coffeeBeans;
        this.water = water;
        this.milk = milk;
    }

    protected abstract void isOutOfIngredients();

    public abstract Status getStatus();

    protected abstract AbsProduct getStashed();
    protected abstract void setStashed();

    public abstract CoffeeBeans getCoffeeBeans();

    public abstract void setCoffeeBeans(CoffeeBeans coffeeBeans);

    public abstract Water getWater();

    public abstract void setWater(Water water);

    public abstract Milk getMilk();

    public abstract void setMilk(Milk milk);


}
