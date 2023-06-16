package Application.Model.Entities.Generators;

import Application.Model.Abstract.Base.Entity;
import Application.Model.Generator;

public class SimpleIdGenerator extends Entity implements Generator<Long> {

    private Long id;

    public SimpleIdGenerator(Long id) {
        setId(id);
    }

    public SimpleIdGenerator() {
        setId(0L);
    }

    private void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long generate() {
        return id++;
    }
}
