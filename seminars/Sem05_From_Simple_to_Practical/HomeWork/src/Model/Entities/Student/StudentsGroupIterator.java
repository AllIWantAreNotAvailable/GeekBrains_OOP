package Model.Entities.Student;

import Model.Abstracts.Base.EntitiesGroupIterator;

import java.util.List;

public class StudentsGroupIterator extends EntitiesGroupIterator<StudentsGroup, Student> {

    public StudentsGroupIterator(StudentsGroup tGroup) {
        super(tGroup);
    }

    @Override
    protected List<Student> getList() {
        return super.eList;
    }

    @Override
    public boolean hasNext() {
        return index < getList().size();
    }

    @Override
    public Student next() {
        return getList().get(index++);
    }

    @Override
    public void remove() {
        getList().remove(--index);
    }
}
