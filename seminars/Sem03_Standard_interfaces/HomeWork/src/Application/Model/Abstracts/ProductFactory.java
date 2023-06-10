package Application.Model.Abstracts;

import Application.Model.Enumerations.WorkingStatus;

public abstract class ProductFactory {

    static long nextUUID;
    protected Long factoryUUID;
    protected WorkingStatus status;

    public ProductFactory() {
        setUUID(nextUUID++);
    }

    protected abstract void switchStatus();

    protected abstract void setStatus(WorkingStatus status);

    protected abstract WorkingStatus getStatus();

    protected abstract void setUUID(long uuid);

    protected abstract long getUUID();

}
