package Application.Model.Entities;

import Application.Model.Abstracts.ProductRaw;

public class Milk extends ProductRaw {
    private Float fatnessPercentage;

    public Milk(String name, Float fatnessPercentage, Float volume, Float buyingPrice) {
        super(name, volume, buyingPrice);
        setFatnessPercentage(fatnessPercentage);
    }

    private void setFatnessPercentage(Float fatnessPercentage) {
        // TODO: 10.06.2023 Подумать на счет обработки входящего null
        if (fatnessPercentage != null) {
            this.fatnessPercentage = fatnessPercentage;
        }
    }

    public Float getFatnessPercentage() {
        return fatnessPercentage;
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
    public ProductRaw splitProduct(Float amount) throws Exception {
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
    protected void setBuyingPrice(Float buyingPrice) {
        // TODO: 10.06.2023 Подумать на счет обработки входящего null
        if (buyingPrice != null) {
            super.buyingPrice = buyingPrice;
        }
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
