package Model.Interfaces.Factories;

import Model.Abstracts.Base.Entity;

public interface Factory<T extends Entity> {

    T create();
}
