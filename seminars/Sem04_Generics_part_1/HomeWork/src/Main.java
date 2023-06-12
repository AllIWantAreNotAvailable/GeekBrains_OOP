import Entities.*;
import Entities.Student.*;
import Entities.Teacher.Teacher;
import Entities.Teacher.TeachersGroup;

import java.util.ArrayList;
import java.util.List;

public class Main {




    // Задача 3.5
    // TODO: 11.06.2023 Создать класс Поток содержащий в себе список УчебныхГрупп и реализующий интерфейс Iterator
    // TODO: 11.06.2023 Создать класс StreamComparator, реализующий сравнение количества групп входящих в Поток
    // TODO: 11.06.2023 Создать класс ПотокСервис, добавив в него метод сортировки списка потоков, используя созданный
    //  StreamComparator
    // TODO: 11.06.2023 Модифицировать класс Контроллер, добавив в него созданный сервис
    // TODO: 11.06.2023 Модифицировать класс Контроллер, добавив в него метод сортирующий список потоков, путем вызова
    //  созданного сервиса


    // Задача 4.1:
    // + Создать класс Юзер и перенести в него базовые поля (ФИО)
    // TODO: 11.06.2023 Модифицировать ранее созданный класс СтудентКомпаратор:
    //  - Переименовать в ЮзерКомпаратор
    //  - Типизировать его T наследующегося от типа Юзер<T extends Abstracts.User>
    // TODO: 11.06.2023 Типизировать реализуемый интерфейс Компаратор T
    // TODO: 11.06.2023 Изменить метод компаре,внеся во входные данные вместо конкретных классов типизацию T
    // TODO: 11.06.2023 Внести правки места, где использовался предыдущий компаратор


    // Задача 4.2:
    // TODO: 11.06.2023 Создать интерфейс ЮзерВью
    // TODO: 11.06.2023 Типизировать его T наследующегося от типа Юзер
    // TODO: 11.06.2023 Создать в нем метод sendOnConsole(List<Student> students) используя типизацию
    // TODO: 11.06.2023 Создать класс СтудентВью реализующий созданный интерфейс


    // Задача 4.3:
    // TODO: 11.06.2023 Модифицировать ранее созданный класс Контроллер переименовав его в StudentController
    // TODO: 11.06.2023 Создайте новый интерфейс UserController
    //  - Опишите в нем метод create
    //  - Типизировать его T наследующегося от типа Юзер
    // TODO: 11.06.2023 В классе СтудентКонтроллер реализуйте интерфейс UserController
    // TODO: 11.06.2023 Добавить в методы контроллера вывод в консоль с помощью метода sendOnConsole


    // Задача 4.4:
    // TODO: 11.06.2023 Создать класс УчительСервис и реализовать аналогично проедланному на семинаре
    // TODO: 11.06.2023 Создать класс УчительВью и реализовать аналогично проедланному на семинаре
    // TODO: 11.06.2023 Создать класс УчительКонтроллер и реализовать возможность создания, редактирования конкретного
    //  учителя и отображения списка учителей имеющихся в системе

    public static void main(String[] args) {
        seminar3HomeWork();


        // BLOCK 3.1, TESTS:
//        StudentsGroup studentsGroup = BLOCK_3_1_TESTS(false);

        // BLOCK 3.2, TESTS:
//        ServiceAndController tuple = BLOCK_3_2_TESTS(studentsGroup, false);

        // BLOCK 3.3, TESTS:
//        BLOCK_3_4_TESTS(tuple, true);


    }

    private static void seminar3HomeWork() {
        TeachersGroup teachersGroup = new TeachersGroup();
        teachersGroup.add(new Teacher("Алла", "Орлова", 10));
        teachersGroup.add(new Teacher("Ольга", "Волкова", 4));
        teachersGroup.add(new Teacher("Ирина", "Петрова", 20));
        teachersGroup.add(new Teacher("Евгения", "Онегина", 2));

        List<Teacher> teacherList = teachersGroup.sorted(new UsersComparatorFullName<>());

        int count = 0;
        for (Teacher teacher :
                teacherList) {
            System.out.printf("%d) %s\n", ++count, teacher);
        }
    }

    /**
     * Задача 3.1 - Iterator:
     * + Создать класс Студент;
     * + Создать класс УчебнаяГруппа;
     * + Создать класс УчебнаяГруппаИтератор, заставив его реализовать интерфейс Iterator:
     *     - Реализовать его контракты (включая удаление).
     * @param consoleOut Вывод результата в консоль
     * @return Экземпляр заполненного StudentsGroup
     */
    private static StudentsGroup BLOCK_3_1_TESTS(boolean consoleOut) {
        // ### STUDENT ###
        Student student0 = new Student("Вероника", "Тарасова");
        Student student1 = new Student("Анастасия", "Афанасьева");
        Student student2 = new Student("Мирослава", "Тарасова");
        Student student3 = new Student("Мария", "Комарова");
        Student student4 = new Student("Сергей", "Федоров");
        Student student5 = new Student("Маргарита", "Безрукова");
        Student student6 = new Student("Ксения", "Бочарова");
        Student student7 = new Student("Амира", "Смирнова");
        Student student8 = new Student("Тимур", "Стариков");
        Student student9 = new Student("Анастасия", "Кожевникова");

        if (consoleOut) {
            System.out.println("Экземпляры Student:");
            System.out.printf(
                    "1) %s\n2) %s\n3) %s\n4) %s\n5) %s\n6) %s\n7) %s\n8) %s\n9) %s\n10) %s\n\n",
                    student0,
                    student1,
                    student2,
                    student3,
                    student4,
                    student5,
                    student6,
                    student7,
                    student8,
                    student9
            );
        }

        // ### STUDENT_GROUP ###
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student4);
        students.add(student3);
        students.add(student0);
        students.add(student2);

        StudentsGroup studentsGroup = new StudentsGroup(students);
        if (consoleOut) {
            System.out.println("Экземпляр StudentsGroup:");
            System.out.printf("%s\n\n", studentsGroup);
        }

        studentsGroup.add(student6);
        studentsGroup.add(student5);
        if (consoleOut) {
            System.out.println("Экземпляр StudentsGroup после addToGroup(Student student):");
            System.out.printf("%s\n\n", studentsGroup);
        }

        List<Student> studentsList = new ArrayList<>() {{
            add(student7);
            add(student8);
            add(student9);
        }};
        studentsGroup.add(studentsList);
        if (consoleOut) {
            System.out.println("Экземпляр StudentsGroup после addToGroup(Student student):");
            System.out.printf("%s\n\n", studentsGroup);
        }

        return studentsGroup;
    }

    /**
     * Задача 3.2 - Iterable:
     * + Модифицировать класс УчебнаяГруппа, заставив его реализовать интерфейс Iterable:
     *     - Реализовать метод iterator() возвращающий экземпляр созданного нами итератора.
     * + Создать класс УчебнаяГруппаСервис, добавив в него метод удаления студента по ФИО;
     * + Создать класс Контроллер, добавив в него метод удаления студента и вызывать в нем созданный
     * метод из УчебнаяГруппаСервис;
     * @param group StudentsGroup для инициализации StudentsGroupService и StudentsGroupController
     * @param consoleOut Вывод результата в консоль
     * @return StudentsGroupService и StudentsGroupController
     */
    private static ServiceAndController BLOCK_3_2_TESTS(StudentsGroup group, boolean consoleOut) {

        // ### STUDENT_GROUP ITERABLE ###
        if (consoleOut) {
            printStudentsGroup(group);
        }

        // ### STUDENTS_GROUP SERVICE ###
        StudentsGroupService groupService = new StudentsGroupService(group);
        groupService.deleteByFullName("Вероника", "Тарасова");
        if (consoleOut) {
            printStudentsGroup(group);
        }

        // ### STUDENTS_GROUP CONTROLLER
        StudentsGroupController controller = new StudentsGroupController(groupService);
        controller.delete("Анастасия", "Кожевникова");
        if (consoleOut) {
            printStudentsGroup(group);
        }

        return new ServiceAndController(groupService, controller);
    }

    private record ServiceAndController(StudentsGroupService service, StudentsGroupController controller) {

    }

    private static void printStudentsGroup(StudentsGroup group) {
        int counter = 0;
        for (Student student :
                group) {
            System.out.printf("%d) %s\n", ++counter, student);
        }
        System.out.println();
    }

    /**
     * Задача 3.3 - Comparable:
     * + Модифицировать класс Студент, заставив его реализовать интерфейс Comparable
     * + Реализовать контракт compareTo () со сравнением по какому-либо параметру (пример studentId)
     * + Модифицировать класс УчебнаяГруппаСервис, добавив в него метод сортировки списка студентов по id
     * + Модифицировать класс Контроллер, добавив в него метод сортировки списка студентов по id и
     * вызывать в нем созданный метод из УчебнаяГруппаСервис
     * Задача 3.4 - Comparator
     * + Создать класс СтудентКомпаратор реализующий интерфейс Comparator;
     * + Реализовать контракт compare () со сравнением по какому-либо параметру
     * (пример: сочетание Имя+Фамилия);
     * + Модифицировать класс УчебнаяГруппаСервис, добавив в него метод сортировки списка студентов по ФИО;
     * + Модифицировать класс Контроллер, добавив в него метод сортировки списка студентов по ФИО и
     * вызывать в нем созданный метод из УчебнаяГруппаСервис.
     * @param ServiceAndController StudentsGroupService и StudentsGroupController
     * @param consoleOut Вывод результата в консоль
     */
    private static void BLOCK_3_4_TESTS(ServiceAndController ServiceAndController, boolean consoleOut) {
        StudentsGroupService service = ServiceAndController.service();
        StudentsGroupController controller = ServiceAndController.controller();

        controller.sort(new UsersComparatorFullName());

        if (consoleOut) {
            printStudentsGroup(service.getGroup());
        }

        controller.sort(new StudentsUuidComparator());

        if (consoleOut) {
            printStudentsGroup(service.getGroup());
        }
    }
}