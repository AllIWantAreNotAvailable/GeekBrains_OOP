package Entities.Teacher;

import Abstracts.User;

import java.util.Objects;

public class Teacher extends User {

    int lengthOfService;

    public Teacher(String firstName, String lastName, int lengthOfService) {
        super(firstName, lastName);
        setLengthOfService(lengthOfService);
    }

    public int getLengthOfService() {
        return lengthOfService;
    }

    public void setLengthOfService(int lengthOfService) {
        this.lengthOfService = lengthOfService;
    }

    @Override
    protected void setUUID(long UUID) {
        super.UUID = UUID;
    }

    @Override
    protected void setFirstName(String firstName) {
        super.firstName = Objects.requireNonNull(firstName);
    }

    @Override
    protected void setLastName(String lastName) {
        super.lastName = Objects.requireNonNull(lastName);
    }

    @Override
    public Long getUUID() {
        return UUID;
    }

    @Override
    public boolean updateUUID(long UUID) {
        setUUID(UUID);
        return true;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public boolean updateFirstName(String firstName) {
        setFirstName(firstName);
        return true;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean updateLastName(String lastName) {
        setLastName(lastName);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            if (!(o instanceof Teacher teacher)) return false;
            return getLengthOfService() == teacher.getLengthOfService();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getLengthOfService());
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "UUID=" + getUUID() +
                ", lastName='" + getLastName() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lengthOfService=" + getLengthOfService() +
                '}';
    }
}
