package Application.Controller.Abstract;

import Application.Model.Abstracts.ProductForSale;
import Application.Services.Abstract.ProductService;
import Application.Services.Interfaces.ProductServiceInterface;
import Application.View.Abstract.ViewModel;

import java.util.List;

public abstract class ControllerModel<M extends ProductService, V extends ViewModel> implements ProductServiceInterface {
    static long nextUUID;

    protected long controllerUUID;
    protected M service;
    protected V view;

    public ControllerModel(M service, V view) {
        setControllerUUID(nextUUID++);
        setService(service);
        setView(view);
    }

    public abstract long getControllerUUID();

    protected abstract void setControllerUUID(long controllerUUID);

    public abstract M getService();

    protected abstract void setService(M service);

    public abstract V getView();

    protected abstract void setView(V view);

    public abstract List<ProductForSale> getSoldSortedList();
}
