package Model.Interfaces;

import Model.Abstracts.User;
import Model.Abstracts.UsersGroup;

import java.util.Comparator;
import java.util.List;

public interface GroupsStreamInterface<T extends UsersGroup<? extends User>> {

    long getUUID();

    List<T> getStream();

    boolean updateStream(List<T> stream);

    void sort(Comparator<T> comparator);

    List<T> sorted(Comparator<T> comparator);

    void add(T userGroup);

    void add(List<T> userGroupsList);
}
