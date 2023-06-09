package model;

import java.util.Objects;

public abstract class User {
    static long id;

    private long userId;
    private String name;
    private String lastName;
    private String dateOfBirth;

    public User(String name, String lastName, String dateOfBirth) {
        setId(++User.id);
        setName(name);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
    }

    public void setId(long id){
        this.userId = id;
    }

    public long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof User user)) return false;
        return getUserId() == user.getUserId()
                && getDateOfBirth() == user.getDateOfBirth()
                && Objects.equals(getName(), user.getName())
                && Objects.equals(getLastName(), user.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getName(), getLastName(), getDateOfBirth());
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + getUserId() +
                ", name='" + getName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                '}';
    }
}
