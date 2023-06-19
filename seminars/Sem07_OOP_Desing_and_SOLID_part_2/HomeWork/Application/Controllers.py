from . import Controller, ViewController, ModelController


class MainController(Controller):

    __model: ModelController = None
    __view: ViewController = None

    def __init__(self):
        super().__init__()

    def get_model(self) -> ModelController:
        return self.__model

    def set_model(self, controller: ModelController):
        self.__model = controller

    def get_view(self) -> ViewController:
        return self.__view

    def set_view(self, view: ViewController):
        self.__view = view

    def run(self):
        self.get_view().run()

    def response(self, response: str):
        print(f'Response from __MainController__:\n{response}')
        self.get_view().response(response)

    def request(self, request: str):
        print(f'Request from __MainController__:\n{request}')
        self.get_model().request(request)
