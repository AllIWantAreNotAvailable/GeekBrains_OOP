package Model.Entities.Factories.UsersFactories;

import Model.Abstracts.Users.UsersFactory;
import Model.Entities.Teacher.Teacher;

public class TeacherFactory extends UsersFactory<Teacher> {

    @Override
    public Teacher create() {
        return new Teacher();
    }
}
