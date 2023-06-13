package Model.Entities.Student;

import Model.Abstracts.UsersGroupIterator;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class StudentsGroupIterator extends UsersGroupIterator<StudentsGroup, Student> {

    public StudentsGroupIterator(StudentsGroup group) {
        super(group);
    }

    @Override
    protected List<Student> getGroup() {
        return super.group;
    }

    @Override
    public boolean hasNext() {
        return index < getGroup().size();
    }

    @Override
    public Student next() {
        return getGroup().get(index++);
    }

    @Override
    public void remove() {
        getGroup().remove(--index);
    }

    @Override
    public void forEachRemaining(Consumer<? super Student> action) {
        Objects.requireNonNull(action);
        while (hasNext())
            action.accept(next());
    }

}
