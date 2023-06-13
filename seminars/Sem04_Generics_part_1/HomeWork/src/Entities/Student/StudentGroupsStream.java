package Entities.Student;

import Abstracts.UserGroupsStream;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class StudentGroupsStream extends UserGroupsStream<StudentsGroup> {

    public StudentGroupsStream(List<StudentsGroup> stream) {
        super(stream);
    }

    public StudentGroupsStream() {
        super();
    }

    @Override
    protected void setUUID(long UUID) {
        super.UUID = UUID;
    }

    @Override
    protected void setStream(List<StudentsGroup> stream) {
        super.stream = Objects.requireNonNull(stream);
    }

    @Override
    public long getUUID() {
        return UUID;
    }

    @Override
    public List<StudentsGroup> getStream() {
        return stream;
    }

    @Override
    public boolean updateStream(List<StudentsGroup> stream) {
        setStream(stream);
        return true;
    }

    @Override
    public void sort(Comparator<StudentsGroup> comparator) {
        getStream().sort(comparator);
    }

    @Override
    public List<StudentsGroup> sorted(Comparator<StudentsGroup> comparator) {
        sort(comparator);
        return getStream();
    }

    @Override
    public void add(StudentsGroup userGroup) {
        getStream().add(userGroup);
    }

    @Override
    public void add(List<StudentsGroup> userGroupsList) {
        for (StudentsGroup group :
                userGroupsList) {
            add(group);
        }
    }

    @Override
    public Iterator<StudentsGroup> iterator() {
        return new StudentGroupsStreamIterator(this);
    }
}
