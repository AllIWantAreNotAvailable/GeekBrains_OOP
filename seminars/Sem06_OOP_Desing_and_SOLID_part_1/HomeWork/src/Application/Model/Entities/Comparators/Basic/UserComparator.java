package Application.Model.Entities.Comparators.Basic;

import Application.Model.Abstract.Users.UserImpl;

import java.util.Comparator;

public class UserComparator<T extends UserImpl> implements Comparator<T> {
    @Override
    public int compare(T left, T right) {
        int compareResult = left.getSurname().compareTo(right.getSurname());
        if (compareResult == 0) {
            compareResult = left.getName().compareTo(right.getName());
            if (compareResult == 0) {
                compareResult = left.getDateOfBirth().compareTo(right.getDateOfBirth());
                if (compareResult == 0)
                    compareResult = left.getUUID().compareTo(right.getUUID());
            }
        }
        return compareResult;
    }
}
