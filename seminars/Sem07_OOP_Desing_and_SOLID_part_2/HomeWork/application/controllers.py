"""
Модуль содержит контроллеры приложения и абстракцию для создания новых контроллеров
"""

from typing import NoReturn, NewType, Any, Union
from abc import ABC, abstractmethod

from .app_logging import logger

import json

# Тип для аннотаций методов классов
JSON = NewType('Json', Union[str, dict])


class AbcController(ABC):
    """
    Абстрактный класс для создания контроллеров приложения.
    """
    __master: Any
    __slave: Any

    def __init__(self, master, slave):
        self.master = master
        self.slave = slave

    @property
    def master(self) -> Any:
        return self.__master

    @master.setter
    def master(self, master: Any):
        self.__master = master

    @property
    def slave(self) -> Any:
        return self.__slave

    @slave.setter
    def slave(self, slave: Any):
        self.__slave = slave

    @abstractmethod
    def post(self, request: JSON) -> JSON:
        """
        Метод, который отправляет данные в модель и возвращает код ответа от адресата вызова.
        :param request: Данные в формате JSON.
        :return: Код ответа адресата.
        """
        pass

    @abstractmethod
    def get(self) -> JSON:
        """
        Метод для получения данных от модели.
        :return: JSON, который содержит код ответа адресата и данные из модели, если запрос выполнен успешно.
        """
        pass


@logger
class ModelController(AbcController):
    """
    Контроллер модели отвечает за передачу запроса в модель и возврат данных в интерфейс пользователя.
    """
    def __init__(self, master, slave):
        super().__init__(master, slave)

    def post(self, request: JSON) -> JSON:
        """
        Метод, который отправляет данные в модель и возвращает код ответа от адресата вызова.
        :param request: Данные в формате JSON.
        :return: Код ответа адресата.
        """
        try:
            self.slave = self.slave(**json.loads(request))
        except Exception as ex:
            return JSON(json.dumps(dict(response=400, exeption=str(ex))))
        else:
            return JSON(json.dumps(dict(response=200)))

    def get(self) -> JSON:
        """
        Метод для получения данных от модели.
        :return: JSON, который содержит код ответа адресата и данные из модели, если запрос выполнен успешно.
        """
        try:
            result = self.slave.get()
        except Exception as ex:
            return JSON(json.dumps(dict(response=400, exeption=str(ex))))
        else:
            return JSON(json.dumps(dict(response=200, result=str(result))))


@logger
class ViewController(AbcController):
    """
    Контроллер интерфейса приложения, отвечает за отправку и получения данных интерфейсом из модели, а также за
    запуск и работу конкретного интерфейса.
    """
    def __init__(self, master, slave):
        super().__init__(master, slave)

    def run_view(self) -> NoReturn:
        """
        Метод, который запускает и поддерживает работу интерфейса приложения.
        """
        while self.slave(self).run():
            pass

    def post(self, request: JSON) -> JSON:
        """
        Метод, который отправляет данные в модель и возвращает код ответа от адресата вызова.
        :param request: Данные в формате JSON.
        :return: Код ответа адресата.
        """
        return JSON(self.master.post(json.dumps(request)))

    def get(self) -> JSON:
        """
        Метод для получения данных от модели.
        :return: JSON, который содержит код ответа адресата и данные из модели, если запрос выполнен успешно.
        """
        return JSON(json.loads(self.master.get()))


@logger
class Controller(AbcController):
    """
    Главный контроллер приложения, осуществляет маршрутизацию от контроллера View к контроллеру Model.
    """
    def __init__(self, view: Any, model: Any):
        super().__init__(ViewController(self, view), ModelController(self, model))

    def post(self, request: JSON) -> JSON:
        """
        Метод, который отправляет данные в модель и возвращает код ответа от адресата вызова.
        :param request: Данные в формате JSON.
        :return: Код ответа адресата.
        """
        return self.slave.post(request)

    def get(self) -> JSON:
        """
        Метод для получения данных от модели.
        :return: JSON, который содержит код ответа адресата и данные из модели, если запрос выполнен успешно.
        """
        return self.slave.get()
