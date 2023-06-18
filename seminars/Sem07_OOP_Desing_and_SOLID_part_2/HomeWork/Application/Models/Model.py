from typing import Any, NoReturn
from abc import ABC, abstractmethod

from Application.Controllers.Controller import Controller

import json


class Calculator(ABC):

    __left: str = None
    __operation: str = None
    __right: str = None

    def __init__(self, left: str = None, operation: str = None, right: str = None):
        self.set_left(left)
        self.set_operation(operation)
        self.set_right(right)

    @abstractmethod
    def set_left(self, left: str) -> NoReturn:
        pass

    @abstractmethod
    def get_left(self) -> Any:
        pass

    @abstractmethod
    def set_operation(self, operation: str) -> NoReturn:
        pass

    @abstractmethod
    def get_operation(self) -> Any:
        pass

    @abstractmethod
    def set_right(self, right: str) -> NoReturn:
        pass

    @abstractmethod
    def get_right(self) -> Any:
        pass

    @abstractmethod
    def get_result(self) -> Any:
        pass


class CalculatorService:

    __controller: Controller = None
    __calculator: Calculator = None
    __request: dict = dict(left=None,
                           operation=None,
                           right=None)

    def __init__(self, controller: Controller):
        self.set_controller(controller)

    def set_controller(self, controller: Controller) -> NoReturn:
        self.__controller = controller

    def get_controller(self) -> Controller:
        return self.__controller

    def set_calculator(self, calculator: Calculator) -> NoReturn:
        self.__calculator = calculator

    def get_calculator(self) -> Calculator:
        return self.__calculator

    def set_request(self, request: str) -> NoReturn:
        self.__request.update(**json.loads(request))

    def get_request(self) -> dict:
        return self.__request

    def __valid(self, request) -> bool:
        pass

    def get_result(self) -> str:
        self.get_request()['result'] = str(self.get_calculator()(**self.get_request()).get_result())
        return json.dumps(self.__request)

    def post(self, request: str) -> str:
        self.set_request(request)
        return self.get_result()


class ComplexCalculator(Calculator):

    __left: complex = None
    __operation: str = None
    __right: complex = None

    def __init__(self, left: str = None, operation: str = None, right: str = None):
        super().__init__(left, operation, right)

    def set_left(self, left: str) -> NoReturn:
        self.__left = complex(left)

    def get_left(self) -> complex:
        return self.__left

    def set_operation(self, operation: str):
        if (len(operation) == 1
                and operation in ['+', '-', '*', '/']):
            self.__operation = operation
        else:
            raise TypeError('This operation is not provided')

    def get_operation(self):
        return self.__operation

    def set_right(self, right: str) -> NoReturn:
        self.__right = complex(right)

    def get_right(self) -> complex:
        return self.__right

    def get_result(self) -> complex:

        if self.__operation == '+':
            return self.__addition()
        elif self.__operation == '-':
            return self.__subtraction()
        elif self.__operation == '*':
            return self.__multiplication()
        elif self.__operation == '/':
            return self.__division()
        else:
            raise ValueError('No such operation Exception')

    def __addition(self) -> complex:
        return self.get_left() + self.get_right()

    def __subtraction(self) -> complex:
        return self.get_left() - self.get_right()

    def __multiplication(self) -> complex:
        return self.get_left() * self.get_right()

    def __division(self) -> complex:
        return self.get_left() / self.get_right()
