import Application.Enums.CupSizes;
import Application.Interfaces.Products;
import Application.Objects.*;

public class Main {
    /*
    ### OnlineTasks ###
    Задача 1 - Абстракция:
     Реализуйте:
      - класс Товар, содержащий данные о товаре;
      - ТорговыйАвтомат, содержащий в себе методы:
        * initProducts (List <Product>) сохраняющий в себе список исходных продуктов;
        * getProduct(String name).

    Задача 2 - Инкапсуляция:
     Реализуйте:
      - конструкторы;
      - get/set методы;
      - постройте логику ТорговогоАвтомата на основе кода сделанного в предыдущем задании.

    Задача 3 - Наследование:
     - Сделайте класс Товар абстрактным:
        * создайте нескольких наследников (к примеру: БутылкаВоды);
     - сделайте интерфейсом ТорговыйАвтомат:
        * реализуйте класс какого-то одного типа ТорговогоАвтомата (пример: ПродающийБутылкиВодыАвтомат).

    Задача 4 - Полиморфизм:
     1) Товар:
        + переопределите метод toString для Товара;
        + запустите программу;
        + после этого переопределите для наследника этот метод;
        + после запуска обратите внимание на изменение поведения;
     2) ТорговыйАвтомат:
        + создайте перегруженный метод выдачи товара ТорговымАвтоматом дополнив дополнительным входным
     параметром (пример: getProduct(String name) выдающий товар по имени;
        + создайте метод возвращающий товар по имени и какому-либо параметру товара getProduct(String name, int volume).

    ### HomeWork ###
    1. Задачи:
     - Создать наследника реализованного класса ГорячийНапиток с дополнительным полем int температура.

    2. Задачи:
     - Создать класс ГорячихНапитковАвтомат реализующий интерфейс ТорговыйАвтомат;
     - реализовать перегруженный метод getProduct(int name, int volume, int temperature), выдающий продукт
     соответствующий имени, объёму и температуре.

    3. Задачи:
     - В main проинициализировать несколько ГорячихНапитков и ГорячихНапитковАвтомат и воспроизвести
     логику, заложенную в программе.

    4. Всё вышеуказанное создать согласно принципам ООП, пройденным на семинаре.

     */
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(new CoffeeBeans("Arabic", 110f, "Brazil"),
                new Water("Aqua minerale", 330f, "Russia, Moscow"),
                new Milk("Parmalat", 220f, "Russia, Moscow"));

        Products espresso = coffeeMachine.getProduct("Espresso", CupSizes.small);
        System.out.println(espresso);

        Products americano = coffeeMachine.getProduct("Americano", CupSizes.medium);
        System.out.println(americano);

        Products cappuccino = coffeeMachine.getProduct("Cappuccino", CupSizes.large);
        System.out.println(cappuccino);

        Products latte = coffeeMachine.getProduct("Latte", CupSizes.medium);
        System.out.println(latte);

        Products frappe = coffeeMachine.getProduct("Frappe", CupSizes.large);
        System.out.println(frappe);
    }
}