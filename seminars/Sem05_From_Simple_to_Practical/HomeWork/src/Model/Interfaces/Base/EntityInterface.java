package Model.Interfaces.Base;

import Model.Abstracts.Base.Entity;

public interface EntityInterface<T extends Entity> {

    Long getUUID();
}
