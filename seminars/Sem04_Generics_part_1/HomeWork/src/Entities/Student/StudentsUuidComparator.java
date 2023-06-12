package Entities.Student;

import java.util.Collections;
import java.util.Comparator;

public class StudentsUuidComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getUUID().compareTo(o2.getUUID());
    }
}
