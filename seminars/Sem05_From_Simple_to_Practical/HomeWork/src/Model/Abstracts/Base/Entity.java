package Model.Abstracts.Base;

import Model.Interfaces.Base.EntityInterface;

public abstract class Entity implements EntityInterface<Entity> {

    static long nextUUID;

    protected long UUID;

    public Entity() {
        setUUID(nextUUID++);
    }

    protected abstract void setUUID(long UUID);
}
