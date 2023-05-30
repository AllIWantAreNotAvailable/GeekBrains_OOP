package Task_02_Market;

import Task_01_Human.Actor;
import Task_01_Human.Human;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *   Класс Market, который реализовывает два вышеуказанных интерфейса и хранит в списке список
 * людей в очереди в различных статусах
 */
public class Market implements QueueBehaviour, MarketBehaviour {
    String brandName;
    List<Human> entitiesInMarket;
    Queue<Human> queue;

    public Market(String brandName) {
        this.brandName = brandName;
        this.entitiesInMarket = new ArrayList<>();
        this.queue = new LinkedList<>();
    }

    @Override
    public void acceptToMarket(Human human) {
        entitiesInMarket.add(human);
    }

    @Override
    public void releaseFromMarket(Human human) {
        if (human.isPickedUpOrder()) entitiesInMarket.remove(human);
    }

    @Override
    public void takeInQueue(Human human) {
        queue.add(human);
    }

    @Override
    public void takeOrders() {
        if (!queue.isEmpty()) queue.peek().setReadyToOrder();
    }

    @Override
    public void giveOrders() {
        if (!queue.isEmpty()) queue.peek().setPickedUpOrder();
    }

    @Override
    public void releaseFromQueue() {
        System.out.printf("Bye, %s!\n", queue.peek());
        releaseFromMarket(queue.remove());
    }

    @Override
    public void update() {
        for (Human human : entitiesInMarket) {
            takeInQueue(human);
        }
        while (!queue.isEmpty()) {
            takeOrders();
            giveOrders();
            releaseFromQueue();
        }
    }
}
