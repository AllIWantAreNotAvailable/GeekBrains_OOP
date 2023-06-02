package Application.Objects;

import Application.Abstracts.CoffeeDrink;
import Application.Enums.CupSizes;
import Application.Enums.Temperature;
import Application.Enums.Units;

import java.util.HashMap;
import java.util.Map;

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

    @Override
    public Map<CupSizes, Map<String, Float>> getRecipe() {
        return new HashMap<>() {{
            put(CupSizes.small, new HashMap<>() {{
                        put("CoffeeBeans", 30.0f);
                        put("Water", 70.0f);
                        put("Milk", 30.0f);
                    }}
            );
            put(CupSizes.medium, new HashMap<>() {{
                        put("CoffeeBeans", 40.0f);
                        put("Water", 140.0f);
                        put("Milk", 60.0f);
                    }}
            );
            put(CupSizes.large, new HashMap<>() {{
                        put("CoffeeBeans", 60.0f);
                        put("Water", 280.0f);
                        put("Milk", 120.0f);
                    }}
            );
        }};
    }
}
