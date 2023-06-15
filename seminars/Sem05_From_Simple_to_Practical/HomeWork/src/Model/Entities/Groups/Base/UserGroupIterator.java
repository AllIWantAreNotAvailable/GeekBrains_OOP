package Model.Entities.Groups.Base;

import Model.Abstracts.EntitiesGroupIterator;
import Model.Entities.Users.User;

import java.util.List;

public class UserGroupIterator<T extends UsersGroup<E>, E extends User> extends EntitiesGroupIterator<T, E> {

    public UserGroupIterator(T tGroup) {
        super(tGroup);
    }

    @Override
    protected List<E> getList() {
        return super.eList;
    }

    @Override
    public boolean hasNext() {
        return index < getList().size();
    }

    @Override
    public E next() {
        return getList().get(index++);
    }

    @Override
    public void remove() {
        getList().remove(--index);
    }
}
