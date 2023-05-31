import Application.Abstracts.Product;
import Application.Interfaces.Products;
import Application.Objects.ChocolateBars;
import Application.Objects.VendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    TODO 1. Задачи:
     - Создать наследника реализованного класса ГорячийНапиток с дополнительным полем int температура.

    TODO 2. Задачи:
     - Создать класс ГорячихНапитковАвтомат реализующий интерфейс ТорговыйАвтомат;
     - реализовать перегруженный метод getProduct(int name, int volume, int temperature), выдающий продукт
     соответствующий имени, объёму и температуре.

    TODO 3. Задачи:
     - В main проинициализировать несколько ГорячихНапитков и ГорячихНапитковАвтомат и воспроизвести
     логику, заложенную в программе.

    TODO 4. Всё вышеуказанное создать согласно принципам ООП, пройденным на семинаре.
    
    ### Комментарии ### 
    TODO Заменить возврат пустых списков(объектов) на null.
     */
    public static void main(String[] args) {
//        onlineTasks();
    }

    private static void onlineTasks() {
        List<Products> productsList = getProductsList();

        productsList.addAll(getProductsList());
        productsList.addAll(getProductsList());
        productsList.addAll(getProductsList());

        VendingMachine vendingMachine = new VendingMachine(productsList);
        productsList = getProductsList();
        System.out.printf("vendingMachine.isEmpty() == %b\n", vendingMachine.isEmpty());
        Random random = new Random();
        while (!vendingMachine.isEmpty()) {
            if (!productsList.isEmpty()) {
                System.out.println(vendingMachine.getProduct(
                                productsList.get(
                                        random.nextInt(0, productsList.size())
                                ).getName(),
                                random.nextFloat(99.99f, 100.1f)
                        )
                );
            }
        }
        System.out.printf("vendingMachine.isEmpty() == %b\n", vendingMachine.isEmpty());
    }

    private static List<Products> getProductsList() {
        return new ArrayList<>() {
            {
                add(new ChocolateBars("SNICKERS", 100.0f));
                add(new ChocolateBars("MARS", 100.0f));
                add(new ChocolateBars("BOUNTI", 100.0f));
                add(new ChocolateBars("TWIX", 100.0f));
                add(new ChocolateBars("БАБАЕВСКИЙ", 100.0f));
                add(new ChocolateBars("PICNIC", 100.0f));
                add(new ChocolateBars("NUTS", 100.0f));
                add(new ChocolateBars("KITKAT", 100.0f));
                add(new ChocolateBars("MILKY WAY", 100.0f));
                add(new ChocolateBars("MILKA", 100.0f));
            }
        };
    }
}