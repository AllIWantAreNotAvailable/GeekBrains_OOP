from Service.Vending import Vending


class VendingMachine(Vending):

    def __init__(self):
        self.products = list()

    def sell(self, item_id: int) -> None:
        for product in self.products:
            if product.get_id() == item_id:
                return product

    def load_something(self, drinks: list) -> None:
        self.products.extend(drinks)
