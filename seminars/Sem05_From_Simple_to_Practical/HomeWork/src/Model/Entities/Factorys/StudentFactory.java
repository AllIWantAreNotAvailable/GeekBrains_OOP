package Model.Entities.Factorys;

import Model.Entities.Student.Student;
import Model.Interfaces.Factory;

import java.util.ArrayList;
import java.util.List;

public class StudentFactory implements Factory<Student> {
    @Override
    public Student create() {
        return new Student("Ivan", "Ivanov");
    }

    @Override
    public List<Student> createList(int quantity) {
        List<Student> studentsList = new ArrayList<>();
        for (int i = 0; i < quantity; i++)
            studentsList.add(create());
        return studentsList;
    }
}
