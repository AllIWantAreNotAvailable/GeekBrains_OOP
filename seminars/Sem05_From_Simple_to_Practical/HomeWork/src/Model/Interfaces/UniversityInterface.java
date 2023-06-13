package Model.Interfaces;

import Model.Abstracts.GroupsStream;
import Model.Abstracts.User;
import Model.Abstracts.UsersGroup;

import java.util.Comparator;
import java.util.List;

public interface UniversityInterface<T extends GroupsStream<? extends UsersGroup<? extends User>>> {

    long getUUID();

    List<T> getStreams();

    void sort(Comparator<T> comparator);

    List<T> sorted(Comparator<T> comparator);

    void add(T stream);

    void add(List<T> streamsList);
}
