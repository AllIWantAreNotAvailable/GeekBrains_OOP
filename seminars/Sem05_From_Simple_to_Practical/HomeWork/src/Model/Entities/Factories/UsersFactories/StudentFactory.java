package Model.Entities.Factories.UsersFactories;

import Model.Abstracts.Users.UsersFactory;
import Model.Entities.Student.Student;

public class StudentFactory extends UsersFactory<Student> {
    @Override
    public Student create() {
        return new Student();
    }
}
