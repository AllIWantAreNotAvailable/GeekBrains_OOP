package Task_01_Human;

/**
 *   Интерфейс ActorBehavior, который будет содержать
 * описание возможных действий актора в очереди/магазине
 */
public interface ActorBehavior {

    public boolean isReadyToOrder();

    public void setReadyToOrder();

    public boolean isPickedUpOrder();

    public void setPickedUpOrder();

}
