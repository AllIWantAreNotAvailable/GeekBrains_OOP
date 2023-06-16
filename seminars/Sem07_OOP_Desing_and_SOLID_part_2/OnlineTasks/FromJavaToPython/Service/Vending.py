from abc import ABC, abstractmethod


class Vending(ABC):

    @abstractmethod
    def sell(self, item_id: int) -> None:
        pass

    @abstractmethod
    def load_something(self, drinks: list) -> None:
        pass
