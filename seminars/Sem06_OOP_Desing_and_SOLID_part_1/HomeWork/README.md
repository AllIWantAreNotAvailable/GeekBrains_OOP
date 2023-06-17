# Самостоятельная работа

> Взять реализованный код в рамках [семинара 4](https://github.com/AllIWantIsNotAvailable/GeekBrains_OOP/tree/main/seminars/Sem04_Generics_part_1/OnlineTasks/src/data) и продемонстрировать применение принципов, усвоенных на семинаре. 
> Нужно в проекте прокомментировать участки кода, которые рефакторим, какой принцип применяем и почему.

## Резюме по проделанной работе

> Здесь хочется оставить для себя основные мысли и опыт по выполнению поставленной задачи на самостоятельную работу.
>


### Единая отправная точка (главная абстракция)

Какие преимущества дала единая сущность Entity? Самым главным преимуществом единой сущности считаю явное отделение ветки
с собственными классами наследниками от ведущей ветки Object'ов. Что в свою очередь позволяет явно ограничить типы для
классов с дженериками. Мы буквально ограничиваем типизацию только своими сущностями и конкретными их семействами – очень
хорошая практика.


### Абстракции и снова абстракции

Уже сейчас, когда пишу это резюме, я начинаю понимать, что на самом деле вся моя программа могла быть написана за счет
3-х абстракций – Entity, EntitiesGroup и StructureUnit (последние две выглядят как условные Java Collections). Их нужно 
было просто расширить необходимым набором интерфейсов для нужно функциональности и этого было бы достаточно. На текущем 
этапе, естественно, переделывать уже не буду, оставлю как работу над ошибками ^_^


### Принципы SOLID

1. Single Responsibility Principle:
	> С данным принципом все предельно ясно, одна сущность – одна задача.
	> В ходе рефакторинга мы разделили наши сущности по отдельным зонам ответственности, если нам необходимо добавить 
	> дополнительный функционал, мы создаем отдельный класс (обособленный или класс-наследник) и реализуем его там.
	>

2. Open Closed Principle:
	> В ходе рефакторинга мы создали базовые сущности с установленным функционалом. Далее, для расширения функционала мы 
	> создавали классы обертки или наследников, благодаря чему был реализован 2-й принцип SOLID.
	>

3. Liskov’s Substitution Principle
	> Все наследники базовых классов сохраняют и реализуют базовую функциональность, что обеспечивает соблюдение 3-го 
	> принципа SOLID
	>

4. Interface Segregation Principle
	> Везде где требовался специализированный интерфейс для программной сущности – он добавлялся, либо как новый, либо
	> наследовался от имеющегося, в зависимости от условий и контекста – 4-й принцип SOLID.
	>

5. Dependency Inversion Principle
	> Модули верхнего уровня не зависят от нижнего уровня, все они являются наследниками абстрактных классов и зависят 
	> от них.
	> 

## Комментарии по выполнению самостоятельной работы

> Принципы [SOLID](https://github.com/AllIWantIsNotAvailable/GeekBrains_OOP/blob/main/seminars/Sem06_OOP_Desing_and_SOLID/OnlineTasks/SOLID.md)
> 
> В качестве объекта рефакторинга взят [срез проекта](https://github.com/AllIWantIsNotAvailable/GeekBrains_OOP/tree/main/seminars/Sem04_Generics_part_1/HomeWork) после выполнения самостоятельной работы.

### Исходный состав проекта

- Абстракции:
	1. [User.java](https://github.com/AllIWantIsNotAvailable/GeekBrains_OOP/blob/main/seminars/Sem04_Generics_part_1/HomeWork/src/Abstracts/User.java)
	2. [UserGroup.java](https://github.com/AllIWantIsNotAvailable/GeekBrains_OOP/blob/main/seminars/Sem04_Generics_part_1/HomeWork/src/Abstracts/UsersGroup.java)
	3. [UserGroupIterator.java](https://github.com/AllIWantIsNotAvailable/GeekBrains_OOP/blob/main/seminars/Sem04_Generics_part_1/HomeWork/src/Abstracts/UsersGroupIterator.java)
	4. [UserGroupStream.java](https://github.com/AllIWantIsNotAvailable/GeekBrains_OOP/blob/main/seminars/Sem04_Generics_part_1/HomeWork/src/Abstracts/UserGroupsStream.java)
	5. [UserGroupStreamIterator.java](https://github.com/AllIWantIsNotAvailable/GeekBrains_OOP/blob/main/seminars/Sem04_Generics_part_1/HomeWork/src/Abstracts/UserGroupsStreamIterator.java)

- Интерфейсы:
	1. [UserInterface.java](https://github.com/AllIWantIsNotAvailable/GeekBrains_OOP/blob/main/seminars/Sem04_Generics_part_1/HomeWork/src/Interfaces/UserInterface.java)
	2. [UsersGroupInterface.java](https://github.com/AllIWantIsNotAvailable/GeekBrains_OOP/blob/main/seminars/Sem04_Generics_part_1/HomeWork/src/Interfaces/UsersGroupInterface.java)
	3. [UserGroupsStreamInterface.java](https://github.com/AllIWantIsNotAvailable/GeekBrains_OOP/blob/main/seminars/Sem04_Generics_part_1/HomeWork/src/Interfaces/UserGroupsStreamInterface.java)

- Сущности:
	1. [Student.java](https://github.com/AllIWantIsNotAvailable/GeekBrains_OOP/blob/main/seminars/Sem04_Generics_part_1/HomeWork/src/Entities/Student/Student.java)
	2. [StudentsGroup.java](https://github.com/AllIWantIsNotAvailable/GeekBrains_OOP/blob/main/seminars/Sem04_Generics_part_1/HomeWork/src/Entities/Student/StudentsGroup.java)
	3. [StudentsGroupIterator.java](https://github.com/AllIWantIsNotAvailable/GeekBrains_OOP/blob/main/seminars/Sem04_Generics_part_1/HomeWork/src/Entities/Student/StudentsGroupIterator.java)
	4. [StudentsGroupService.java](https://github.com/AllIWantIsNotAvailable/GeekBrains_OOP/blob/main/seminars/Sem04_Generics_part_1/HomeWork/src/Entities/Student/StudentsGroupService.java)
	5. [StudentGroupsStream.java](https://github.com/AllIWantIsNotAvailable/GeekBrains_OOP/blob/main/seminars/Sem04_Generics_part_1/HomeWork/src/Entities/Student/StudentGroupsStream.java)
	6. [StudentGroupsStreamIterator.java](https://github.com/AllIWantIsNotAvailable/GeekBrains_OOP/blob/main/seminars/Sem04_Generics_part_1/HomeWork/src/Entities/Student/StudentGroupsStreamIterator.java)
	7. [Teacher.java](https://github.com/AllIWantIsNotAvailable/GeekBrains_OOP/blob/main/seminars/Sem04_Generics_part_1/HomeWork/src/Entities/Teacher/Teacher.java)
	8. [TeachersGroup.java](https://github.com/AllIWantIsNotAvailable/GeekBrains_OOP/blob/main/seminars/Sem04_Generics_part_1/HomeWork/src/Entities/Teacher/TeachersGroup.java)
	9. [TeachersGroupIterator.java](https://github.com/AllIWantIsNotAvailable/GeekBrains_OOP/blob/main/seminars/Sem04_Generics_part_1/HomeWork/src/Entities/Teacher/TeachersGroupIterator.java)


### Текущие проблемы

#### Зеркальная структура

Проект имеет 2 основные ветки сущностей:
- Студенты и ГруппыСтудентов
- Преподаватели и ГруппыПреподавателей

При этом, обе ветки и соответсвующее классы дублируют друг друга составом атрибутов и методов.
Это проблема вызовет трудность расширения и поддержки.


#### Отсутствие взаимосвязей

Отсутствует взаимосвязь преподаватель-студент, что намекает на несвязность общей структуры


### Описание 

Проект должен повторить известную структуру Университета:

	.University\
	|
	|	.Institute\
	|	|
	|	|	.Faculty\
	|	|	|
	|	|	|	.StudyGroup\
	|	|	|	|
	|	|	|	|	.List<Student> studentsGroup;
	|	|	|	|	.Teacher mentor;
	|	|	|
	|	|	|	.List<Teacher> teachers
	|	|	|	.Teacher facultyHead
	|	|	
	|	|	.List<Teacher> institutePersonal
	|	|	.Teacher InstituteDirector
	|
	|	.List<Student> studentsFlow
	|	.List<Teacher> universityPersonal
	|	.Teacher universityDirector
	|


### Реализация принципов SOLID:

#### Этап 1:

##### Постановка задачи:

Для начала переработаем структуру абстракций в Нашем проекте. Выделим "2" (родитель + наследник) основные сущности для
реализации всей иерархии зависимостей:
1. Базовая сущность – Entity
2. Группа сущностей – EntityGroup (extends Entity)

Благодаря тому, что в основу проекта лягут 2 базовые сущности, мы реализуем сразу 3 принципа:
1. Single Responsibility Principle – потенциально, сможем разграничить зоны ответственности.
2. Open Closed Principle – мы получим отличную возможность расширять классы новым функционалом без вреда для родителей.
3. Dependency Inversion Principle – наши базовые классы не будут зависеть от классов наследником.


##### Реализация:

Создаем пустые абстракции Entity и EntityGroup. Далее в проекте будем использовать их как родительские классы для всех
наших сущностей.

```Java
/**
* Класс будет родителем для каждой единичной сущности
*/
public abstract class Entity {  
  
	public Entity() {  
	}  
}
```

```Java
/**
* Класс будет родителем для каждой группы сущностей
*/
public abstract class EntitiesGroup extends Entity {

	public EntitiesGroup() {
	}
}
```

#### Этап 2:

##### Постановка задачи:

Необходимо создать базовые абстрактные классы для пользователей и групп пользователей. От класса пользователь далее 
будут наследоваться сущности по типу: "Студент", "Учитель" и др.; Группа пользователей представляет собой коллекцию 
сущностей.

Благодаря такому подходу мы реализуем:
- Open Closed Principle – мы сможем свободно расширять функциональность наших базовых элементов;
- Liskov’s Substitution Principle – абстракции разбиты таким образом, что каждая из групп наследников родительской 
абстракции будет иметь одно направление функциональности, что обеспечит соблюдение принципа подстановки;
- Dependency Inversion Principle – модули верхних уровней не будут зависеть от модулей верхних уровней, и оба уровня
завязаны на корневых абстракциях.


##### Реализация:

```Java
/**
 * Представляет собой абстракцию пользователя "Университета"
 */
public abstract class UserImpl extends Entity implements User, Comparable<UserImpl> {

    protected String UUID;
    protected String name;
    protected String surname;
    protected LocalDate dateOfBirth;

    public UserImpl(String UUID, String surname, String name, LocalDate dateOfBirth) {
        this.UUID = UUID;
        setSurname(surname);
        setName(name);
        setDateOfBirth(dateOfBirth);
    }

    @Override
    public String getUUID() {
        return UUID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = Objects.requireNonNull(name);
    }

    @Override
    public String getSurname() {
        return surname;
    }
    @Override
    public void setSurname(String surname) {
        this.surname = Objects.requireNonNull(surname);
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = Objects.requireNonNull(dateOfBirth);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserImpl user)) return false;
        return Objects.equals(getUUID(), user.getUUID())
                && Objects.equals(getName(), user.getName())
                && Objects.equals(getSurname(), user.getSurname())
                && Objects.equals(getDateOfBirth(), user.getDateOfBirth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUUID(), getName(), getSurname(), getDateOfBirth());
    }

    @Override
    public int compareTo(UserImpl user) {
        return new UserComparator<>().compare(this, user);
    }
}
```

```Java
/**
 * Представляет собой группу пользователей "Университета"
 */
public abstract class UsersGroupImpl<T extends UserImpl> extends EntitiesGroup implements UsersGroup<T> {

    private Map<String, T> group;

    public UsersGroupImpl(Map<String, T> group) {
        setStructure(group);
    }

    public UsersGroupImpl(List<T> group) {
        this();
        add(group);
    }

    public UsersGroupImpl() {
        this(new HashMap<>());
    }

    public Map<String, T> getStructure() {
        return group;
    }

    public void setStructure(Map<String, T> group) {
        this.group = group;
    }

    @Override
    public void add(List<T> group) {
        for (T user :
                Objects.requireNonNull(group)) {
            add(user);
        }
    }

    @Override
    public void add(T user) {
        Objects.requireNonNull(user);
        getStructure().put(user.getUUID(), user);
    }
}
```


#### Этап 3:

##### Постановка задачи:

Разбить структуру сущностей по группам ответственности: Студент, Учитель.

Благодаря этой задаче реализуем:
- Single Responsibility Principle – пользователь это абстракция, в нашем университете мы работаем с конкретными его
семействами: преподаватели и студенты; в рамках каждого семейства своя зона ответственности и поведение экземпляра.

##### Реализация:

Классы Студент и Учитель наследуем от UserImpl, что дает нам единую точку структуры – Entity. Это в свою очередь
соблюдение: Dependency Inversion Principle и Liskov’s Substitution Principle, как следствие Open Closed Principle.


#### Этап 4:

##### Постановка задачи:

Реализовать группы классов: Студент и Учитель. Наследуем от UsersGroupImpl.

##### Реализация:

Структура классов общая, абстракция в обоих случаях расширена только одним полем с установленной зависимостью: поле 
"лидер группы" может быть заполнено только user'ом, который состоит в этой группе.

Получаем предварительно "зеркальную структуру", но:
- зона ответственности студента отдельно от зоны ответственности преподавателя;
- структуры в дальнейшем расширяются по своим зонам ответственности.


#### Этап 5:

##### Постановка задачи:

Создать сущность связи группы студентов с преподавателем ("куратором группы").

##### Реализация:

Описали сущность и интерфейс StudyGroup. StudyGroup для нас является сущностью, так как не содержит в себе коллекций
Java и представляет собой конкретную структурную единицу.


#### Этап 6:

##### Постановка задачи:

Реализовать "факультет университета", который объединит в себе n-StudyGroup и TeachersGroup.

##### Реализация:

Описана сущность представления "факультета университета" – Faculty. На данном этапе уже есть понимание того, что
дальнейшее расширение проекта будет по схожей с Faculty структурой, что буквально говорит нам – "Вот она новая 
абстракция!", реализован новый абстрактный класс StructuralUnit.


```Java
/**
 * Представляет собой структурную единицу "Университета": Университет, Институт, Факультет...
 */
public abstract class StructuralUnit<T extends Entity, E extends UsersGroupImpl<U>, U extends UserImpl> extends EntitiesGroup {

    Map<String, T> unit;
    E department;

    public StructuralUnit(Map<String, T> unit, E department) {
        setUnit(unit);
        setDepartment(department);
    }

    public Map<String, T> getUnit() {
        return unit;
    }

    public void setUnit(Map<String, T> unit) {
        this.unit = unit;
    }

    public E getDepartment() {
        return department;
    }

    public void setDepartment(E department) {
        this.department = department;
    }
}
```