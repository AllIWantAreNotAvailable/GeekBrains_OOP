package Model.Entities.Comparators;

import Model.Entities.Users.Student;

import java.util.Comparator;

public class StudentComparator<T extends Student> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        int compareResult = o1.getStudyGroup().getUUID().compareTo(o2.getStudyGroup().getUUID());
        if (compareResult == 0)
            compareResult = new UserComparator<Student>().compare(o1, o2);
        return compareResult;
    }
}
