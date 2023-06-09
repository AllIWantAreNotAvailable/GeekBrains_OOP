package service;

import model.Disciplines;
import model.Student;
import model.Teacher;
import model.User;

import java.util.List;

public interface UserService {

    void saveStudent(String name, String lastName, String dateOfBirth, int classNumber, char classLiteral);

    void saveTeacher(String name, String lastName, String dateOfBirth, Disciplines discipline);

    List<Teacher> getTeachers();

    List<Student> getStudents();

    List<User> getAllUsers();

    void deleteUser(long id);

}
