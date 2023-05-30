package Task_01_Human;

import java.util.Objects;

/**
 *   Абстрактный класс Actor, который хранит в себе параметры актора,
 * включая состояние готовности сделать заказ и факт получения заказа.
 *   Дополнение: для большего понимания, можно сделать методы-геттеры для
 * имени и прочих “персональных данных” abstract
 */
public abstract class Actor implements ActorBehavior {
    protected String fullName;
    protected boolean readyToOrder;
    protected boolean pickedUpOrder;

    public Actor(String fullName) {
        this.fullName = fullName;
        this.readyToOrder = false;
        this.pickedUpOrder = false;
    }

    public abstract String getName();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor actor)) return false;
        return Objects.equals(fullName, actor.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "fullName='" + fullName + '\'' +
                ", readyToOrder=" + readyToOrder +
                ", pickedUpOrder=" + pickedUpOrder +
                '}';
    }
}
