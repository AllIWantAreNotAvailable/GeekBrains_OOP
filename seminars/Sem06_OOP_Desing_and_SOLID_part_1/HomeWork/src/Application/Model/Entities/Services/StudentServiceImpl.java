package Application.Model.Entities.Services;

import Application.Model.Entities.Generators.SimpleIdGenerator;
import Application.Model.Entities.Users.Student;
import Application.Model.Interfaces.Services.StudentService;
import Application.Model.Interfaces.Supporting.Generator;

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

    public Student getCurrentStudent() {
        return currentStudent;
    }

    public void setCurrentStudent(Student currentStudent) {
        this.currentStudent = currentStudent;
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
    public boolean isAdmitted() {
        return getCurrentStudent().getStartDate() != null;
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
    public boolean isExpelled() {
        return isAdmitted()
                && getCurrentStudent().getEndDate() != null
                && getCurrentStudent().getEndDate().isBefore(LocalDate.now());
    }

    @Override
    public Student create(String UUID, String surname, String name, LocalDate dateOfBirth) {
        setCurrentStudent(new Student(UUID, surname, name, dateOfBirth));
        return getCurrentStudent();
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
    public void setName(String name) {
        getCurrentStudent().setName(name);
    }

    @Override
    public String getSurname() {
        return getCurrentStudent().getSurname();
    }

    @Override
    public void setSurname(String surname) {
        getCurrentStudent().setSurname(surname);
    }

    @Override
    public LocalDate getDateOfBirth() {
        return getCurrentStudent().getDateOfBirth();
    }

    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {
        getCurrentStudent().setDateOfBirth(dateOfBirth);
    }
}
