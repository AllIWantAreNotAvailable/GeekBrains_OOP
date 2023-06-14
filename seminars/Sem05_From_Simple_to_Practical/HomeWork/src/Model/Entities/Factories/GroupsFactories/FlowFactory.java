package Model.Entities.Factories.GroupsFactories;

import Model.Abstracts.Base.EntitiesGroupFactory;
import Model.Entities.Groups.Flow;

public class FlowFactory extends EntitiesGroupFactory<Flow> {

    @Override
    public Flow create() {
        return new Flow();
    }
}
