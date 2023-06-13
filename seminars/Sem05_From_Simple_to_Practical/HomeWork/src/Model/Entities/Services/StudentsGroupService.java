package Model.Entities.Services;

import Model.Entities.Student.Student;
import Model.Entities.Student.StudentsGroup;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class StudentsGroupService {

    private StudentsGroup group;

    public StudentsGroupService(StudentsGroup group) {
        setGroup(group);
    }

    public StudentsGroup getGroup() {
        return group;
    }

    public void setGroup(StudentsGroup group) {
        this.group = group;
    }

    public void deleteByFullName(String firstName, String lastName) {
        int hash = Objects.hash(firstName, lastName);
        Iterator<Student> iterator = getGroup().iterator();

        while (iterator.hasNext()) {
            if (iterator.next().hashCode() == hash) {
                iterator.remove();
                break;
            }
        }
    }

    public void sortGroup(Comparator<Student> comparator, boolean reversedOrder) {
        if (reversedOrder)
            getGroup().getGroup().sort(comparator.reversed());
        else
            getGroup().getGroup().sort(comparator);
    }

}
