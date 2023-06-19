from typing import NoReturn, NewType, Any, Union, Literal
from abc import ABC, abstractmethod


class Calculator(ABC):
    __left: Union[int, float, complex]
    __operation: Literal['-', '+', '*', '/']
    __right: Union[int, float, complex]

    def __init__(self,
                 left: Union[int, float, complex],
                 operation: Literal['-', '+', '*', '/'],
                 right: Union[int, float, complex]):
        self.left = left
        self.operation = operation
        self.right = right

    def __call__(self, *args, **kwargs) -> NoReturn:
        self.left = kwargs['left'] if kwargs['left'] else args[0]
        self.operation = kwargs['operation'] if kwargs['operation'] else args[1]
        self.right = kwargs['right'] if kwargs['right'] else args[2]

    @property
    def left(self) -> Union[int, float, complex]:
        return self.__left

    @left.setter
    def left(self, left: Union[int, float, complex]):
        self.__left = left

    @property
    def operation(self) -> Literal['-', '+', '*', '/']:
        return self.__operation

    @operation.setter
    def operation(self, operation: Literal['-', '+', '*', '/']):
        self.__operation = operation

    @property
    def right(self) -> Union[int, float, complex]:
        return self.__right

    @right.setter
    def right(self, right: Union[int, float, complex]):
        self.__right = right

    @abstractmethod
    def addition(self) -> Union[int, float, complex]:
        pass

    @abstractmethod
    def subtraction(self) -> Union[int, float, complex]:
        pass

    @abstractmethod
    def multiplication(self) -> Union[int, float, complex]:
        pass

    @abstractmethod
    def division(self) -> Union[int, float, complex]:
        pass

    @abstractmethod
    def get(self) -> Union[int, float, complex]:
        pass


class ComplexCalculator(Calculator):

    def __init__(self,
                 left: Union[int, float, complex],
                 operation: Literal['-', '+', '*', '/'],
                 right: Union[int, float, complex]):
        super().__init__(complex(left), operation, complex(right))

    def addition(self) -> Union[int, float, complex]:
        return self.left + self.right

    def subtraction(self) -> Union[int, float, complex]:
        return self.left - self.right

    def multiplication(self) -> Union[int, float, complex]:
        return self.left * self.right

    def division(self) -> Union[int, float, complex]:
        return self.left / self.right

    def get(self) -> Union[int, float, complex]:
        if self.operation == '+':
            return self.addition()
        elif self.operation == '-':
            return self.subtraction()
        elif self.operation == '*':
            return self.multiplication()
        elif self.operation == '/':
            return self.division()
        else:
            raise Exception('No such operation Exception!')
