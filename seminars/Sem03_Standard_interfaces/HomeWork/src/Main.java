import Application.Model.Abstracts.ProductRaw;
import Application.Model.Entities.*;
import Application.Model.Entities.Factories.CoffeeMachine;
import Application.Model.Enumerations.SugarTypes;
import Application.Services.Abstract.ProductService;
import Application.Services.Entities.CoffeeService;

public class Main {

    public static void main(String[] args) throws Exception {

        simpleTests();


    }

    private static void simpleTests() throws Exception {
        // Raw Products:
        System.out.println("\nRaw Products:");
        CoffeeBeans coffeeBeans = new CoffeeBeans("Egoist", "Brazil", 1000f, 3500f);
        Water water = new Water("Baikal", 0.4f, 1000f, 50f);
        Milk milk = new Milk("MKC", 6.2f, 1000f, 60f);
        Sugar sugar = new Sugar("Sugar", SugarTypes.CANE, 1000f, 500f);
        Syrup syrup = new Syrup("Pumpkin", "Sweet & Spicy", 1000f, 567f);

        System.out.printf("%s\n%s\n%s\n%s\n%s\n\n", coffeeBeans, water, milk, sugar, syrup);


        // Coffee machine:
        System.out.println("Coffee machine:");
        CoffeeMachine coffeeMachine = new CoffeeMachine(coffeeBeans, water, milk, sugar, syrup);
        System.out.printf("%s\n", coffeeMachine);
        coffeeMachine.switchStatus();
        System.out.printf("%s\n\n", coffeeMachine);

        // Product composition:
        System.out.println("Product composition:");
        CoffeeDrinkComposition espressoComposition = coffeeMachine.makeCoffee(9f, 30f, 0f, 0f, 0f);
        System.out.printf("%s\n\n", espressoComposition);

        // More composition:
        CoffeeDrinkComposition americanoComposition = coffeeMachine.makeCoffee(9f, 60f, 0f, 0f, 0f);
        CoffeeDrinkComposition cappuccinoComposition = coffeeMachine.makeCoffee(9f, 30f, 20f, 0f, 0f);
        CoffeeDrinkComposition latteComposition = coffeeMachine.makeCoffee(9f, 30f, 40f, 0f, 0f);

        // Composition iterator:
        System.out.println("Composition iterator:");
        for (ProductRaw productRaw : cappuccinoComposition) {
            System.out.printf("%s\n", productRaw);
        }
        System.out.println();

        // Coffee drink:
        System.out.println("Coffee drink:");
        CoffeeDrink espresso = new CoffeeDrink("Espresso", espressoComposition.getComposition(), 100f);
        CoffeeDrink americano = new CoffeeDrink("Americano", americanoComposition.getComposition(), 150f);
        CoffeeDrink cappuccino = new CoffeeDrink("Cappuccino", cappuccinoComposition.getComposition(), 200f);
        CoffeeDrink latte = new CoffeeDrink("Latte", latteComposition.getComposition(), 250f);
        System.out.printf("%s\n%s\n%s\n%s\n\n", espresso, americano, cappuccino, latte);

        // Product service:
        System.out.println("Product service:");
        ProductService<CoffeeMachine> coffeeService = new CoffeeService(coffeeMachine);
        // TODO: 10.06.2023 Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Float.floatValue()" because the return value of "Application.Services.Entities.CoffeeService.getDeposit()" is null
        //  at Application.Services.Entities.CoffeeService.buyProduct(CoffeeService.java:191)
        //  at Main.simpleTests(Main.java:66)
        //  at Main.main(Main.java:12)
        for (String productName :
                coffeeService.getPriceList().keySet()) {
            System.out.println(coffeeService.buyProduct(productName, 500f));
        }

    }

}