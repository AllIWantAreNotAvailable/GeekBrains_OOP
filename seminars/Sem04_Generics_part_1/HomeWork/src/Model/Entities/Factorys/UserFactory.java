package Model.Entities.Factorys;

import Model.Abstracts.User;
import Model.Entities.Student.Student;
import Model.Entities.Teacher.Teacher;
import Model.Interfaces.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserFactory<T extends User> implements Factory<T> {

    private static final List<String> firstNames;
    private static final List<String> lastNames;

    static {

        firstNames = new ArrayList<>() {{
            add("Абрамов");
            add("Львова");
            add("Коровина");
            add("Краснов");
            add("Смирнова");
            add("Бычков");
            add("Козлова");
            add("Крючков");
            add("Трофимов");
            add("Жукова");
            add("Иванова");
            add("Зубкова");
            add("Пономарев");
            add("Коновалова");
            add("Романов");
            add("Касьянов");
            add("Головина");
            add("Никольский");
            add("Алексеева");
            add("Леонова");
            add("Селиванов");
            add("Власова");
            add("Тарасов");
            add("Петров");
            add("Ларина");
            add("Карпова");
            add("Гусев");
            add("Корнеева");
            add("Ермаков");
            add("Игнатов");
            add("Суворова");
            add("Князев");
            add("Иванов");
            add("Леонтьев");
            add("Прохоров");
            add("Андреева");
            add("Худякова");
            add("Сидоров");
            add("Буров");
            add("Попова");
            add("Орлова");
            add("Ушакова");
            add("Михайлова");
            add("Бирюков");
            add("Григорьева");
            add("Зайцева");
            add("Королев");
            add("Морозова");
            add("Завьялов");
            add("Гаврилов");
            add("Наумов");
            add("Ефимова");
            add("Галкин");
            add("Розанов");
            add("Зорина");
            add("Герасимова");
            add("Маслов");
            add("Воронова");
            add("Ильин");
            add("Балашова");
            add("Евсеева");
            add("Муравьева");
            add("Бабушкина");
            add("Журавлева");
            add("Исаева");
            add("Мартынова");
            add("Мальцев");
            add("Алешин");
            add("Семенов");
            add("Титов");
            add("Крюкова");
            add("Демьянова");
            add("Волков");
            add("Орлов");
            add("Назарова");
            add("Шишкина");
            add("Гончаров");
            add("Шевцов");
            add("Ковалев");
            add("Басова");
            add("Селезнев");
            add("Осипов");
            add("Баранова");
            add("Русаков");
            add("Фокина");
            add("Соболева");
            add("Столярова");
            add("Алехина");
            add("Давыдова");
            add("Ильина");
            add("Васильева");
        }};

        lastNames = new ArrayList<>() {{
            add("Даниэль");
            add("Виктория");
            add("Полина");
            add("Никита");
            add("Майя");
            add("Артём");
            add("Мария");
            add("Дмитрий");
            add("Семён");
            add("Ульяна");
            add("Ангелина");
            add("Анна");
            add("Игорь");
            add("Элина");
            add("Степан");
            add("Ярослав");
            add("Варвара");
            add("Дарья");
            add("Марк");
            add("Михаил");
            add("Анастасия");
            add("Ксения");
            add("Андрей");
            add("Елизавета");
            add("Лев");
            add("Тимофей");
            add("Алина");
            add("Билал");
            add("Всеволод");
            add("Иван");
            add("Милана");
            add("Арсений");
            add("Василиса");
            add("Ева");
            add("Савелий");
            add("Матвей");
            add("Илья");
            add("Кирилл");
            add("Владимир");
            add("Алия");
            add("Нина");
            add("Алиса");
            add("Александра");
            add("Диана");
            add("Эвелина");
            add("Сафия");
            add("Юрий");
            add("Глеб");
            add("Валерия");
            add("Арина");
            add("София");
            add("Егор");
            add("Екатерина");
            add("Александр");
            add("Станислав");
            add("Мирослава");
            add("Марьям");
            add("Софья");
            add("Ариана");
        }};

    }

    private String rnd(Type type) {
        Random random = new Random();
        return switch (type) {
            case FIRST_NAME -> firstNames.get(random.nextInt(0, firstNames.size()));
            case LAST_NAME -> lastNames.get(random.nextInt(0, lastNames.size()));
        };
    }

    @Override
    public T create(Class<T> tClass) {
         if (tClass.equals(Student.class))
            return (T) new Student(rnd(Type.FIRST_NAME), rnd(Type.LAST_NAME));
         else if (tClass.equals(Teacher.class))
            return (T) new Teacher(rnd(Type.FIRST_NAME), rnd(Type.LAST_NAME));
         throw new  RuntimeException("Nu such constructor");
    }

    @Override
    public List<T> createList(Class<T> tClass, int quantity) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            list.add(create(tClass));
        }
        return list;
    }

    enum Type {
        FIRST_NAME,
        LAST_NAME
    }
}
