package Application.Model.Entities.Users;

import Application.Model.Abstract.Users.UserImpl;

import java.time.LocalDate;
import java.util.Objects;

public class Teacher extends UserImpl {

    private String academicDegree;

    public Teacher(String UUID, String surname, String name, LocalDate dateOfBirth, String academicDegree) {
        super(UUID, surname, name, dateOfBirth);
        setAcademicDegree(academicDegree);
    }

    public Teacher(String UUID, String surname, String name, LocalDate dateOfBirth) {
        super(UUID, surname, name, dateOfBirth);
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            if (!(o instanceof Teacher teacher)) return false;
            return Objects.equals(getAcademicDegree(), teacher.getAcademicDegree());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAcademicDegree());
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "UUID='" + getUUID() + '\'' +
                ", academicDegree='" + getAcademicDegree() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", name='" + getName() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                '}';
    }
}
