import Application.Controller.Abstract.ControllerModel;
import Application.Controller.Entities.MainController;
import Application.Model.Abstracts.ProductRaw;
import Application.Model.Entities.*;
import Application.Model.Entities.Factories.CoffeeMachine;
import Application.Model.Enumerations.SugarTypes;
import Application.Services.Abstract.ProductService;
import Application.Services.Entities.CoffeeService;
import Application.View.Entities.ConsoleApplication;

public class Main {

    public static void main(String[] args) {
        // Model and service tests:
//        simpleTests();
        // UI tests:
        uiTesting();
    }

    private static void uiTesting() {
        // Initialize:
        RawProducts products = rawProductsTest();
        CoffeeMachine coffeeMachine = new CoffeeMachine(
                products.coffeeBeans(),
                products.water(),
                products.milk(),
                products.sugar(),
                products.syrup()
        );
        coffeeMachine.switchStatus(); // Главное – не забывать включить)
        CoffeeService coffeeVending = new CoffeeService(coffeeMachine);
        ConsoleApplication view = new ConsoleApplication();
        ControllerModel<CoffeeService, ConsoleApplication> controller = new MainController(coffeeVending, view);

        // Run view
        view.handler();
    }

    private static void simpleTests() throws Exception {

        // Raw Products:
        RawProducts resultOfRawProductTest = rawProductsTest();
        System.out.printf(
                "%s\n%s\n%s\n%s\n%s\n\n",
                resultOfRawProductTest.coffeeBeans(),
                resultOfRawProductTest.water(),
                resultOfRawProductTest.milk(),
                resultOfRawProductTest.sugar(),
                resultOfRawProductTest.syrup()
        );

        // Coffee machine:
        CoffeeMachine coffeeMachine = coffeeMachineTest(resultOfRawProductTest);

        // Product composition:
        coffeeDrinkCompositionTest resultOfDrinkCompositionTest = coffeeDrinkCompositionTest(coffeeMachine);

        // Composition iterator:
        compositionIteratorTest(resultOfDrinkCompositionTest);

        // Coffee drink:
        coffeeDrinkTest(resultOfDrinkCompositionTest);

        // Product service:
        productServiceTest(coffeeMachine);

    }

    private static void productServiceTest(CoffeeMachine coffeeMachine) throws Exception {
        System.out.println("Product service:");
        ProductService<CoffeeMachine> coffeeService = new CoffeeService(coffeeMachine);
        for (String productName :
                coffeeService.getPriceList().keySet()) {
            System.out.println(coffeeService.buyProduct(productName, 500f));
            System.out.printf("Ваша сдача: %.00f RUB\n", coffeeService.getChange());
        }
        System.out.println(coffeeService.getChange());
    }

    private static void coffeeDrinkTest(coffeeDrinkCompositionTest resultOfDrinkCompositionTest) {
        System.out.println("Coffee drink:");
        CoffeeDrink espresso = new CoffeeDrink("Espresso", resultOfDrinkCompositionTest.espressoComposition().getComposition(), 100f);
        CoffeeDrink americano = new CoffeeDrink("Americano", resultOfDrinkCompositionTest.americanoComposition().getComposition(), 150f);
        CoffeeDrink cappuccino = new CoffeeDrink("Cappuccino", resultOfDrinkCompositionTest.cappuccinoComposition().getComposition(), 200f);
        CoffeeDrink latte = new CoffeeDrink("Latte", resultOfDrinkCompositionTest.latteComposition().getComposition(), 250f);
        System.out.printf("%s\n%s\n%s\n%s\n\n", espresso, americano, cappuccino, latte);
    }

    private static void compositionIteratorTest(coffeeDrinkCompositionTest resultOfDrinkCompositionTest) {
        System.out.println("Composition iterator:");
        for (ProductRaw productRaw : resultOfDrinkCompositionTest.cappuccinoComposition()) {
            System.out.printf("%s\n", productRaw);
        }
        System.out.println();
    }

    private static coffeeDrinkCompositionTest coffeeDrinkCompositionTest(CoffeeMachine coffeeMachine) throws Exception {
        System.out.println("Product composition:");
        CoffeeDrinkComposition espressoComposition = coffeeMachine.makeCoffee(9f, 30f, 0f, 0f, 0f);
        CoffeeDrinkComposition americanoComposition = coffeeMachine.makeCoffee(9f, 60f, 0f, 0f, 0f);
        CoffeeDrinkComposition cappuccinoComposition = coffeeMachine.makeCoffee(9f, 30f, 20f, 0f, 0f);
        CoffeeDrinkComposition latteComposition = coffeeMachine.makeCoffee(9f, 30f, 40f, 0f, 0f);
        System.out.printf("%s\n\n", espressoComposition);
        coffeeDrinkCompositionTest resultOfDrinkCompositionTest = new coffeeDrinkCompositionTest(espressoComposition, americanoComposition, cappuccinoComposition, latteComposition);
        return resultOfDrinkCompositionTest;
    }

    private static CoffeeMachine coffeeMachineTest(RawProducts resultOfRawProductTest) {
        System.out.println("Coffee machine:");
        CoffeeMachine coffeeMachine = new CoffeeMachine(resultOfRawProductTest.coffeeBeans(), resultOfRawProductTest.water(), resultOfRawProductTest.milk(), resultOfRawProductTest.sugar(), resultOfRawProductTest.syrup());
        System.out.printf("%s\n", coffeeMachine);
        coffeeMachine.switchStatus();
        System.out.printf("%s\n\n", coffeeMachine);
        return coffeeMachine;
    }

    private static RawProducts rawProductsTest() {
        System.out.println("\nRaw Products:");
        CoffeeBeans coffeeBeans = new CoffeeBeans("Egoist", "Brazil", 1000f, 3500f);
        Water water = new Water("Baikal", 0.4f, 1000f, 50f);
        Milk milk = new Milk("MKC", 6.2f, 1000f, 60f);
        Sugar sugar = new Sugar("Sugar", SugarTypes.CANE, 1000f, 500f);
        Syrup syrup = new Syrup("Pumpkin", "Sweet & Spicy", 1000f, 567f);

        return new RawProducts(coffeeBeans, water, milk, sugar, syrup);
    }

    private record coffeeDrinkCompositionTest(CoffeeDrinkComposition espressoComposition,
                                              CoffeeDrinkComposition americanoComposition,
                                              CoffeeDrinkComposition cappuccinoComposition,
                                              CoffeeDrinkComposition latteComposition) {
    }

    private record RawProducts(CoffeeBeans coffeeBeans, Water water, Milk milk, Sugar sugar, Syrup syrup) {
    }

}