package Model.Abstracts;

import Model.Interfaces.UniversityInterface;

import java.util.ArrayList;
import java.util.List;

public abstract class StreamsUniversity<T extends GroupsStream<? extends UsersGroup<? extends User>>> implements UniversityInterface<T>, Iterable<T> {

    static long nextUUID;

    protected long UUID;
    protected List<T> streams;  // TODO: 14.06.2023 Заменить на HashMap<>(): ключ GroupsStream.UUID; значение GroupsStream

    public StreamsUniversity(List<T> streams) {
        setUUID(nextUUID++);
        setStreams(streams);
    }

    public StreamsUniversity() {
        this(new ArrayList<>());
    }

    protected abstract void setUUID(long UUID);

    protected abstract void setStreams(List<T> streams);


}
