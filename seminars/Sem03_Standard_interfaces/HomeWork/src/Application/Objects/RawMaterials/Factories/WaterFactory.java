package Application.Objects.RawMaterials.Factories;

import Application.Enums.Unit;
import Application.Interface.Factories;
import Application.Objects.RawMaterials.Water;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WaterFactory implements Factories<Water> {

    static Random random;
    private static final List<String> names;
    private static final List<String> placesOfOrigin;

    static {
        random = new Random();

        names = new ArrayList<>() {{
            add("Шишкин лес");
            add("Святой источник");
            add("365 дней");
            add("Черноголовка");
            add("Aqua Minerale");
        }};

        placesOfOrigin = new ArrayList<>() {{
            add("Россия");
            add("Беларусь");
        }};
    }

    public static String getRndName() {
        return names.get(random.nextInt(names.size()));
    }

    public static Float getDefaultVolume() {
        return 1000f;
    }

    public static Unit getDefaultUnit() {
        return Unit.milliliters;
    }

    public static String getRndPlaceOfOrigin() {
        return placesOfOrigin.get(random.nextInt(placesOfOrigin.size()));
    }

    @Override
    public Water create() {
        return new Water(getRndName(), getDefaultVolume(), getDefaultUnit(), getRndPlaceOfOrigin());
    }
}
