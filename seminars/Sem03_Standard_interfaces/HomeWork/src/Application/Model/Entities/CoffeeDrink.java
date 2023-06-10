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
        // TODO: 10.06.2023 Подумать на счет обработки входящего null
        if (composition != null) {
            this.composition = composition;
        }
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
        // TODO: 10.06.2023 Подумать на счет обработки входящего null
        if (ingredient != null) {
            composition.add(ingredient);
        }
    }

    @Override
    public Float getSellingPrice() {
        return sellingPrice;
    }

    @Override
    public void setSellingPrice(Float sellingPrice) {
        // TODO: 10.06.2023 Подумать на счет обработки входящего null
        if (sellingPrice != null) {
            super.sellingPrice = sellingPrice;
        }
    }

    @Override
    public Long getUuid() {
        return uuid;
    }

    @Override
    protected void setUuid(Long uuid) {
        // TODO: 10.06.2023 Подумать на счет обработки входящего null
        if (uuid != null) {
            super.uuid = uuid;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    protected void setName(String name) {
        // TODO: 10.06.2023 Подумать на счет обработки входящего null
        if (name != null) {
            super.name = name;
        }
    }

    @Override
    public Float getVolume() {
        return volume;
    }

    @Override
    protected void setVolume(Float volume) {
        // TODO: 10.06.2023 Подумать на счет обработки входящего null
        if (volume != null) {
            super.volume = volume;
        }
    }

    @Override
    public Float getBuyingPrice() {
        return buyingPrice;
    }

    @Override
    protected void setBuyingPrice(Float buyingPrice) {
        // TODO: 10.06.2023 Подумать на счет обработки входящего null
        if (buyingPrice != null) {
            super.buyingPrice = buyingPrice;
        }
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
