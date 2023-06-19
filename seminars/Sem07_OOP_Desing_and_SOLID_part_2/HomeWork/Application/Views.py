from . import Controller, ViewController, View

import json


class CalculatorViewController(ViewController):

    # __controller: Controller = None
    # __view: View = None

    def __init__(self, controller: Controller, view: View):
        super().__init__(controller, view)

    def run(self):
        self.get_view().run()

    def response(self, response: str):
        print(f'Response from __CalculatorViewController__:\n{response}')
        self.get_view().show(response)

    def request(self, request: str):
        print(f'Request from __CalculatorViewController__:\n{request}')
        self.get_controller().request(request)


class ComplexCalculatorView(View):

    # __controller: Controller = None

    def __init__(self, controller: Controller):
        super().__init__(controller)

    def run(self):
        self.menu()

    def menu(self):
        request = json.dumps(
            dict(
                left=input('left:\n>>> '),
                operation=input('operation:\n>>> '),
                right=input('right:\n>>> ')
            )
        )
        print(f'Request from __ComplexCalculatorView__:\n{request}')
        self.get_controller().request(request)

    def show(self, response: str):
        print(f'Response from __ComplexCalculatorView__:\n{response}')
        print("\nResult:\n"
              "{left} {operation} {right} = {result}".format(**json.loads(response)))
