package Application.Model.Interfaces;

import Application.Model.Entities.Users.Student;
import Application.Model.Entities.Users.Teacher;
import Application.Model.Entities.UsersGroups.StudentGroup;
import Application.Model.Interfaces.UsersGroups.UsersGroup;

import java.util.List;

public interface StudyGroup extends UsersGroup<Student> {

    String getSGUID();

    StudentGroup getStudentGroup();

    void setStudentGroup(StudentGroup studentGroup);

    Teacher getMentor();

    void setMentor(Teacher mentor);

    List<Student> getStudents();

    Student getStudentLeader();
}
