package Model.Interfaces.Controllers;

import Model.Entities.Groups.StudyGroup;
import Model.Entities.Users.Student;
import Model.Entities.Users.Teacher;

import java.util.List;

public interface StudyGroupControllerInterface {

    List<Student> getStudents();

    List<Long> getStudentsUUIDs();

    Teacher getMentor();

    Long getTeachersUUID();

    StudyGroup createStudyGroup(List<Student> students, Teacher teacher);

}
