package model;

import java.util.Objects;

public class Teacher extends User {
    private Disciplines discipline;

    public Teacher(String name, String lastName, String dateOfBirth, Disciplines discipline) {
        super(name, lastName, dateOfBirth);
        setDiscipline(discipline);
    }

    public Disciplines getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Disciplines discipline) {
        this.discipline = discipline;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object)) {
            if (this == object) return true;
            if (!(object instanceof Teacher teacher)) return false;
            return getDiscipline() == teacher.getDiscipline();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDiscipline());
    }

    @Override
    public String toString() {
        return "\nTeacher{" +
                "userId=" + getUserId() +
                ", name='" + getName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", dateOfBirth='" + getDateOfBirth() + '\'' +
                ", discipline=" + getDiscipline() +
                '}';
    }
}
