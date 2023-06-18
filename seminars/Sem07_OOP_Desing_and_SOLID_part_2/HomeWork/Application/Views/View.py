from Application.Controllers import Controller


class View:

    def __init__(self, controller: Controller):
        self.__controller = controller

    def start(self):
        print('Starting')
