package Task_02_Market;

import Task_01_Human.Human;

/**
 *   Интерфейс QueueBehaviour, который описывает логику очереди – помещение в/освобождение
 * из очереди, принятие/отдача заказа.
 */
public interface QueueBehaviour {
    void takeInQueue(Human actor);
    void takeOrders();
    void giveOrders();
    void releaseFromQueue();
}
