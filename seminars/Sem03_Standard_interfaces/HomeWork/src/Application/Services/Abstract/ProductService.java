package Application.Services.Abstract;

import Application.Model.Abstracts.ProductFactory;
import Application.Model.Abstracts.ProductForSale;
import Application.Services.Interface.ProductServiceInterface;

import java.util.Map;

public abstract class ProductService<T extends ProductFactory> implements ProductServiceInterface {
    protected T factory;
    protected Map<String, Float> priceList;
    protected Map<String, Map<String, Float>> recipeBook;
    protected Float cash;
    protected Float deposit;
    protected Float change;
    protected ProductForSale productStashed;

    public ProductService(T factory) {
        setFactory(factory);
        setPriceList(getPriceList());
        setRecipeBook(getRecipeBook());
    }

    protected abstract T getFactory();

    protected abstract void setFactory(T factory);

    protected abstract Map<String, Float> getPriceList();

    protected abstract void setPriceList(Map<String, Float> priceList);

    protected abstract Map<String, Map<String, Float>> getRecipeBook();

    protected abstract void setRecipeBook(Map<String, Map<String, Float>> recipeBook);
}
