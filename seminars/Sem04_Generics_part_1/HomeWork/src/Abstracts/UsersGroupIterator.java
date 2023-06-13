package Abstracts;

import java.util.Iterator;
import java.util.List;

public abstract class UsersGroupIterator<T extends UsersGroup<E>, E extends User> implements Iterator<E> {

    protected int index;
    protected final T group;

    public UsersGroupIterator(T group) {
        this.index = 0;
        this.group = group;
    }

    protected abstract List<E> getGroup();

}
