package Model.Entities.Teacher;

import Model.Abstracts.Base.EntityGroupIterator;

import java.util.List;

public class TeachersGroupIterator extends EntityGroupIterator<TeachersGroup, Teacher> {

    public TeachersGroupIterator(TeachersGroup tGroup) {
        super(tGroup);
    }

    @Override
    protected List<Teacher> getList() {
        return eList;
    }

    @Override
    public boolean hasNext() {
        return index < getList().size();
    }

    @Override
    public Teacher next() {
        return getList().get(index++);
    }

    @Override
    public void remove() {
        getList().remove(--index);
    }
}
