package Model.Entities.Factorys;

import Model.Entities.Teacher.Teacher;
import Model.Interfaces.Factory;

import java.util.ArrayList;
import java.util.List;

public class TeacherFactory implements Factory<Teacher> {
    @Override
    public Teacher create() {
        return new Teacher("Marya", "Ivanova");
    }

    @Override
    public List<Teacher> createList(int quantity) {
        List<Teacher> teachersList = new ArrayList<>();
        for (int i = 0; i < quantity; i++)
            teachersList.add(create());
        return teachersList;
    }
}
