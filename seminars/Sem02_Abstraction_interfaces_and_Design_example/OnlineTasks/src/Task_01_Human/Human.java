package Task_01_Human;

public class Human extends Actor{

    public Human(String fullName) {
        super(fullName);
    }

    @Override
    public String getName() {
        return super.fullName;
    }

    @Override
    public boolean isReadyToOrder() {
        return readyToOrder;
    }

    @Override
    public void setReadyToOrder() {
        this.readyToOrder = true;
    }

    @Override
    public boolean isPickedUpOrder() {
        return pickedUpOrder;
    }

    @Override
    public void setPickedUpOrder() {
        this.pickedUpOrder = true;
    }
}
