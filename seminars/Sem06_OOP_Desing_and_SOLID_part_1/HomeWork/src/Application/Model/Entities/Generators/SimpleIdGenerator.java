package Application.Model.Entities.Generators;

import Application.Model.Abstract.Base.Entity;
import Application.Model.Interfaces.Supporting.Generator;

import java.util.Objects;

public class SimpleIdGenerator extends Entity implements Generator<String> {

    private Long id;

    public SimpleIdGenerator(Long id) {
        setId(id);
    }

    public SimpleIdGenerator() {
        this(0L);
    }

    private void setId(Long id) {
        this.id = Objects.requireNonNull(id);
    }

    @Override
    public String generate() {
        return Long.toString(this.id++);
    }
}
