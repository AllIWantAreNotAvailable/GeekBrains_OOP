package Model.Abstracts;

import java.util.Iterator;
import java.util.List;

public abstract class GroupsStreamIterator<T extends GroupsStream<E>, E extends UsersGroup<? extends User>> implements Iterator<E> {

    protected  int index;
    protected final T stream; // TODO: 14.06.2023 Заменить на HashMap<>(): ключ UserGroup.UUID; значение UserGroup

    public GroupsStreamIterator(T stream) {
        this.index = 0;
        this.stream = stream;
    }

    protected abstract List<E> getStream();

}
