from . import ABC, abstractmethod


class Controller(ABC):

    @abstractmethod
    def response(self, response: str):
        pass

    @abstractmethod
    def request(self, request: str):
        pass
