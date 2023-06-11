package Application.View.Entities;

import Application.Controller.Abstract.ControllerModel;
import Application.Model.Abstracts.ProductForSale;
import Application.Model.Entities.Factories.CoffeeMachine;
import Application.View.Abstract.ViewModel;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleApplication extends ViewModel<CoffeeMachine> {

    public ConsoleApplication() {
        super();
    }

    @Override
    public void handler() {
        String handlerPoint = ">>> ";

        System.out.println("\nWelcome to the coffee shop!");
        Scanner scanner = new Scanner(System.in);
        boolean next = true;
        while (next) {
            System.out.println(mainHandler());
            System.out.printf("%s", handlerPoint);
            switch (scanner.nextInt()) {
                case 1 -> showMenu();
                case 2 -> {
                    System.out.println("Enter the name of the coffee drink or leave\n" +
                            "the entry blank to see the entire price list: ");
                    System.out.printf("%s", handlerPoint);
                    String productName = scanner.next();
                    showProductPrice(productName);
                }
                case 3 -> {
                    System.out.println("Put your money in:");
                    System.out.printf("%s", handlerPoint);
                    cashIn(scanner.nextFloat());
                }
                case 4 -> cashOut();
                case 5 -> {
                    System.out.println("Ready to order? What would you like?");
                    System.out.printf("%s", handlerPoint);
                    String productName = scanner.next();

                    System.out.println("\nPut your money in:");
                    System.out.printf("%s", handlerPoint);
                    float cash = scanner.nextFloat();

                    try {
                        getProduct(productName, cash);
                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                }
                case 6 -> showSoldProducts();
                default -> {
                    System.out.println("Thanks for visiting us!");
                    next = false;
                }
            }
        }

    }

    private String mainHandler() {
        return """
                ### COMMAND MENU ###
                (Enter command number)
                1. Show coffee menu
                2. Show product price(s)
                3. Cash in
                4. Cash out
                5. Make order
                6. Show sold products sorted list
                0. EXIT
                """;
    }

    @Override
    public long getFormUUID() {
        return super.formUUID;
    }

    @Override
    protected void setFormUUID(long formUUID) {
        super.formUUID = formUUID;
    }

    @Override
    public ControllerModel getController() {
        return super.controller;
    }

    @Override
    public void setController(ControllerModel controller) {
        super.controller = controller;
    }

    @Override
    public void showMenu() {
        System.out.println("### MENU ###");
        for (String row :
                getController()
                        .getPriceList()
                        .keySet()) {
            System.out.printf("• %s\n", row);
        }
        System.out.println("\n");
    }

    @Override
    public void showProductPrice(String productName) {
        System.out.println("### PRICE LIST ###");
        Map<String, Float> priceList = getController().getPriceList();
        if (productName == null || productName.equals("")) {
            for (Map.Entry<String, Float> row :
                    getController()
                            .getPriceList()
                            .entrySet()) {
                System.out.printf("• %s - %.00f RUB\n", row.getKey(), row.getValue());
            }
            System.out.println("\n");
        } else {
            System.out.printf("• %s - ", productName);
            Float price = priceList.get(productName);
            String result = price != null ? String.format("%.00f RUB\n", price) : "Product not found D';";
            System.out.println(result);
        }
    }

    @Override
    public void cashIn(Float cash) {
        getController().makeDeposit(cash);
    }

    @Override
    public void cashOut() {
        System.out.printf("Your change - %.00f RUB\n\n", getController().getChange());
    }

    @Override
    public void getProduct(String productName, Float cash) throws Exception {
        System.out.println("Here is your coffee:");
        System.out.printf("-> %s\n\n", getController().buyProduct(productName, cash));
    }

    public void showSoldProducts() {
        System.out.println("### SORTED SOLD PRODUCTS ###");
        List soldSortedList = getController().getSoldSortedList();
        for (Object product:
                soldSortedList) {
            System.out.printf("%d) %s\n", soldSortedList.indexOf(product) + 1, product);
        }
    }
}
