package Application.View.Abstract;

import Application.Controller.Abstract.ControllerModel;
import Application.Model.Abstracts.ProductFactory;
import Application.Services.Abstract.ProductService;
import Application.View.Interfaces.ViewInterface;

public abstract class ViewModel<T extends ProductFactory> implements ViewInterface {
    static long nextUUID;

    protected long formUUID;
    protected ControllerModel<ProductService<T>, ViewModel> controller;

    public ViewModel() {
        setFormUUID(nextUUID++);
    }

    public abstract void handler();

    public abstract long getFormUUID();

    protected abstract void setFormUUID(long formUUID);

    public abstract ControllerModel<ProductService<T>, ViewModel<T>> getController();

    public abstract void setController(ControllerModel<ProductService<T>, ViewModel<T>> controller);
}
