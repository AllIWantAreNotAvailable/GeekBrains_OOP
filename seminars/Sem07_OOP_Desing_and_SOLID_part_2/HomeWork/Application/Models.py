from . import Controller, ModelController, Model

import json


class CalculatorModelController(ModelController):

    def __init__(self, controller: Controller, model: Model):
        super().__init__(controller, model)

    def response(self, response: str):
        print(f'Response from __CalculatorModelController__:\n{response}')
        self.get_controller().response(response)

    def request(self, request: str):
        print(f'Request from __CalculatorModelController__:\n{request}')
        self.get_model().run(**json.loads(request))


class ComplexCalculatorModel(Model):
    __left: complex = None
    __operation: str = None
    __right: complex = None

    def __init__(self, controller: Controller):
        super().__init__(controller)

    def run(self, left: str, operation: str, right: str):
        self.set_left(left)
        self.set_operation(operation)
        self.set_right(right)
        self.get_result()

    def set_left(self, left: str):
        self.__left = complex(left)

    def get_left(self) -> complex:
        return self.__left

    def set_operation(self, operation: str):
        self.__operation = operation

    def get_operation(self) -> str:
        return self.__operation

    def set_right(self, right: str):
        self.__right = complex(right)

    def get_right(self) -> complex:
        return self.__right

    def get_result(self):
        response = json.dumps(
            dict(
                left=str(self.get_left()),
                operation=str(self.get_operation()),
                right=str(self.get_right()),
                result=str(self.calculate())
            )
        )
        print(f'Response from __ComplexCalculatorModel__:\n{response}')
        self.get_controller().response(response)

    def calculate(self) -> complex:

        def addition() -> complex:
            return self.get_left() + self.get_right()

        def subtraction() -> complex:
            return self.get_left() - self.get_right()

        def multiplication() -> complex:
            return self.get_left() * self.get_right()

        def division() -> complex:
            return self.get_left() / self.get_right()

        # Switch case:
        operation = self.get_operation()
        if operation == '+':
            return addition()
        elif operation == '-':
            return subtraction()
        elif operation == '*':
            return multiplication()
        elif operation == '/':
            return division()
        else:
            raise Exception('No such operation Exception!')
