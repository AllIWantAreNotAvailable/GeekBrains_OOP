package Application.Objects.RawMaterials.Factories;

import Application.Enums.Unit;
import Application.Interface.Factories;
import Application.Objects.RawMaterials.CoffeeBeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CoffeeBeansFactory implements Factories<CoffeeBeans> {

    static Random random;
    private static final List<String> names;
    private static final List<String> placesOfOrigin;

    static {
        random = new Random();

        names = new ArrayList<>() {{
            add("Jardin");
            add("Lavazza");
            add("Bushido");
            add("Julius");
            add("Egoiste");
            add("Лента");
            add("Жокей");
            add("Poetti");
        }};

        placesOfOrigin = new ArrayList<>() {{
            add("Brazil");
            add("Vietnam");
            add("Colombia");
            add("Indonesia");
            add("Honduras");
            add("Ethiopia");
            add("India");
            add("Uganda");
            add("Mexico");
            add("Peru");
            add("Guatemala");
            add("Nicaragua");
            add("Malaysia");
            add("China");
            add("Ivory Coast");
            add("Costa Rica");
            add("Tanzania");
            add("Papua New Guinea");
            add("Kenya");
            add("Thailand");
        }};
    }

    public static String getRndName() {
        return names.get(random.nextInt(names.size()));
    }

    public static Float getDefaultVolume() {
        return 1000f;
    }

    public static Unit getDefaultUnit() {
        return Unit.grams;
    }

    public static String getRndPlaceOfOrigin() {
        return placesOfOrigin.get(random.nextInt(placesOfOrigin.size()));
    }

    @Override
    public CoffeeBeans create() {
        return new CoffeeBeans(getRndName(), getDefaultVolume(), getDefaultUnit(), getRndPlaceOfOrigin());
    }
}
