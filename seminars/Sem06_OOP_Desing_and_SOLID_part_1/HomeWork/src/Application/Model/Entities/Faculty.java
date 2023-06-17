package Application.Model.Entities;

import Application.Model.Abstract.Units.StructuralUnit;
import Application.Model.Entities.UsersGroups.TeachersGroup;
import Application.Model.Entities.Users.Teacher;

import java.util.Map;

public class Faculty extends StructuralUnit<StudyGroupImpl, TeachersGroup, Teacher> {

    public Faculty(Map<String, StudyGroupImpl> unit, TeachersGroup leader) {
        super(unit, leader);
    }

}
