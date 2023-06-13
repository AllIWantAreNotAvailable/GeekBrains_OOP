package Model.Entities.Comparators.Users;

import Model.Abstracts.User;

import java.util.Comparator;

public class UsersComparatorFullName<T extends User> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        int compareResult;
        compareResult = o1.getLastName().compareTo(o2.getLastName());
        if (compareResult == 0) {
            compareResult = o1.getFirstName().compareTo(o2.getFirstName());
            if (compareResult == 0)
                compareResult = o1.getUUID().compareTo(o2.getUUID());
        }
        return compareResult;
    }
}
