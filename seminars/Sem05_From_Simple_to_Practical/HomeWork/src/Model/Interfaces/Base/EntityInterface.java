package Model.Interfaces.Base;

import Model.Abstracts.Entity;

public interface EntityInterface<T extends Entity> {

    Long getUUID();
}
