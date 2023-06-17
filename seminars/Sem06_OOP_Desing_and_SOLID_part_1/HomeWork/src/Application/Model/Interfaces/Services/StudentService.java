package Application.Model.Interfaces.Services;

import Application.Model.Entities.Users.Student;

import java.time.LocalDate;

public interface StudentService extends UserService<Student> {
    LocalDate getStartDate();

    void accept(LocalDate startDate);

    LocalDate getEndDate();

    void kick(LocalDate endDate);
}
