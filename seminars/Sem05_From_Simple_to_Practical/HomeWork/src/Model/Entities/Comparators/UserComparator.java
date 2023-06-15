package Model.Entities.Comparators;

import Model.Entities.Users.User;

import java.util.Comparator;

public class UserComparator<T extends User> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        // По фамилии
        int compareResult = o1.getLastName().compareTo(o2.getLastName());
        if (compareResult == 0) {
            // По имени
            compareResult = o1.getFirstName().compareTo(o2.getFirstName());
            if (compareResult == 0) {
                // По году рождения
                compareResult = o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
                if (compareResult == 0)
                    // По UUID
                    compareResult = o1.getUUID().compareTo(o2.getUUID());
            }
        }
        return compareResult;
    }
}
