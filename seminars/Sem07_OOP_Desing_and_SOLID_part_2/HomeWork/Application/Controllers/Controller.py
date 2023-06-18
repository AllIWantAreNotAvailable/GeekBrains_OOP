from Application.Views import View
# from Application.Models import ComplexCalculator


class Controller:
    def __init__(self):
        self.__view = View(self)
        # self.__model = ComplexCalculator()

    def transfer(self, json):
        # {"from": "view"...} -> controller
        # {"from": "model"..} -> view
        pass

    def start(self):
        self.__view.start()
