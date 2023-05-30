package Task_02_Market;

import Task_01_Human.Human;

import java.util.List;

/**
 *   Интерфейс MarketBehaviour, который описывает логику магазина – приход/уход покупателей,
 * обновление состояния магазина
 */
public interface MarketBehaviour {
    void acceptToMarket(Human human);
    void releaseFromMarket(Human human);
    void update();
}
