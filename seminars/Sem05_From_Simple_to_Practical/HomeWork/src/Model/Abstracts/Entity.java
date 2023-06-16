package Model.Abstracts;

import Model.Interfaces.Base.EntityInterface;

public abstract class Entity implements EntityInterface {

    static long nextUUID;

    private long UUID;

    public Entity() {
        setUUID();
    }

    private void setUUID() {
        this.UUID = nextUUID++;
    }

    public Long getUUID() {
        return UUID;
    }

}
