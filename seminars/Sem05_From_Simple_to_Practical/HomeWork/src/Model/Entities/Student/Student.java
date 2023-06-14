package Model.Entities.Student;

import Model.Abstracts.Users.User;

import java.util.Objects;

public class Student extends User {

    public Student(String lastName, String firstName) {
        super(lastName, firstName);
    }

    public Student() {
        super();
    }

    @Override
    protected void setUUID(long UUID) {
        super.UUID = UUID;
    }

    @Override
    public Long getUUID() {
        return UUID;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        super.lastName = Objects.requireNonNull(lastName, "The field cannot be Null");
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        super.firstName = Objects.requireNonNull(firstName, "The field cannot be Null");
    }
    @Override
    public String toString() {
        return "Student{" +
                "UUID=" + getUUID() +
                ", lastName='" + getLastName() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                '}';
    }
}
