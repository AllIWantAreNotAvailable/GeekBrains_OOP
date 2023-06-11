package Application.Controller.Entities;

import Application.Controller.Abstract.ControllerModel;
import Application.Model.Abstracts.Product;
import Application.Model.Abstracts.ProductForSale;
import Application.Model.Entities.CoffeeDrinkComparator;
import Application.Services.Entities.CoffeeService;
import Application.View.Entities.ConsoleApplication;


import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class MainController extends ControllerModel<CoffeeService, ConsoleApplication> {

    List<ProductForSale> soldProducts;

    public MainController(CoffeeService service, ConsoleApplication view) {
        super(service, view);
        setSoldProducts(new ArrayList<>());
    }

    private void setSoldProducts(List<ProductForSale> soldProducts) {
        this.soldProducts = soldProducts;
    }

    public List<ProductForSale> getSoldProducts() {
        return soldProducts;
    }

    private void addSoldProduct(ProductForSale soldProduct) {
        getSoldProducts().add(soldProduct);
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
        Product product = getService().buyProduct(productName, cash);
        addSoldProduct((ProductForSale) product);
        return product;
    }

    @Override
    public List<ProductForSale> getSoldSortedList() {
        getSoldProducts().sort(new CoffeeDrinkComparator<>());
        return getSoldProducts();
    }

    // ### END_SERVICE ###
}
