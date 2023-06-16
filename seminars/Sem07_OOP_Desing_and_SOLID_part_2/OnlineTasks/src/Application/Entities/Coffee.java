package Application.Entities;

import Application.Abstracts.HotDrink;

public class Coffee extends HotDrink {

    private String brand;
    private String sort;
    private boolean isRoasted;

    public Coffee(int id, int temperature, float coast, String brand, String sort, boolean isRoasted) {
        super(id, temperature, coast);
        setBrand(brand);
        setSort(sort);
        setRoasted(isRoasted);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public boolean isRoasted() {
        return isRoasted;
    }

    public void setRoasted(boolean roasted) {
        isRoasted = roasted;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                ", id=" + getId() +
                ", temperature=" + getTemperature() +
                ", coast=" + getCoast() +
                ", brand='" + getBrand() + '\'' +
                ", sort='" + getSort() + '\'' +
                ", isRoasted=" + isRoasted() +
                '}';
    }
}
