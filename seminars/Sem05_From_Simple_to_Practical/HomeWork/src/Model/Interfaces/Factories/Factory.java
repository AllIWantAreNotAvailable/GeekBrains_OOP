package Model.Interfaces.Factories;

import Model.Abstracts.Entity;

public interface Factory<T extends Entity> {

    T create();
}
