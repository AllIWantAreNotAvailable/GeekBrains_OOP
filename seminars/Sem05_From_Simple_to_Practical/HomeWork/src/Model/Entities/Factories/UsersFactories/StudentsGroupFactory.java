package Model.Entities.Factories.UsersFactories;

import Model.Abstracts.Users.UsersGroupFactory;
import Model.Entities.Student.StudentsGroup;

public class StudentsGroupFactory extends UsersGroupFactory<StudentsGroup> {

    @Override
    public StudentsGroup create() {
        return new StudentsGroup();
    }
}
