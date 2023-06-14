package Model.Entities.Comparators.Default;

import Model.Abstracts.Users.User;

import java.util.Comparator;

public class UserComparator<T extends User> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        int compareResult = o1.getLastName().compareTo(o2.getLastName());
        if (compareResult == 0) {
            compareResult = o1.getFirstName().compareTo(o2.getFirstName());
            if (compareResult == 0)
                compareResult = new EntityComparator<T>().compare(o1, o2);
        }
        return compareResult;
    }
}
