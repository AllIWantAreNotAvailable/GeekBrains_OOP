package Model.Abstracts.Users;

import Model.Abstracts.Base.EntityGroup;

import java.util.List;
import java.util.Map;

public abstract class UsersGroup<T extends User> extends EntityGroup<T> {
    public UsersGroup(Map<Long, T> group) {
        super(group);
    }

    public UsersGroup(List<T> group) {
        super(group);
    }

    public UsersGroup() {
        super();
    }
}
