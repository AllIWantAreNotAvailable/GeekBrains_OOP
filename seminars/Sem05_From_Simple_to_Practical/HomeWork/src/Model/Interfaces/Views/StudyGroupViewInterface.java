package Model.Interfaces.Views;

import Model.Entities.Groups.StudyGroup;
import Model.Entities.Users.Student;
import Model.Entities.Users.Teacher;

import java.util.List;

public interface StudyGroupViewInterface {

    void getStudents();

    void getStudentsUUIDs();

    void getMentor();

    void getTeachersUUID();

    void createStudyGroup(List<Student> students, Teacher teacher);

}
