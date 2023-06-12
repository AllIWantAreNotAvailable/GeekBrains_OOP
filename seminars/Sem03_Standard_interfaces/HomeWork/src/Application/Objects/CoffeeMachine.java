package Application.Objects;

import Application.Abstract.AbsCoffeeDrinks;
import Application.Abstract.AbsCoffeeMachine;
import Application.Abstract.AbsProduct;

import java.util.List;

public class CoffeeMachine extends AbsCoffeeMachine {
    public CoffeeMachine(CoffeeBeans coffeeBeans, Water water, Milk milk) {
        super(coffeeBeans, water, milk);
    }

    @Override
    public AbsProduct getStashed() {
        return null;
    }

    @Override
    public void setStashed() {

    }

    @Override
    public CoffeeBeans getCoffeeBeans() {
        return coffeeBeans;
    }

    @Override
    public void setCoffeeBeans(CoffeeBeans coffeeBeans) {
        super.coffeeBeans = coffeeBeans;
    }

    @Override
    public Water getWater() {
        return super.water;
    }

    @Override
    public void setWater(Water water) {
        super.water = water;
    }

    @Override
    public Milk getMilk() {
        return super.milk;
    }

    @Override
    public void setMilk(Milk milk) {
        super.milk = milk;
    }

    @Override
    protected void isOutOfIngredients() {
        if (getCoffeeBeans() == null
                || getWater() == null
                || getMilk() == null) {
            super.status = Status.outOfIngredients;
        } else {
            super.status = Status.ok;
        }
    }

    @Override
    public Status getStatus() {
        isOutOfIngredients();
        return super.status;
    }

    @Override
    public boolean isWorking() {
        return getStatus() == Status.working;
    }

    @Override
    public void powerOn() {
        if (super.status != Status.outOfIngredients) super.status = Status.working;
    }

    @Override
    public void powerOff() {
        if (super.status != Status.outOfIngredients) super.status = Status.stopped;
    }

    @Override
    public void putProduct(AbsCoffeeDrinks product) {

    }

    @Override
    public void putProduct(List<AbsCoffeeDrinks> products) {

    }

    @Override
    public AbsCoffeeDrinks getProduct(String name) {
        return null;
    }
}
