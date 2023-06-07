import data.Student;
import data.User;
import data.UserComparator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    /*
    + Создать класс Юзер и перенести его в базовые поля (ФИО)
    - Модифицировать ранее созданный класс СтудентКомпаратор:
        + Переименовать в ЮзерКомпаратор;
        + Типизировать его T наследующегося от типа Юзер;
        + Типизировать реализуемый интерфейс Компаратор T;
        + Изменить метод compare(), внеся во входные данные вместо конкретных классов типизацию T.
    + Внести правки места, где использовался предыдущий компаратор.
     */
    public static void main(String[] args) {
        Student student0 = new Student(0, "Ivan", "Petrov", "?!", LocalDate.now());
        Student student1 = new Student(1, "Petr", "Ivanov", "?!", LocalDate.now());
        Student student2 = new Student(2, "Genadiy", "Sidorov", "?!", LocalDate.now());
        Student student3 = new Student(3, "Pavel", "Tretyakov", "?!", LocalDate.now());
        Student student4 = new Student(4, "Maria", "Kosova", "?!", LocalDate.now());
        Student student5 = new Student(5, "Svetlana", "Pervaya", "?!", LocalDate.now());

        List<User> users = new ArrayList<>(){{
            add(student4);
            add(student1);
            add(student5);
            add(student0);
            add(student3);
            add(student2);
        }};
        System.out.println(users);
        users.sort(new UserComparator<>());
        System.out.println(users);

    }
}