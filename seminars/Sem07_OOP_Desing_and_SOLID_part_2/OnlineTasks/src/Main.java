public class Main {

    // Class<HotDrink> – абстрактный:
    //  - protected int id
    //  - protected int temperature
    //  - protected float cost

    // Class<Coffee> extends HotDrink:
    //  - private String Brand
    //  - private String sort
    //  - private boolean isRoasted

    // Class<Tea> extends HotDrink:
    //  - private boolean isGreen
    //  - private String Region

    // Interface<HotDrinksVendingMachine<T extends HotDrink>>:
    //  - void sell(int id)
    //  - void loadSomething(List<T> drinks)

    // Interface<CoffeeVendingMachine> extends HotDrinksVendingMachine:
    //  - void roast()

    // Interface<TeaVendingMachine> extends HotDrinksVendingMachine:
    //  - void putWater()

    // TODO: 16.06.2023 Class<CoffeeVendingMachineImpl> implements CoffeeVendingMachine

    // TODO: 16.06.2023 Class<TeaVendingMachineImpl> implements TeaVendingMachine

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}