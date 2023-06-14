package Model.Entities.Groups;

import Model.Abstracts.Base.EntitiesGroupIterator;
import Model.Entities.Teacher.TeachersGroup;

import java.util.List;

public class InstituteIterator extends EntitiesGroupIterator<Institute, TeachersGroup> {

    public InstituteIterator(Institute tGroup) {
        super(tGroup);
    }

    @Override
    protected List<TeachersGroup> getList() {
        return super.eList;
    }

    @Override
    public boolean hasNext() {
        return index < getList().size();
    }

    @Override
    public TeachersGroup next() {
        return getList().get(index++);
    }

    @Override
    public void remove() {
        getList().remove(--index);
    }
}
