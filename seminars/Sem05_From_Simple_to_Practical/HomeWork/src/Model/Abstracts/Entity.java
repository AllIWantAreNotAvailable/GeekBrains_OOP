package Model.Abstracts;

import Model.Interfaces.EntityInterface;

import java.util.Objects;

public abstract class Entity implements EntityInterface {

    static long nextUUID;

    protected long UUID;

    public Entity() {
        setUUID(nextUUID++);
    }

    protected abstract void setUUID(long UUID);


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity absEntity)) return false;
        return getUUID() == absEntity.getUUID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUUID());
    }

    @Override
    public String toString() {
        return "AbsEntity{" +
                "UUID=" + getUUID() +
                '}';
    }
}
