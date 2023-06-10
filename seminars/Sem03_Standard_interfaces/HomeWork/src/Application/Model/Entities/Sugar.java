package Application.Model.Entities;

import Application.Model.Abstracts.ProductRaw;
import Application.Model.Enumerations.ConsiderVolume;
import Application.Model.Enumerations.SugarTypes;

public class Sugar extends ProductRaw {

    private SugarTypes type;

    public Sugar(String name, SugarTypes type, Float volume, Float buyingPrice) {
        super(name, volume, buyingPrice);
        setType(type);
        setConsiderVolume(ConsiderVolume.NO);
    }

    public SugarTypes getType() {
        return type;
    }

    public void setType(SugarTypes type) {
        this.type = type;
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
    public Sugar splitProduct(Float amount) throws Exception {
        if (amount != null
                && amount <= getRemainingVolume()) {
            float remainingCost = getBuyingPrice() / getRemainingVolume() * amount;
            Sugar sugar = new Sugar(getName(), getType(), amount, remainingCost);
            setRemainingVolume(getRemainingVolume() - amount);
            setBuyingPrice(getBuyingPrice() - remainingCost);
            return sugar;
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

    @Override
    public String toString() {
        return "Sugar{" +
                "uuid=" + getUuid() +
                ", name='" + getName() + '\'' +
                ", volume=" + getVolume() +
                ", considerVolume=" + getConsiderVolume() +
                ", remainingVolume=" + getRemainingVolume() +
                ", type=" + getType() +
                ", buyingPrice=" + getBuyingPrice() +
                '}';
    }
}
