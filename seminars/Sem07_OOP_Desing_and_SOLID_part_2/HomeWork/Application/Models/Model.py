from abc import ABC, abstractmethod


class MathOperations(ABC):

    @abstractmethod
    def reset(self):
        pass

    @abstractmethod
    def addition(self):
        pass

    @abstractmethod
    def subtraction(self):
        pass

    @abstractmethod
    def multiplication(self):
        pass

    @abstractmethod
    def division(self):
        pass


class AbsCalc(ABC):
    def __init__(self, value):
        self.result = value

    def show_result(self):
        pass


class Calculator(AbsCalc, MathOperations):

    def __init__(self, value):
        super().__init__(value)

    def reset(self):
        pass

    def addition(self):
        pass

    def subtraction(self):
        pass

    def multiplication(self):
        pass

    def division(self):
        pass

    def show_result(self):
        pass



