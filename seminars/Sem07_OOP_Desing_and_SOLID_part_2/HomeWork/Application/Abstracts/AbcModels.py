from . import Controller, ABC, abstractmethod


class Model(ABC):

    __controller: Controller = None

    def __init__(self, controller: Controller):
        self.set_controller(controller)

    def get_controller(self) -> Controller:
        return self.__controller

    def set_controller(self, controller: Controller):
        self.__controller = controller

    @abstractmethod
    def run(self, **kwargs):
        pass


class ModelController(Controller):

    __controller: Controller = None
    __model: Model = None

    def __init__(self, controller: Controller, model: Model):
        super().__init__()
        self.set_controller(controller)
        self.set_model(model(self))

    def get_controller(self) -> Controller:
        return self.__controller

    def set_controller(self, controller: Controller):
        self.__controller = controller

    def get_model(self) -> Model:
        return self.__model

    def set_model(self, model: Model):
        self.__model = model

    def response(self, response: str):
        pass

    def request(self, request: str):
        pass
