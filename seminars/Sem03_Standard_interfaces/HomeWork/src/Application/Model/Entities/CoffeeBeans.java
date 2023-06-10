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
    public ConsiderVolume getConsiderVolume() {
        return considerVolume;
    }

    @Override
    protected void setConsiderVolume(ConsiderVolume considerVolume) {
        super.considerVolume = considerVolume;
    }

    public String getRegionOfOrigin() {
        return regionOfOrigin;
    }

    private void setRegionOfOrigin(String regionOfOrigin) {
        this.regionOfOrigin = regionOfOrigin;
    }

    @Override
    public Float getRemainingVolume() {
        return super.remainingVolume;
    }

    @Override
    protected void setRemainingVolume(Float remainingVolume) {
        super.remainingVolume = remainingVolume;
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
    public Long getUuid() {
        return super.uuid;
    }

    @Override
    protected void setUuid(Long uuid) {
        super.uuid = uuid;
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    protected void setName(String name) {
        super.name = name;
    }

    @Override
    public Float getVolume() {
        return super.volume;
    }

    @Override
    protected void setVolume(Float volume) {
            super.volume = volume;
    }

    @Override
    public Float getBuyingPrice() {
        return super.buyingPrice;
    }

    @Override
    protected void setBuyingPrice(Float buyingPrice) {
        super.buyingPrice = buyingPrice;
    }

}
