package Application.Model.Abstract.Users;

import Application.Model.Abstract.Base.Entity;
import Application.Model.Interfaces.Users.User;
import Application.Model.Entities.Comparators.Basic.UserComparator;

import java.time.LocalDate;
import java.util.Objects;

public abstract class UserImpl extends Entity implements User, Comparable<UserImpl> {

    protected String UUID;
    protected String name;
    protected String surname;
    protected LocalDate dateOfBirth;

    public UserImpl(String UUID, String surname, String name, LocalDate dateOfBirth) {
        this.UUID = UUID;
        setSurname(surname);
        setName(name);
        setDateOfBirth(dateOfBirth);
    }

    @Override
    public String getUUID() {
        return UUID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = Objects.requireNonNull(name);
    }

    @Override
    public String getSurname() {
        return surname;
    }
    @Override
    public void setSurname(String surname) {
        this.surname = Objects.requireNonNull(surname);
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = Objects.requireNonNull(dateOfBirth);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserImpl user)) return false;
        return Objects.equals(getUUID(), user.getUUID())
                && Objects.equals(getName(), user.getName())
                && Objects.equals(getSurname(), user.getSurname())
                && Objects.equals(getDateOfBirth(), user.getDateOfBirth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUUID(), getName(), getSurname(), getDateOfBirth());
    }

    @Override
    public int compareTo(UserImpl user) {
        return new UserComparator<>().compare(this, user);
    }
}
