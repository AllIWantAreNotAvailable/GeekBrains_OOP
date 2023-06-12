package Entities.Student;

import Abstracts.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Objects;

public class Student extends User {

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
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
        // TODO: 13.06.2023 Нужен ли мне этот метод?
        return false;
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
    public String toString() {

        String string = super.toString();
        Pattern pattern = Pattern.compile("\\{.+?}");
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            string = string.substring(matcher.start() + 1, matcher.end() - 1);
        }
        return "Student{"+ string +"}";
    }
}
