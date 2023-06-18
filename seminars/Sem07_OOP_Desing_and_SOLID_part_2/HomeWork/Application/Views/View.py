from abc import ABC, abstractmethod
from typing import NoReturn

from Application.Controllers.Controller import Controller

import json


class View(ABC):

    __controller: Controller = None
    __request: dict = None
    __response: dict = None

    def __init__(self, controller: Controller):
        self.set_controller(controller)
        self.clear_request()

    def get_view_name(self) -> str:
        return f'__{self.__class__.__name__}__'

    def clear_request(self) -> NoReturn:
        if self.get_request():
            self.get_request().clear()
            self.get_request().update({'from': self.get_view_name()})
        else:
            self.set_request({'from': self.get_view_name()})

    def set_controller(self, controller: Controller) -> NoReturn:
        if isinstance(controller, Controller):
            self.__controller = controller
        else:
            # TODO raise Exception and make log
            pass

    def get_controller(self) -> Controller:
        return self.__controller

    def set_request(self, request: dict) -> NoReturn:
        if isinstance(request, dict):
            self.__request = request
        else:
            # TODO raise Exception and make log
            pass

    def get_request(self) -> dict:
        return self.__request

    def set_response(self, response: dict) -> NoReturn:
        if isinstance(response, dict):
            self.__response = response
        else:
            # TODO raise Exception and make log
            pass

    def get_response(self) -> dict:
        return self.__response

    @abstractmethod
    def response(self, response: str) -> NoReturn:
        pass

    @abstractmethod
    def get(self) -> NoReturn:
        pass

    @abstractmethod
    def post(self, request: str):
        pass

    @abstractmethod
    def run(self) -> NoReturn:
        pass


class ComplexCalculatorView(View):

    def __init__(self, controller: Controller):
        super().__init__(controller)

    def clear_request(self) -> NoReturn:
        super().clear_request()
        self.get_request().update(
            dict(
                left=None,
                operation=None,
                right=None
            )
        )

    def response(self, response: str) -> NoReturn:
        self.set_response(json.loads(response))

    def get(self) -> NoReturn:
        request = json.dumps(self.get_request())
        self.get_controller().post(request)

    @staticmethod
    def is_valid_operand(operand: str) -> bool:
        try:
            complex(operand)
        except ValueError:
            print('Комплексное число введено не верно.')
            return False
        else:
            return True

    def run(self) -> NoReturn:
        while left := input('Введите ' + "left" + ':\n>>> '):
            if self.is_valid_operand(left):
                self.get_request().update({"left": left})
                break

        while right := input('Введите ' + "right" + ':\n>>> '):
            if self.is_valid_operand(right):
                self.get_request().update({"right": right})
                break

        self.get_request().update({"operation": input('Введите ' + "operation" + ':\n>>> ')})

        self.get()

    def post(self, request: str):
        print('{left} {operation} {right} = {result}'.format(**json.loads(request)))
