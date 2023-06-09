package controller;

import model.Disciplines;
import service.UserService;
import service.UserServiceImpl;


public class UserController {

    private UserService userService = new UserServiceImpl();

    public void saveStudent(String name, String lastName, String dateOfBirth, int classNumber, char classLiteral) {
        userService.saveStudent(name, lastName, dateOfBirth, classNumber, classLiteral);
    }

    public void saveTeacher(String name, String lastName, String dateOfBirth, Disciplines discipline) {
        userService.saveTeacher(name, lastName, dateOfBirth, discipline);
    }

    public void deleteUser(long id) {
        userService.deleteUser(id);
        System.out.println("User was deleted");
    }

    public void getTeachers() {
        System.out.println(userService.getTeachers());
    }

    public void getStudents() {
        System.out.println(userService.getStudents());;
    }

    public void getAllUsers() {
        System.out.println(userService.getAllUsers());
    }
}
