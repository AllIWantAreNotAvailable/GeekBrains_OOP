import Application.Enums.Units;
import Application.Interface.Factorys.CoffeeBeansFactory;
import Application.Objects.CoffeeBeans;

public class Main {
    public static void main(String[] args) {
        CoffeeBeansFactory coffeeBeansFactory = CoffeeBeans::new;
        CoffeeBeans coffeeBeans = coffeeBeansFactory.create("Arabica", 1000f, Units.grams, "Brazil");
        System.out.println(coffeeBeans);
    }
}