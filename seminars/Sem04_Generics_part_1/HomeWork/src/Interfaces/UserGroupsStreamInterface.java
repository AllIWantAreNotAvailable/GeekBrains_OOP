package Interfaces;

import Abstracts.UsersGroup;

import java.util.Comparator;
import java.util.List;

public interface UserGroupsStreamInterface<T extends UsersGroup> {

    long getUUID();

    List<T> getStream();

    boolean updateStream(List<T> stream);

    void sort(Comparator<T> comparator);

    List<T> sorted(Comparator<T> comparator);

    void add(T userGroup);

    void add(List<T> userGroupsList);
}
