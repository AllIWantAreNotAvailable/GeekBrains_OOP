package Application.Objects;

import Application.Abstracts.CoffeeDrink;
import Application.Enums.CupSizes;
import Application.Enums.Temperature;
import Application.Enums.Units;

import java.util.HashMap;
import java.util.Map;

public class Espresso extends CoffeeDrink {

    public static Map<CupSizes, Map<String, Float>> recipe;
    static {
        recipe = new HashMap<>() {{
            put(CupSizes.small, new HashMap<>() {{
                        put("CoffeeBeans", 9.0f);
                        put("Water", 30.0f);
                        put("Amount", get("Water"));
                    }}
            );
            put(CupSizes.medium, new HashMap<>() {{
                        put("CoffeeBeans", 9.0f);
                        put("Water", 70.0f);
                        put("Amount", get("Water"));
                    }}
            );
            put(CupSizes.large, new HashMap<>() {{
                        put("CoffeeBeans", 18.0f);
                        put("Water", 60.0f);
                        put("Amount", get("Water"));
                    }}
            );
        }};
    }

    public Espresso(CupSizes size, Float amount, CoffeeBeans coffeeBeans, Water water) {
        super(switch (size) {
                    case small -> "Эспрессо";
                    case medium -> "Эспрессо лунго";
                    case large -> "Двойной эспрессо";
                },
                amount,
                size,
                Temperature.hot,
                coffeeBeans,
                water);
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
    public String toString() {
        return "Espresso{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", volume=" + volume +
                ", unit=" + unit +
                ", coffeeBeans=" + coffeeBeans +
                ", water=" + water +
                ", temperature=" + temperature +
                '}';
    }
}
