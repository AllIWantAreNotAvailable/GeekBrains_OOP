from . import Controller, ABC, abstractmethod


class View(ABC):

    __controller: Controller = None

    def __init__(self, controller: Controller):
        self.set_controller(controller)

    def get_controller(self) -> Controller:
        return self.__controller

    def set_controller(self, controller: Controller):
        self.__controller = controller

    @abstractmethod
    def run(self):
        pass

    @abstractmethod
    def menu(self):
        pass

    @abstractmethod
    def show(self, response: str):
        pass


class ViewController(Controller):

    __controller: Controller = None
    __view: View = None

    def __init__(self, controller: Controller, view: View):
        super().__init__()
        self.set_controller(controller)
        self.set_view(view(self))

    def get_controller(self) -> Controller:
        return self.__controller

    def set_controller(self, controller: Controller):
        self.__controller = controller

    def get_view(self) -> View:
        return self.__view

    def set_view(self, view: View):
        self.__view = view

    def response(self, response: str):
        pass

    def request(self, request: str):
        pass

    @abstractmethod
    def run(self):
        pass

