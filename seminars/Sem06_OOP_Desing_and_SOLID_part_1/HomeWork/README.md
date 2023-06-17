# Самостоятельная работа

> Взять реализованный код в рамках [семинара 4](https://github.com/AllIWantIsNotAvailable/GeekBrains_OOP/tree/main/seminars/Sem04_Generics_part_1/OnlineTasks/src/data) и продемонстрировать применение принципов, усвоенных на семинаре. 
> Нужно в проекте прокомментировать участки кода, которые рефакторим, какой принцип применяем и почему.


## Комментарии по выполнению самостоятельной работы

> Принципы [SOLID](https://github.com/AllIWantIsNotAvailable/GeekBrains_OOP/blob/main/seminars/Sem06_OOP_Desing_and_SOLID/OnlineTasks/SOLID.md)
> В качестве объекта рефакторинга взят [срез проекта](https://github.com/AllIWantIsNotAvailable/GeekBrains_OOP/tree/main/seminars/Sem04_Generics_part_1/HomeWork) после выполнения самостоятельной работы.

### Состав проекта

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

Для начала переработаем структуру абстракций в Нашем проекте. Выделим 2 основные сущности для реализации всей иерархии зависимостей:
1. Базовая сущность – Entity
2. Группа сущностей – EntityGroup

Благодаря тому, что в основу проекта лягут 2 базовые сущности, мы реализуем сразу 3 принципа:
1. Single Responsibility Principle – потенциально, сможем разграничить зоны ответственности.
2. Open Closed Principle – мы получим отличную возможность расширять классы новым функционалом без вреда для родителей.
3. Dependency Inversion Principle – наши базовые классы не будут зависеть от классов наследником.


##### Реализация:

Создаем пустые абстракции Entity и EntityGroup. Далее в проекте будем использовать их как родительские классы для все наших сущностей.

```Java
/**
Класс будет родителем для каждой единичной сущности
*/
public abstract class Entity {  
  
	public Entity() {  
	}  
}
```

```Java
/**
Класс будет родителем для каждой группы сущностей
*/
public abstract class EntitiesGroup {  
  
	public EntitiesGroup() {  
	}  
}
```