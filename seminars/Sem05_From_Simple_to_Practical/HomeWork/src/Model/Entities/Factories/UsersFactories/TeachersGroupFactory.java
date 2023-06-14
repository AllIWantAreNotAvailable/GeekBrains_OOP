package Model.Entities.Factories.UsersFactories;

import Model.Abstracts.Users.UsersGroupFactory;
import Model.Entities.Teacher.TeachersGroup;

public class TeachersGroupFactory extends UsersGroupFactory<TeachersGroup> {

    @Override
    public TeachersGroup create() {
        return new TeachersGroup();
    }
}
