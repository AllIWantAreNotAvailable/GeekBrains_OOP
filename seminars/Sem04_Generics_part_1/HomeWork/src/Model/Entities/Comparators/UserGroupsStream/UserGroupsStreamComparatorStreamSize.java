package Model.Entities.Comparators.UserGroupsStream;

import Model.Abstracts.User;
import Model.Abstracts.GroupsStream;
import Model.Abstracts.UsersGroup;

import java.util.Comparator;

public class UserGroupsStreamComparatorStreamSize<T extends GroupsStream<? extends UsersGroup<? extends User>>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getStream().size(), o2.getStream().size());
    }

}
