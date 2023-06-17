package Application.Model.Entities.Users;

import Application.Model.Abstract.Users.UserImpl;

import java.time.LocalDate;
import java.util.Objects;

public class Student extends UserImpl {

    LocalDate startDate;
    LocalDate endDate;

    public Student(String UUID, String surname, String name, LocalDate dateOfBirth, LocalDate startDate) {
        super(UUID, surname, name, dateOfBirth);
        setStartDate(startDate);
    }

    public Student(String UUID, String surname, String name, LocalDate dateOfBirth) {
        super(UUID, surname, name,dateOfBirth);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = Objects.requireNonNull(startDate);
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = Objects.requireNonNull(endDate);
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            if (!(o instanceof Student student)) return false;
            return Objects.equals(getStartDate(), student.getStartDate())
                    && Objects.equals(getEndDate(), student.getEndDate());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getStartDate(), getEndDate());
    }

    @Override
    public String toString() {
        return "Student{" +
                "UUID=" + getUUID() +
                ", surname='" + getSurname() + '\'' +
                ", name='" + getName() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }


}
