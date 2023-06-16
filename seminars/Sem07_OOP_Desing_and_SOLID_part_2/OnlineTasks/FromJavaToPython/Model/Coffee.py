from .HotDrink import HotDrink


class Coffee(HotDrink):

    def __init__(self, my_id, temperature, cost, is_ready_to_serve, brand, sort):
        super().__init__(my_id, temperature, cost, is_ready_to_serve)
        self.brand = brand
        self.sort = sort

    def get_id(self):
        return self.id

    def __str__(self) -> str:
        return (f'Coffee [id={self.id}'
                f', temperature={self.temperature}'
                f', cost={self.cost}'
                f', is_ready_to_serve={self.is_ready_to_serve}'
                f', brand={self.brand}'
                f', sort={self.sort}]')
