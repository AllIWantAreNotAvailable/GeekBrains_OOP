package model;

import java.util.Objects;

public class Student extends User {

    private int classNumber;
    private char classLiteral;

    public Student(String name, String lastName, String dateOfBirth, int classNumber, char classLiteral) {
        super(name, lastName, dateOfBirth);
        setClassNumber(classNumber);
        setClassLiteral(classLiteral);
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public char getClassLiteral() {
        return classLiteral;
    }

    public void setClassLiteral(char classLiteral) {
        this.classLiteral = classLiteral;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            if (this == object) return true;
            if (!(object instanceof Student student)) return false;
            return getClassNumber() == student.getClassNumber()
                    && getClassLiteral() == student.getClassLiteral();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getClassNumber(), getClassLiteral());
    }

    @Override
    public String toString() {
        return "\nStudent{" +
                "userId=" + getUserId() +
                ", name='" + getName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", dateOfBirth='" + getDateOfBirth() + '\'' +
                ", classNumber=" + getClassNumber() +
                ", classLiteral=" + getClassLiteral() +
                '}';
    }
}
