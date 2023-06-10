package Application.Model.Entities;

import Application.Model.Abstracts.ProductRaw;
import Application.Model.Enumerations.ConsiderVolume;

public class Water extends ProductRaw {

    private Float phIndex;

    public Water(String name, Float phIndex, Float volume, Float buyingPrice) {
        super(name, volume, buyingPrice);
        setPhIndex(phIndex);
        setConsiderVolume(ConsiderVolume.YES);
    }

    public Float getPhIndex() {
        return phIndex;
    }

    private void setPhIndex(Float phIndex) {
        this.phIndex = phIndex;
    }

    @Override
    public ConsiderVolume getConsiderVolume() {
        return considerVolume;
    }

    @Override
    protected void setConsiderVolume(ConsiderVolume considerVolume) {
        super.considerVolume = considerVolume;
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
    public Water splitProduct(Float amount) throws Exception {
        if (amount != null
                && amount <= getRemainingVolume()) {
            float remainingCost = getBuyingPrice() / getRemainingVolume() * amount;
            Water water = new Water(getName(), getPhIndex(), amount, remainingCost);
            setRemainingVolume(getRemainingVolume() - amount);
            setBuyingPrice(getBuyingPrice() - remainingCost);
            return water;
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
