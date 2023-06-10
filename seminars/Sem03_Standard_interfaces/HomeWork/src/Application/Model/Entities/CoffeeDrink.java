package Application.Model.Entities;

import Application.Model.Abstracts.ProductComposition;
import Application.Model.Abstracts.ProductForSale;
import Application.Model.Abstracts.ProductRaw;
import Application.Model.Enumerations.ConsiderVolume;

import java.util.List;

public class CoffeeDrink extends ProductForSale {

    ProductComposition<ProductRaw> composition;

    public CoffeeDrink(String name, List<ProductRaw> composition, Float sellingPrice) {
        super(name, 0f, 0f, sellingPrice);
        setComposition(new CoffeeDrinkComposition(composition));
        initFields();
    }

    public ProductComposition<ProductRaw> getComposition() {
        return composition;
    }

    public void setComposition(ProductComposition<ProductRaw> composition) {
        this.composition = composition;
    }

    private void initFields() {
        float buyingPrice = 0;
        float volume = 0;
        for (ProductRaw product :
                composition) {
            buyingPrice += product.getBuyingPrice();
            if (product.getConsiderVolume() == ConsiderVolume.YES) {
                volume += product.getRemainingVolume();
            }
        }
        setVolume(volume);
        setBuyingPrice(buyingPrice);
    }

    public void addIngredient(ProductRaw ingredient) {
        composition.add(ingredient);
    }

    @Override
    public Float getSellingPrice() {
        return sellingPrice;
    }

    @Override
    public void setSellingPrice(Float sellingPrice) {
        super.sellingPrice = sellingPrice;
    }

    @Override
    public Long getUuid() {
        return uuid;
    }

    @Override
    protected void setUuid(Long uuid) {
        super.uuid = uuid;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    protected void setName(String name) {
        super.name = name;
    }

    @Override
    public Float getVolume() {
        return volume;
    }

    @Override
    protected void setVolume(Float volume) {
        super.volume = volume;
    }

    @Override
    public Float getBuyingPrice() {
        return buyingPrice;
    }

    @Override
    protected void setBuyingPrice(Float buyingPrice) {
        super.buyingPrice = buyingPrice;
    }

    @Override
    public int compareTo(ProductForSale o) {
        int resultOfCompare = getSellingPrice().compareTo(o.getSellingPrice());
        if (resultOfCompare == 0) {
            resultOfCompare = getBuyingPrice().compareTo(o.getBuyingPrice());
            if (resultOfCompare == 0) {
                resultOfCompare = getName().compareTo(o.getName());
                if (resultOfCompare == 0) {
                    resultOfCompare = getUuid().compareTo(o.getUuid());
                }
            }
        }
        return resultOfCompare;
    }
}
