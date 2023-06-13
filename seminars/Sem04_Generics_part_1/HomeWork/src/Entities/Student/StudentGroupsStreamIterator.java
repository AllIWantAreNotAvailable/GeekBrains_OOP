package Entities.Student;

import Abstracts.UserGroupsStreamIterator;

import java.util.List;

public class StudentGroupsStreamIterator extends UserGroupsStreamIterator<StudentGroupsStream, StudentsGroup> {

    public StudentGroupsStreamIterator(StudentGroupsStream stream) {
        super(stream);
    }

    @Override
    protected List<StudentsGroup> getStream() {
        return super.stream.getStream();
    }

    @Override
    public boolean hasNext() {
        return index < getStream().size();
    }

    @Override
    public StudentsGroup next() {
        return getStream().get(index++);
    }

    @Override
    public void remove() {
        getStream().remove(--index);
    }
}
