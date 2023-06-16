package Application.Entities;

import Application.Abstracts.HotDrink;

public class Tea extends HotDrink {

    private boolean isGreen;
    private String region;

    public Tea(int id, int temperature, float coast, boolean isGreen, String region) {
        super(id, temperature, coast);
        setGreen(isGreen);
        setRegion(region);
    }

    public boolean isGreen() {
        return isGreen;
    }

    public void setGreen(boolean green) {
        isGreen = green;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Tea{" +
                "id=" + getId() +
                ", coast=" + getCoast() +
                ", temperature=" + getTemperature() +
                ", isGreen=" + isGreen() +
                ", region='" + getRegion() + '\'' +
                '}';
    }
}
