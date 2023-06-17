package Application.Model.Entities.Services;

import Application.Model.Interfaces.Supporting.Generator;
import Application.Model.Entities.Generators.SimpleIdGenerator;
import Application.Model.Interfaces.Services.StudentService;
import Application.Model.Entities.Users.Student;

import java.time.LocalDate;

public class StudentServiceImpl implements StudentService {
    Generator<String> uuidGenerator;
    Student currentStudent;

    public StudentServiceImpl() {
        this.uuidGenerator = new SimpleIdGenerator();
    }

    public StudentServiceImpl(Student currentStudent) {
        setCurrentStudent(currentStudent);
    }

    public void setCurrentStudent(Student currentStudent) {
        this.currentStudent = currentStudent;
    }

    public Student getCurrentStudent() {
        return currentStudent;
    }

    @Override
    public LocalDate getStartDate() {
        return getCurrentStudent().getStartDate();
    }

    @Override
    public void accept(LocalDate startDate) {
        getCurrentStudent().setStartDate(startDate);
    }

    @Override
    public LocalDate getEndDate() {
        return getCurrentStudent().getEndDate();
    }

    @Override
    public void kick(LocalDate endDate) {
        getCurrentStudent().setEndDate(endDate);
    }

    @Override
    public Student create(String UUID, String surname, String name, LocalDate dateOfBirth) {
        setCurrentStudent(new Student(UUID, surname, name, dateOfBirth));
        return getCurrentStudent();
    }

    @Override
    public void setName(String name) {
        getCurrentStudent().setName(name);
    }

    @Override
    public void setSurname(String surname) {
        getCurrentStudent().setSurname(surname);
    }

    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {
        getCurrentStudent().setDateOfBirth(dateOfBirth);
    }

    @Override
    public String getUUID() {
        return getCurrentStudent().getUUID();
    }

    @Override
    public String getName() {
        return getCurrentStudent().getName();
    }

    @Override
    public String getSurname() {
        return getCurrentStudent().getSurname();
    }

    @Override
    public LocalDate getDateOfBirth() {
        return getCurrentStudent().getDateOfBirth();
    }
}
