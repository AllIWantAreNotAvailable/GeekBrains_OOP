package Application.Model.Abstracts;

import Application.Model.Interfaces.ProductsFactory;

public abstract class ProductFactory implements ProductsFactory {

    static long nextUUID;
    protected Long factoryUUID;

    public ProductFactory() {
        setUUID(nextUUID++);
    }

    protected abstract void setUUID(long uuid);

}
