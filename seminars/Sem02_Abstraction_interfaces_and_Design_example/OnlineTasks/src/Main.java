import Task_01_Human.Human;
import Task_02_Market.Market;

public class Main {
    public static void main(String[] args) {
        task_02();
    }

    /**
     *   1. Интерфейс ActorBehavoir, который будет содержать описание возможных
     *   действий актора в очереди/магазине
     *   2. Абстрактный класс Actor, который хранит в себе параметры актора, включая
     *   состояние готовности сделать заказ и факт получения заказа.
     *   - Дополнение: для большего понимания, можно сделать методы-геттеры для имени
     *   и прочих “персональных данных” abstract
     *   3. Класс Human, который должен наследоваться от Actor и реализовывать ActorBehavoir
     */
    public static void task_01() {

    }

    /**
     *   1. Интерфейс QueueBehaviour, который описывает логику очереди – помещение в/освобождение
     * из очереди, принятие/отдача заказа
     *   2. Интерфейс MarketBehaviour, который описывает логику магазина – приход/уход покупателей,
     * обновление состояния магазина
     *   3. Класс Market, который реализовывает два вышеуказанных интерфейса и хранит в списке список
     * людей в очереди в различных статусах
     */
    public static void task_02() {
        Human hMaks = new Human("Maks");
        Human hKate = new Human("Kate");
        Human hGvido = new Human("Gvido");
        Human hRishat = new Human("Rishat");
        Human hEgor = new Human("Egor");
        Human hIgor = new Human("Igor");

        Market market = new Market("Magazine");
        market.acceptToMarket(hMaks);
        market.acceptToMarket(hIgor);
        market.acceptToMarket(hEgor);
        market.acceptToMarket(hKate);
        market.acceptToMarket(hGvido);
        market.acceptToMarket(hRishat);

        market.update();
    }
}