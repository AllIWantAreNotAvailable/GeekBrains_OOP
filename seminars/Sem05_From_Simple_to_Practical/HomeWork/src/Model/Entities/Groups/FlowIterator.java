package Model.Entities.Groups;

import Model.Abstracts.Base.EntitiesGroupIterator;
import Model.Entities.Student.StudentsGroup;

import java.util.List;

public class FlowIterator extends EntitiesGroupIterator<Flow, StudentsGroup> {

    public FlowIterator(Flow tGroup) {
        super(tGroup);
    }

    @Override
    protected List<StudentsGroup> getList() {
        return super.eList;
    }

    @Override
    public boolean hasNext() {
        return index < getList().size();
    }

    @Override
    public StudentsGroup next() {
        return getList().get(index++);
    }

    @Override
    public void remove() {
        getList().remove(--index);
    }
}
