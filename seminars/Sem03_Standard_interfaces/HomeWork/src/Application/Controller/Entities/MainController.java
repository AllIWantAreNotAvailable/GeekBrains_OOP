package Application.Controller.Entities;

import Application.Controller.Abstract.ControllerModel;
import Application.Model.Abstracts.Product;
import Application.Services.Entities.CoffeeService;
import Application.View.Entities.ConsoleApplication;

import java.util.Map;

public class MainController extends ControllerModel<CoffeeService, ConsoleApplication> {
    public MainController(CoffeeService service, ConsoleApplication view) {
        super(service, view);
    }

    @Override
    public long getControllerUUID() {
        return super.controllerUUID;
    }

    @Override
    protected void setControllerUUID(long controllerUUID) {
        super.controllerUUID = controllerUUID;
    }

    @Override
    public CoffeeService getService() {
        return super.service;
    }

    @Override
    protected void setService(CoffeeService service) {
        super.service = service;
    }

    @Override
    public ConsoleApplication getView() {
        return super.view;
    }

    @Override
    protected void setView(ConsoleApplication view) {
        view.setController(this);
        super.view = view;
    }


    // ### SERVICE ###
    @Override
    public Map<String, Float> getPriceList() {
        return getService().getPriceList();
    }

    @Override
    public Float getProductPrice(String productName) {
        return getService().getProductPrice(productName);
    }

    @Override
    public void makeDeposit(Float cash) {
        getService().makeDeposit(cash);
    }

    @Override
    public Float getChange() {
        return getService().getChange();
    }

    @Override
    public Product buyProduct(String productName, Float cash) throws Exception {
        return getService().buyProduct(productName, cash);
    }

    // ### END_SERVICE ###
}
