package Application.Objects.RawMaterials.Factories;

import Application.Enums.Unit;
import Application.Interface.Factories;
import Application.Objects.RawMaterials.Milk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MilkFactory implements Factories<Milk> {

    static Random random;
    private static final List<String> names;
    private static final List<String> placesOfOrigin;

    static {
        random = new Random();

        names = new ArrayList<>() {{
            add("Домик в деревне");
            add("Эконива");
            add("Простаквашино");
            add("Parmalat");
            add("Молочная легенда");
            add("Экомилк");
            add("Село зеленое");
            add("Правильное молоко");
        }};

        placesOfOrigin = new ArrayList<>() {{
            add("Арсеньев");
            add("Сухой Лог");
            add("Звенигово");
            add("Ярославль");
            add("Ступино");
            add("Сергиев Посад");
            add("Бирюсинск");
            add("Пошехонье");
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
    public Milk create() {
        return new Milk(getRndName(), getDefaultVolume(), getDefaultUnit(), getRndPlaceOfOrigin());
    }
}
