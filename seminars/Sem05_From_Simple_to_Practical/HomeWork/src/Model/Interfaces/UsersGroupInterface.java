package Model.Interfaces;

import Model.Abstracts.User;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public interface UsersGroupInterface<T extends User> {

    long getUUID();

    List<T> getGroup();

    boolean updateGroup(List<T> group);

    List<T> sorted(Comparator<T> comparator);

    void add(T user);

    void add(List<T> usersList);
}
