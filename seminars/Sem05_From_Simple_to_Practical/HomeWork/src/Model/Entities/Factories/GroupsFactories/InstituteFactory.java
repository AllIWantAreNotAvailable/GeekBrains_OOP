package Model.Entities.Factories.GroupsFactories;

import Model.Abstracts.Base.EntitiesGroupFactory;
import Model.Entities.Groups.Institute;

public class InstituteFactory extends EntitiesGroupFactory<Institute> {

    @Override
    public Institute create() {
        return new Institute();
    }
}
