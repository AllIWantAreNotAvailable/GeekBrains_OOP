package Model.Entities.Teacher;

import Model.Abstracts.Users.User;

import java.util.Objects;

public class Teacher extends User {

    public Teacher(String lastName, String firstName) {
        super(lastName, firstName);
    }

    public Teacher() {
        super();
    }

    @Override
    protected void setUUID(long UUID) {
        super.UUID = UUID;
    }

    @Override
    public Long getUUID() {
        return super.UUID;
    }

    @Override
    public String getLastName() {
        return super.lastName;
    }

    @Override
    public void setLastName(String lastName) {
        super.lastName = Objects.requireNonNull(lastName, "The field cannot be Null");
    }

    @Override
    public String getFirstName() {
        return super.firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        super.firstName = Objects.requireNonNull(firstName, "The field cannot be Null");
    }
    @Override
    public String toString() {
        return "Teacher{" +
                "UUID=" + getUUID() +
                ", lastName='" + getLastName() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                '}';
    }
}
