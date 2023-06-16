from .HotDrink import HotDrink


class Tea(HotDrink):

    def __init__(self, my_id, temperature, cost, is_ready_to_serve, is_green, region):
        super().__init__(my_id, temperature, cost, is_ready_to_serve)
        self.is_green = is_green
        self.region = region

    def get_id(self):
        return self.id

    def __str__(self) -> str:
        return (f'Tea [id={self.id}'
                f', temperature={self.temperature}'
                f', cost={self.cost}'
                f', is_ready_to_serve={self.is_ready_to_serve}'
                f', is_green={self.is_green}'
                f', region={self.region}]')
