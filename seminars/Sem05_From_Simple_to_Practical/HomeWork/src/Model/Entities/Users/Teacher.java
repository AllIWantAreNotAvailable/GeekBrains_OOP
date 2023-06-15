package Model.Entities.Users;

import java.time.LocalDate;
import java.util.Objects;

public class Teacher extends User {
    enum AcademicTitle {
        Docent,
        Professor
    }

    private AcademicTitle academicTitle;

    public Teacher(LocalDate dateOfBirth, String firstName, String lastName, AcademicTitle academicTitle) {
        super(dateOfBirth, firstName, lastName);
        setAcademicTitle(academicTitle);
    }

    public Teacher() {
        super();
        setAcademicTitle(AcademicTitle.Docent);
    }

    public AcademicTitle getAcademicTitle() {
        return academicTitle;
    }

    public void setAcademicTitle(AcademicTitle academicTitle) {
        this.academicTitle = Objects.requireNonNull(academicTitle);
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            if (!(o instanceof Teacher teacher)) return false;
            return getAcademicTitle() == teacher.getAcademicTitle();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAcademicTitle());
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "UUID=" + getUUID() +
                ", academicTitle=" + academicTitle +
                ", lastName='" + getLastName() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                '}';
    }


}
