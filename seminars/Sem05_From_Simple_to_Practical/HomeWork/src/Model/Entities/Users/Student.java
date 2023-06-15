package Model.Entities.Users;

import Model.Entities.Comparators.StudentComparator;
import Model.Entities.Comparators.UserComparator;
import Model.Entities.Groups.StudyGroup;

import java.time.LocalDate;
import java.util.Objects;

public class Student extends User {

    StudyGroup studyGroup;

    public Student(LocalDate dateOfBirth, String firstName, String lastName, StudyGroup studyGroup) {
        super(dateOfBirth, firstName, lastName);
        setStudyGroup(studyGroup);
    }

    public Student(LocalDate dateOfBirth, String firstName, String lastName) {
        super(dateOfBirth, firstName, lastName);
    }

    public Student() {
        super();
    }

    public StudyGroup getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(StudyGroup studyGroup) {
        this.studyGroup = studyGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            if (!(o instanceof Student student)) return false;
            return Objects.equals(getStudyGroup(), student.getStudyGroup());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getStudyGroup());
    }

    @Override
    public String toString() {
        return "Student{" +
                "UUID=" + getUUID() +
                ", groupID=" + getStudyGroup().getUUID() +
                ", lastName='" + getLastName() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                '}';
    }

    @Override
    public int compareTo(User o) {
        if (o instanceof Student student)
            return new StudentComparator<>().compare(this, student);
        else
            return new UserComparator<>().compare(this, o);
    }
}
