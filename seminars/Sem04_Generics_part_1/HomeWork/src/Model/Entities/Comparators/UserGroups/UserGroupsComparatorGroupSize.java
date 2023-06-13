package Model.Entities.Comparators.UserGroups;

import Model.Abstracts.User;
import Model.Abstracts.UsersGroup;

import java.util.Comparator;

public class UserGroupsComparatorGroupSize<T extends UsersGroup<? extends User>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getGroup().size(), o2.getGroup().size());
    }
}
