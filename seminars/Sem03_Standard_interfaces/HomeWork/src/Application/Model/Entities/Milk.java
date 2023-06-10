package Application.Model.Entities;

import Application.Model.Abstracts.ProductRaw;
import Application.Model.Enumerations.ConsiderVolume;

public class Milk extends ProductRaw {
    private Float fatnessPercentage;

    public Milk(String name, Float fatnessPercentage, Float volume, Float buyingPrice) {
        super(name, volume, buyingPrice);
        setFatnessPercentage(fatnessPercentage);
        setConsiderVolume(ConsiderVolume.YES);
    }

    @Override
    public ConsiderVolume getConsiderVolume() {
        return considerVolume;
    }

    @Override
    protected void setConsiderVolume(ConsiderVolume considerVolume) {
        super.considerVolume = considerVolume;
    }

    public Float getFatnessPercentage() {
        return fatnessPercentage;
    }

    private void setFatnessPercentage(Float fatnessPercentage) {
        this.fatnessPercentage = fatnessPercentage;
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
    public Milk splitProduct(Float amount) throws Exception {
        if (amount != null
                && amount <= getRemainingVolume()) {
            float remainingCost = getBuyingPrice() / getRemainingVolume() * amount;
            Milk milk = new Milk(getName(), getFatnessPercentage(), amount, remainingCost);
            setRemainingVolume(getRemainingVolume() - amount);
            setBuyingPrice(getBuyingPrice() - remainingCost);
            return milk;
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
        return "Milk{" +
                "uuid=" + getUuid() +
                ", name='" + getName() + '\'' +
                ", volume=" + getVolume() +
                ", remainingVolume=" + getRemainingVolume() +
                ", considerVolume=" + getConsiderVolume() +
                ", fatnessPercentage=" + getFatnessPercentage() +
                ", buyingPrice=" + getBuyingPrice() +
                '}';
    }
}
