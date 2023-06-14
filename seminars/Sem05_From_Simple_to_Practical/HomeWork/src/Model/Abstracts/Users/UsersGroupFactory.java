package Model.Abstracts.Users;

import Model.Interfaces.Factories.Factory;

public abstract class UsersGroupFactory<T extends UsersGroup<? extends User>> implements Factory<T> {
}
