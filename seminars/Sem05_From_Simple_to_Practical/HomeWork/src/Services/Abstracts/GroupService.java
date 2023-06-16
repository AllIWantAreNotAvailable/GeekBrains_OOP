package Services.Abstracts;

import Model.Entities.Groups.Base.UsersGroup;
import Model.Interfaces.Base.EntityGroupInterface;
import Model.Entities.Users.User;

public abstract class GroupService<T extends UsersGroup<E>, E extends User> implements EntityGroupInterface<E> {

    protected T group;

    public GroupService(T group) {
        setGroup(group);
    }

    public GroupService() {
    }

    public abstract T getGroup();

    public abstract void setGroup(T group);
}
