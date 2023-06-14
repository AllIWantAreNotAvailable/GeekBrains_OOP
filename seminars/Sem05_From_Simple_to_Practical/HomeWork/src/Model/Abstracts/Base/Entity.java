package Model.Abstracts.Base;

public abstract class Entity {

    static long nextUUID;

    protected long UUID;

    public Entity() {
        setUUID(nextUUID++);
    }

    protected abstract void setUUID(long UUID);
}
