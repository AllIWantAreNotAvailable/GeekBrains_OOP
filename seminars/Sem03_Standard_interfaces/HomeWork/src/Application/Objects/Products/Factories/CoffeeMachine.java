package Application.Objects.Products.Factories;

import Application.Enums.CoffeeAssortment;
import Application.Enums.Unit;
import Application.Interface.Products;
import Application.Interface.Vending;
import Application.Objects.Products.Americano;
import Application.Objects.Products.Espresso;
import Application.Objects.RawMaterials.CoffeeBeans;
import Application.Objects.RawMaterials.Water;

public class CoffeeMachine implements Vending<CoffeeAssortment> {

    private CoffeeBeans coffeeBeans;
    private CoffeeBeans coffeeBeansStashed;
    private Water water;
    private Water waterStashed;

    public CoffeeMachine(CoffeeBeans coffeeBeans, Water water) {
        setCoffeeBeans(coffeeBeans);
        setWater(water);
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

    public CoffeeBeans getCoffeeBeansStashed() {
        return coffeeBeansStashed;
    }

    public void setCoffeeBeansStashed(Float volume, Unit unit) throws Exception {
        if (volume == null || unit == null) {
            return;
        }
        if (getWaterStashed() == null) {
            this.coffeeBeansStashed = (CoffeeBeans) getCoffeeBeans().getPieceOfProduct(volume, unit);
        } else {
            if (getCoffeeBeansStashed().getVolume() < volume) {
                getCoffeeBeans().transferVolume(getCoffeeBeansStashed(), volume - getCoffeeBeansStashed().getVolume(), unit);
            } else if (getCoffeeBeansStashed().getVolume() > volume) {
                getCoffeeBeansStashed().transferVolume(getCoffeeBeans(), getCoffeeBeans().getVolume() - volume, unit);
            }
        }
    }

    public void setCoffeeBeansStashed(CoffeeBeans coffeeBeans) {
        this.coffeeBeansStashed = coffeeBeans;
    }

    public Water getWaterStashed() {
        return waterStashed;
    }

    public void setWaterStashed(Float volume, Unit unit) throws Exception {
        if (volume == null || unit == null) {
            return;
        }
        if (getWaterStashed() == null) {
            this.waterStashed = (Water) getWater().getPieceOfProduct(volume, unit);
        } else {
            if (getWaterStashed().getVolume() < volume) {
                getWater().transferVolume(getWaterStashed(), volume - getWaterStashed().getVolume(), unit);
            } else if (getCoffeeBeansStashed().getVolume() > volume) {
                getWaterStashed().transferVolume(getWater(), getWaterStashed().getVolume() - volume, unit);
            }
        }
    }

    public void setWaterStashed(Water water) {
        this.waterStashed = water;
    }

    @Override
    public Products create(CoffeeAssortment coffee) throws Exception {
        return switch (coffee) {
            case espresso -> {
                setCoffeeBeansStashed(Espresso.defaultCoffeeBeansVolume, getCoffeeBeans().getUnit());
                setWaterStashed(Espresso.defaultWaterVolume, getWater().getUnit());
                if (getCoffeeBeansStashed() != null || getWaterStashed() != null) {
                    CoffeeBeans tempCoffeeBeans = getCoffeeBeansStashed();
                    Water tempWater = getWaterStashed();
                    setCoffeeBeansStashed(null);
                    setWaterStashed(null);
                    yield new Espresso(tempCoffeeBeans, tempWater);
                }
                throw new Exception("Not enough raw materials");
            }
            case americano -> {
                setCoffeeBeansStashed(Espresso.defaultCoffeeBeansVolume, getCoffeeBeans().getUnit());
                setWaterStashed(Espresso.defaultWaterVolume + Americano.defaultWaterVolume, getWater().getUnit());
                if (getCoffeeBeansStashed() != null || getWaterStashed() != null) {
                    CoffeeBeans tempCoffeeBeans = getCoffeeBeansStashed();
                    Water tempWater = getWaterStashed();
                    setCoffeeBeansStashed(null);
                    setWaterStashed(null);
                    yield new Americano(
                            new Espresso(
                                    tempCoffeeBeans,
                                    (Water) tempWater.getPieceOfProduct(Espresso.defaultWaterVolume, tempWater.getUnit())
                            ),
                            tempWater
                    );
                }
                throw new Exception("Not enough raw materials");
            }
            default -> {
                throw new Exception("Product not found");
            }
        };
    }

    @Override
    public String toString() {
        return "CoffeeMachine{" +
                "\ncoffeeBeans=" + getCoffeeBeans() +
                ", \ncoffeeBeansStashed=" + getCoffeeBeansStashed() +
                ", \nwater=" + getWater() +
                ", \nwaterStashed=" + getWaterStashed() +
                "\n}";
    }
}
