package Model.Entities.Services;

import Model.Entities.Comparators.UserGroups.UserGroupsComparatorGroupSize;
import Model.Entities.Stream.StudentGroupsStream;
import Model.Entities.Student.StudentsGroup;

import java.util.Comparator;
import java.util.List;

public class StudentGroupsStreamService {
    private StudentGroupsStream stream;

    public StudentGroupsStreamService(StudentGroupsStream stream) {
        setStream(stream);
    }

    public StudentGroupsStream getStream() {
        return stream;
    }

    public void setStream(StudentGroupsStream stream) {
        this.stream = stream;
    }

    public void sort(Comparator<StudentsGroup> comparator) {
        getStream().sort(comparator);
    }

    public List<StudentsGroup> sorted(Comparator<StudentsGroup> comparator) {
        return getStream().sorted(comparator);
    }

    public void sort(){
        sort(new UserGroupsComparatorGroupSize<>());
    }
    public List<StudentsGroup> sorted() {
        return sorted(new UserGroupsComparatorGroupSize<>());
    }
}
