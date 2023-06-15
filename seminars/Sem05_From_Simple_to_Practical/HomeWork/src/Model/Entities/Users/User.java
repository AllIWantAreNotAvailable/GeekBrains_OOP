package Model.Entities.Users;

import Model.Abstracts.Entity;
import Model.Entities.Comparators.UserComparator;
import Model.Interfaces.Users.UserInterface;

import java.time.LocalDate;
import java.util.Objects;

public class User extends Entity implements Comparable<User> { // TODO: 16.06.2023 Разобраться с имплементацией UserInterface<User>

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public User(LocalDate dateOfBirth, String firstName, String lastName) {
        setDateOfBirth(dateOfBirth);
        setFirstName(firstName);
        setLastName(lastName);
    }

    public User() {
        this(LocalDate.of(1777, 10, 22), "FirstName", "SecondName");
    }

    @Override
    public Long getUUID() {
        return super.getUUID();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = Objects.requireNonNull(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = Objects.requireNonNull(lastName);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = Objects.requireNonNull(dateOfBirth);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getUUID(), user.getUUID())
                && Objects.equals(getFirstName(), user.getFirstName())
                && Objects.equals(getLastName(), user.getLastName())
                && Objects.equals(getDateOfBirth(), user.getDateOfBirth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUUID(), getDateOfBirth(), getLastName(), getFirstName());
    }

    @Override
    public String toString() {
        return "User{" +
                "UUID=" + getUUID() +
                ", lastName='" + getLastName() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                '}';
    }

    @Override
    public int compareTo(User o) {
        return new UserComparator<>().compare(this, o);
    }
}
