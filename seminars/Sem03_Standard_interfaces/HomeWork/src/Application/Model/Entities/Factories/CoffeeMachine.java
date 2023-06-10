package Application.Model.Entities.Factories;

import Application.Model.Abstracts.ProductFactory;
import Application.Model.Entities.*;
import Application.Model.Enumerations.WorkingStatus;

public class CoffeeMachine extends ProductFactory {

    CoffeeBeans coffeeBeans;
    CoffeeBeans coffeeBeansStashed;

    Water water;
    Water waterStashed;

    Milk milk;
    Milk milkStashed;

    Sugar sugar;
    Sugar sugarStashed;

    Syrup syrup;
    Syrup syrupStashed;

    public CoffeeMachine(CoffeeBeans coffeeBeans, Water water, Milk milk, Sugar sugar, Syrup syrup) {
        setCoffeeBeans(coffeeBeans);
        setWater(water);
        setMilk(milk);
        setSugar(sugar);
        setSyrup(syrup);
        setStatus(WorkingStatus.NOT_WORKING);
    }

    @Override
    protected void setUUID(long uuid) {
        super.factoryUUID = uuid;
    }

    @Override
    protected void switchStatus() {
        if (status == WorkingStatus.WORKING) {
            setStatus(WorkingStatus.NOT_WORKING);
        } else {
            setStatus(WorkingStatus.WORKING);
        }
    }

    @Override
    protected void setStatus(WorkingStatus status) {
        if (!isEmpty()) {
            super.status = WorkingStatus.NOT_ENOUGH_INGREDIENTS;
        } else {
            if (status == WorkingStatus.NOT_ENOUGH_INGREDIENTS) {
                switchStatus();
            } else {
                super.status = status;
            }
        }
    }

    @Override
    protected WorkingStatus getStatus() {
        return status;
    }

    public boolean isEmpty() {
        return isCoffeeBeansEmpty()
                || isWaterEmpty()
                || isMilkEmpty()
                || isSugarEmpty()
                || isSyrupEmpty();
    }

    public boolean isCoffeeBeansEmpty(){
        return getCoffeeBeans() == null || getCoffeeBeans().getRemainingVolume() == 0;
    }

    public boolean isWaterEmpty() {
        return getWater() == null || getWater().getRemainingVolume() == 0;
    }

    public boolean isMilkEmpty() {
        return getMilk() == null || getMilk().getRemainingVolume() == 0;
    }

    public boolean isSugarEmpty() {
        return getSugar() == null || getSugar().getRemainingVolume() == 0;
    }

    public boolean isSyrupEmpty() {
        return getSyrup() == null || getSyrup().getRemainingVolume() == 0;
    }

    public CoffeeBeans getCoffeeBeans() {
        return coffeeBeans;
    }

    public void setCoffeeBeans(CoffeeBeans coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    public Water getWater() {
        return water;
    }

    public void setWater(Water water) {
        this.water = water;
    }

    public Milk getMilk() {
        return milk;
    }

    public void setMilk(Milk milk) {
        this.milk = milk;
    }

    public Sugar getSugar() {
        return sugar;
    }

    public void setSugar(Sugar sugar) {
        this.sugar = sugar;
    }

    public Syrup getSyrup() {
        return syrup;
    }

    public void setSyrup(Syrup syrup) {
        this.syrup = syrup;
    }

    public CoffeeBeans getCoffeeBeansStashed() {
        return coffeeBeansStashed;
    }

    public void setCoffeeBeansStashed(CoffeeBeans coffeeBeansStashed) {
        this.coffeeBeansStashed = coffeeBeansStashed;
    }

    public Water getWaterStashed() {
        return waterStashed;
    }

    public void setWaterStashed(Water waterStashed) {
        this.waterStashed = waterStashed;
    }

    public Milk getMilkStashed() {
        return milkStashed;
    }

    public void setMilkStashed(Milk milkStashed) {
        this.milkStashed = milkStashed;
    }

    public Sugar getSugarStashed() {
        return sugarStashed;
    }

    public void setSugarStashed(Sugar sugarStashed) {
        this.sugarStashed = sugarStashed;
    }

    public Syrup getSyrupStashed() {
        return syrupStashed;
    }

    public void setSyrupStashed(Syrup syrupStashed) {
        this.syrupStashed = syrupStashed;
    }

    public CoffeeDrinkComposition makeCoffee(Float coffeeAmount, Float waterAmount, Float milkAmount, Float sugarAmount, Float syrupAmount) throws Exception {
        if (getStatus() != WorkingStatus.WORKING) {
            throw new Exception("The CoffeeMachine doesn't work");
        }
        CoffeeDrinkComposition composition = new CoffeeDrinkComposition();
        if (coffeeAmount != null && coffeeAmount > 0f) {
            setCoffeeBeansStashed(getCoffeeBeans().splitProduct(coffeeAmount));
            composition.add(getCoffeeBeansStashed());
            setCoffeeBeansStashed(null);
        }
        if (waterAmount != null && waterAmount > 0f){
            setWaterStashed(getWater().splitProduct(waterAmount));
            composition.add(getWaterStashed());
            setWaterStashed(null);
        }
        if (milkAmount != null && milkAmount > 0f) {
            setMilkStashed(getMilk().splitProduct(milkAmount));
            composition.add(getMilkStashed());
            setMilkStashed(null);
        }
        if (sugarAmount != null && sugarAmount > 0f) {
            setSugarStashed(getSugar().splitProduct(sugarAmount));
            composition.add(getSugarStashed());
            setSugarStashed(null);
        }
        if (syrupAmount != null && syrupAmount > 0f) {
            setSyrupStashed(getSyrup().splitProduct(syrupAmount));
            composition.add(getSyrupStashed());
            setSyrupStashed(null);
        }
        return composition;
    }
}
