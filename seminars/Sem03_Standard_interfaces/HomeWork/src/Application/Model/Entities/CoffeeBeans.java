package Application.Model.Entities;

import Application.Model.Abstracts.ProductRaw;
import Application.Model.Enumerations.ConsiderVolume;

public class CoffeeBeans extends ProductRaw {
    
    private String regionOfOrigin;
    
    public CoffeeBeans(String name, String regionOfOrigin, Float volume, Float buyingPrice) {
        super(name, volume, buyingPrice);
        setRegionOfOrigin(regionOfOrigin);
        setConsiderVolume(ConsiderVolume.NO);
    }

    @Override
    protected void setConsiderVolume(ConsiderVolume considerVolume) {
        // TODO: 10.06.2023 Подумать на счет обработки входящего null
        if (considerVolume != null) {
            super.considerVolume = considerVolume;
        }
    }

    @Override
    public ConsiderVolume getConsiderVolume() {
        return considerVolume;
    }

    private void setRegionOfOrigin(String regionOfOrigin) {
        // TODO: 10.06.2023 Подумать на счет обработки входящего null
        if (regionOfOrigin != null) {
            this.regionOfOrigin = regionOfOrigin;
        }
    }

    public String getRegionOfOrigin() {
        return regionOfOrigin;
    }

    @Override
    protected void setRemainingVolume(Float remainingVolume) {
        // TODO: 10.06.2023 Подумать на счет обработки входящего null 
        if (remainingVolume != null) {
            super.remainingVolume = remainingVolume;
        }
    }

    @Override
    public Float getRemainingVolume() {
        return super.remainingVolume;
    }

    @Override
    public CoffeeBeans splitProduct(Float amount) throws Exception {
        if (amount != null
                && amount <= getRemainingVolume()) {
            float remainingCost = getBuyingPrice() / getRemainingVolume() * amount;
            CoffeeBeans coffeeBeans = new CoffeeBeans(getName(), getRegionOfOrigin(), amount, remainingCost);
            setRemainingVolume(getRemainingVolume() - amount);
            setBuyingPrice(getBuyingPrice() - remainingCost);
            return coffeeBeans;
        }
        throw new Exception("Failed to split the product Error!");
    }

    @Override
    public void refillProduct(ProductRaw product) throws Exception {
        if (this.equals(product)
                && product.getRemainingVolume() <= getVolume() - getRemainingVolume()) {
            setRemainingVolume(product.getVolume());
        }
        throw new Exception("Failed to refill the product Error!");
    }

    @Override
    protected void setBuyingPrice(Float buyingPrice) {
        // TODO: 10.06.2023 Подумать на счет обработки входящего null
        super.buyingPrice = buyingPrice;
    }

    @Override
    protected void setUuid(Long uuid) {
        // TODO: 10.06.2023 Подумать на счет обработки входящего null
        if (uuid != null) {
            super.uuid = uuid;
        }
    }

    @Override
    protected void setName(String name) {
        // TODO: 10.06.2023 Подумать на счет обработки входящего null
        if (name != null) {
            super.name = name;
        }
    }

    @Override
    protected void setVolume(Float volume) {
        // TODO: 10.06.2023 Подумать на счет обработки входящего null
        if (volume != null) {
            super.volume = volume;
        }
    }

    @Override
    public Long getUuid() {
        return super.uuid;
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public Float getVolume() {
        return super.volume;
    }

    @Override
    public Float getBuyingPrice() {
        return super.buyingPrice;
    }

}
