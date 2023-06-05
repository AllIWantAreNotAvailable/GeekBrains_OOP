package Application.Objects;

import Application.Abstracts.CoffeeDrink;
import Application.Enums.CupSizes;
import Application.Enums.Temperature;
import Application.Enums.Units;

import java.util.HashMap;
import java.util.Map;

public class Frappe extends CoffeeDrink {

    public static Map<CupSizes, Map<String, Float>> recipe;
    static {
        recipe = new HashMap<>() {{
            put(CupSizes.medium, new HashMap<>() {{
                        put("CoffeeBeans", 9.0f);
                        put("Water", 150.0f);
                        put("Amount", get("Water"));
                    }}
            );
            put(CupSizes.large, new HashMap<>() {{
                        put("CoffeeBeans", 18.0f);
                        put("Water", 300.0f);
                        put("Amount", get("Water"));
                    }}
            );
        }};
    }


    public Frappe(CupSizes size, Float amount, CoffeeBeans coffeeBeans, Water water) {
        super(switch (size) {
                    case medium -> "Средний";
                    case large -> "Большой";
                    default -> "";
                } + " фраппе",
                amount,
                size,
                Temperature.cold,
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
        return "Frappe{" +
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
