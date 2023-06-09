package service;

import model.Disciplines;
import model.Student;
import model.Teacher;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    List<User> users;
    List<Teacher> teachers;
    List<Student> students;

    public UserServiceImpl() {
        setUsers(new ArrayList<>());
        setStudents(new ArrayList<>());
        setTeachers(new ArrayList<>());
    }

    private void setUsers(List<User> users) {
        this.users = users;
    }

    private void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    private void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public void saveStudent(String name, String lastName, String dateOfBirth, int classNumber, char classLiteral) {
        Student student = new Student(name, lastName, dateOfBirth, classNumber, classLiteral);
        this.students.add(student);
        this.users.add(student);
    }

    @Override
    public void saveTeacher(String name, String lastName, String dateOfBirth, Disciplines discipline) {
        Teacher teacher = new Teacher(name, lastName, dateOfBirth, discipline);
        this.teachers.add(teacher);
        this.users.add(teacher);
    }

    @Override
    public void deleteUser(long id) {
        User userToDelete = null;
        for (User student :
                getStudents()) {
            if (student.getUserId() == id) {
                userToDelete = student;
                getStudents().remove(student);
                break;
            }
        }
        if (userToDelete == null) {
            for (User teacher :
                    getTeachers()) {
                if (teacher.getUserId() == id) {
                    userToDelete = teacher;
                    getTeachers().remove(teacher);
                    break;
                }
            }
        }
        if (userToDelete != null) {
            getAllUsers().remove(userToDelete);
//            System.out.printf("User was deleted: %s\n", userToDelete);
//            return;
        }
//        System.out.println("Id does not belong to any user!");
    }

    @Override
    public List<Teacher> getTeachers() {
        return teachers;
    }

    @Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
