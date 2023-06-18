from abc import ABC, abstractmethod


class MathOperations(ABC):

    @abstractmethod
    def reset(self):
        pass

    @abstractmethod
    def addition(self, right):
        pass

    @abstractmethod
    def subtraction(self, right):
        pass

    @abstractmethod
    def multiplication(self, right):
        pass

    @abstractmethod
    def division(self, right):
        pass


class AbsCalc(ABC):

    # result = None

    def __init__(self, value):
        # self.set_result(value)
        pass

    @abstractmethod
    def set_result(self, result):
        pass

    @abstractmethod
    def get_result(self):
        pass

    @abstractmethod
    def show_result(self):
        pass


class ComplexCalculator(AbsCalc, MathOperations):

    def __init__(self, value: complex):
        super().__init__(value)

    def reset(self) -> None:
        self.set_result(0)

    def addition(self, right: complex) -> None:
        left = self.get_result()
        self.set_result(left + right)

    def subtraction(self, right: complex) -> None:
        left = self.get_result()
        self.set_result(left - right)

    def multiplication(self, right: complex) -> None:
        left = self.get_result()
        self.set_result(left * right)

    def division(self, right: complex) -> None:
        left = self.get_result()
        self.set_result(left / right)

    def set_result(self, result: complex) -> None:
        self.result = result

    def get_result(self) -> complex:
        return self.result

    def show_result(self) -> None:
        print(self.get_result())
