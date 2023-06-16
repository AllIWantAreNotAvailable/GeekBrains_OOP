from abc import ABC, abstractmethod


class HotDrink(ABC):

    def __init__(self, my_id, temperature, cost, is_ready_to_serve):
        self.id = my_id
        self.temperature = temperature
        self.cost = cost
        self.is_ready_to_serve = is_ready_to_serve
