package Application.Objects;

import Application.Abstracts.CoffeeDrink;
import Application.Enums.CupSizes;
import Application.Enums.Temperature;
import Application.Enums.Units;

public class Cappuccino extends CoffeeDrink {
    Milk milk;
    public Cappuccino(CupSizes size, Float amount, CoffeeBeans coffeeBeans, Water water, Milk milk) {
        super(switch (size) {
                    case small -> "Маленький";
                    case medium -> "Средний";
                    case large -> "Большой";
                } + " капучино",
                amount,
                size,
                Temperature.hot,
                coffeeBeans,
                water);
        this.milk = milk;
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public Float getVolume() {
        return super.volume;
    }

    @Override
    public Units getUnit() {
        return super.unit;
    }
}
