package Model.Abstracts;

import Model.Interfaces.UniversityInterface;

import java.util.*;

public abstract class StreamsUniversity<T extends GroupsStream<? extends UsersGroup<? extends User>>> extends Entity implements UniversityInterface<T>, Iterable<T> {

    protected HashMap<Long, T> streams;

    public StreamsUniversity(HashMap<Long, T> streams) {
        super();
        initStream(streams);
    }

    public StreamsUniversity(List<T> streams) {
        this(new HashMap<>());
        setStreams(streams);
    }

    public StreamsUniversity() {
        this(new HashMap<>());
    }

    protected abstract void initStream(Map<Long, T> streams);

    protected abstract void setStreams(List<T> streams);

    protected abstract Map<Long, T> getStructure();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StreamsUniversity<?> that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getStreams(), that.getStreams());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getStreams());
    }

    @Override
    public String toString() {
        return "StreamsUniversity{" +
                "UUID=" + getUUID() +
                ", streams=" + getStreams() +
                '}';
    }
}
