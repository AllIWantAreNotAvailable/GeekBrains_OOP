import Application.Abstract.Calculator;
import Application.Objects.SimpleCalculator;

public class Main {
    /*
    Написать калькулятор в ООП стиле(инкапсуляция, наследование. полиморфизм)
     */
    public static void main(String[] args) {
        simpleCalculator();
    }

    private static void simpleCalculator() {
        Calculator calculator = new SimpleCalculator();

        // 1. Больше про наследование и имплементацию
        System.out.println("1. Больше про наследование и имплементацию");
        // 1.1. Сложение
        System.out.println("Сложение:");
        System.out.println(calculator.add(2, 2));
        System.out.println(calculator.add(2));

        // 1.2. Вычитание
        System.out.println("Вычитание:");
        System.out.println(calculator.subtract(6, 2));
        System.out.println(calculator.subtract(2));

        // 1.3. Умножение
        System.out.println("Умножение:");
        System.out.println(calculator.multiply(2, 2));
        System.out.println(calculator.multiply(2));

        // 1.4. Деление
        System.out.println("Деление:");
        System.out.println(calculator.divide(8, 2));
        System.out.println(calculator.divide(2));

        // 1.5. Возведение в степень
        System.out.println("Возведение в степень:");
        System.out.println(calculator.exponent(2, 2));
        System.out.println(calculator.exponent(2));

        System.out.println("------------------------");

        // 2. Немного инкапсуляции, правда с сохранением предыдущих методов в тригере public:
        System.out.println("2. Немного инкапсуляции, правда с сохранением предыдущих методов в тригере public:");
        try {
            // 2.1. Сложение
            System.out.println("Сложение:");
            System.out.println(calculator.getResult(2, "+", 2));
            System.out.println(calculator.getResult(2, "+"));

            // 2.2. Вычитание
            System.out.println("Вычитание:");
            System.out.println(calculator.getResult(6, "-", 2));
            System.out.println(calculator.getResult(2, "-"));

            // 2.3. Умножение
            System.out.println("Умножение:");
            System.out.println(calculator.getResult(2, "x", 2));
            System.out.println(calculator.getResult(2, "x"));

            // 2.4. Деление
            System.out.println("Деление:");
            System.out.println(calculator.getResult(8, "/", 2));
            System.out.println(calculator.getResult(2, "/"));

            // 2.5. Возведение в степень
            System.out.println("Возведение в степень:");
            System.out.println(calculator.getResult(2, "^", 2));
            System.out.println(calculator.getResult(2, "^"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}