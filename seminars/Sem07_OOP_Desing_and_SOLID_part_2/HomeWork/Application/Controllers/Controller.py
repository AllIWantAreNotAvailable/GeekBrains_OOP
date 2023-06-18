from Application.Views import View
from Application.Models import Calculator


class Controller:
    def __init__(self):
        self.__view = View(self)
        self.__model = Calculator(self)

    def start(self):
        self.__view.start()
