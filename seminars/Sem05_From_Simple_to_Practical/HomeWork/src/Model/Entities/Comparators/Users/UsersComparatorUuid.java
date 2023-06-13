package Model.Entities.Comparators.Users;

import Model.Abstracts.User;

import java.util.Comparator;

public class UsersComparatorUuid<T extends User> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getUUID().compareTo(o2.getUUID());
    }
}
