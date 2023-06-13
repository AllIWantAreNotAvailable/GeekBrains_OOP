package Entities.Comparators.UserGroupsStream;

import Abstracts.User;
import Abstracts.UserGroupsStream;
import Abstracts.UsersGroup;

import java.util.Comparator;

public class UserGroupsStreamComparatorStreamSize<T extends UserGroupsStream<? extends UsersGroup<? extends User>>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getStream().size(), o2.getStream().size());
    }

}
