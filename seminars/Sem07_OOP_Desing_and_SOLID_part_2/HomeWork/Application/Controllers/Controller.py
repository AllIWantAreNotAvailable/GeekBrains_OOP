from abc import ABC, abstractmethod
from typing import Any, NoReturn

from Application import ComplexCalculatorView, CalculatorService

import json


class Controller(ABC):
    __routing: dict = None
    __model: dict = None
    __view: dict = None

    def __init__(self):
        pass

    def set_routing(self, routing: dict) -> NoReturn:
        if isinstance(routing, dict):
            self.__routing = routing
        else:
            # TODO raise Exception and make log
            pass

    def get_routing(self) -> dict:
        return self.__routing

    def set_model(self, model: dict) -> NoReturn:
        if isinstance(model, dict):
            self.__model = model
        else:
            # TODO raise Exception and make log
            pass

    def get_model(self) -> Any:
        return self.__model

    def set_view(self, view: dict) -> NoReturn:
        if isinstance(view, dict):
            self.__view = view
        else:
            # TODO raise Exception and make log
            pass

    def get_view(self) -> Any:
        return self.__view

    @abstractmethod
    def post(self, request: str) -> str:
        pass
    #
    # @abstractmethod
    # def get(self, request: str) -> str:
    #     pass


class MainController(Controller):

    def __init__(self):
        super().__init__()
        self.set_view({'__ComplexCalculatorView__': ComplexCalculatorView(self)})
        self.set_model({'__CalculatorService__': CalculatorService(self)})
        self.set_routing(
            {
                "__ComplexCalculatorView__": self.get_model()['__CalculatorService__'].post,
                "__CalculatorService__": self.get_view()['__ComplexCalculatorView__'].post
            }
        )

    def post(self, request: str) -> str:
        request: dict = json.loads(request)
        rout = dict(request.pop('from'))['from']
        return rout.post(json.dumps(request))
    #
    # def get(self, request: str) -> str:
    #     pass
