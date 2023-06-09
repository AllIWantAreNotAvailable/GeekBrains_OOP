import controller.UserController;
import model.Disciplines;
import model.Student;

public class Main {

    /*
    Задание 1:
     Реализовать абстрактный класс User и его наследники Student и Teacher.
     Родитель имеет в себе общие данные (пример: фио, год рождения и тд),
     а наследники собственные параметры
     (какие, по выбору преподавателя – Пример: studentId для Student, disciplesTaught для Teacher).

     Задание 2
      1. Создать package – controller. Работу продолжаем в нем
      2. Создать класс Controller агрегирующий в себе необходимые классы в виде полей, а инициализируем прям в поле.
      3. Создаем метод созданиеСтудента – реализующий логику, путем вызова соответствующих методов интерфейсов:
        1. Создания Студента в сервисе
        2. Возвращение всех студентов в сервисе
        3. Вызов view и передача списка найденных студентов
     */
    // view – консоль
    public static void main(String[] args) {
        UserController userController = new UserController();

        userController.saveStudent("Q", "A", "01.01.0001", 1, 'A');
        userController.saveStudent("W", "S", "01.01.0001", 2, 'B');
        userController.saveStudent("E", "D", "01.01.0001", 3, 'C');
        userController.saveStudent("R", "F", "01.01.0001", 4, 'D');
        userController.saveStudent("T", "G", "01.01.0001", 5, 'A');
        userController.saveStudent("Y", "H", "01.01.0001", 6, 'B');
        userController.saveStudent("U", "J", "01.01.0001", 7, 'C');
        userController.saveStudent("I", "K", "01.01.0001", 8, 'D');
        userController.saveStudent("O", "L", "01.01.0001", 9, 'A');
        userController.saveStudent("P", "Z", "01.01.0001", 10, 'B');

        userController.saveTeacher("Maria", "Ivanova", "01.01.0001", Disciplines.GEOGRAPHY);
        userController.saveTeacher("Olga", "Volkova", "01.01.0001", Disciplines.MATH);
        userController.saveTeacher("Irina", "Suhareva", "01.01.0001", Disciplines.LANGUAGE);
        userController.saveTeacher("Evgenia", "Jujikova", "01.01.0001", Disciplines.PROGRAMMING);

        userController.deleteUser(10);
        userController.getAllUsers();
        userController.getStudents();
    }
}