package Abstracts;

import java.util.Iterator;
import java.util.List;

public abstract class UserGroupsStreamIterator<T extends UserGroupsStream<E>, E extends UsersGroup<? extends User>> implements Iterator<E> {

    protected  int index;
    protected final T stream;

    public UserGroupsStreamIterator(T stream) {
        this.index = 0;
        this.stream = stream;
    }

    protected abstract List<E> getStream();

}
