package Model.Abstracts;

import java.util.List;

public abstract class StreamsUniversityIterator<T extends GroupsStream<E>, E extends UsersGroup<? extends User>> {

    protected int index;
    protected final List<E> stream;

    public StreamsUniversityIterator(T stream) {
        this.index = 0;
        this.stream = stream.getStream();
    }

    protected abstract List<E> getStream();
}
