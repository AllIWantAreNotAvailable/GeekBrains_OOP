package Interfaces;

import Abstracts.User;

import java.util.Comparator;
import java.util.List;

public interface UsersGroupInterface<T extends User> {

    long getUUID();

    List<T> getGroup();

    boolean updateGroup(List<T> group);

    void sort(Comparator<T> comparator);

    List<T> sorted(Comparator<T> comparator);

    void add(T user);

    void add(List<T> usersList);
}
