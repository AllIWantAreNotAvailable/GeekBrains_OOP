package Application.Abstracts;

public abstract class HotDrink {

    protected int id;
    protected int temperature;
    protected float coast;

    public HotDrink(int id, int temperature, float coast) {
        this.id = id;
        this.temperature = temperature;
        this.coast = coast;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public float getCoast() {
        return coast;
    }

    public void setCoast(float coast) {
        this.coast = coast;
    }
}
