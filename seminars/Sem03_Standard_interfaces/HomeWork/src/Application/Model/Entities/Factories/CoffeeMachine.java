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
            this.status = WorkingStatus.NOT_ENOUGH_INGREDIENTS;
        } else {
            if (status == WorkingStatus.NOT_ENOUGH_INGREDIENTS) {
                switchStatus();
            } else {
                this.status = status;
            }
        }
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


}
