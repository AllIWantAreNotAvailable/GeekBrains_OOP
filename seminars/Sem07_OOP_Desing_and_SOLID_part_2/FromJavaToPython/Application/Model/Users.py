from abc import ABC, abstractmethod


class User(ABC):
    last_name: str = None
    first_name: str = None
    patronymic: str = None

    def __init__(self, last_name: str, first_name: str, patronymic: str):
        self.set_last_name(last_name)
        self.set_first_name(first_name)
        self.set_patronymic(patronymic)

    @abstractmethod
    def get_last_name(self) -> str:
        pass

    @abstractmethod
    def set_last_name(self, last_name: str):
        pass

    @abstractmethod
    def get_first_name(self) -> str:
        pass

    @abstractmethod
    def set_first_name(self, first_name: str):
        pass

    @abstractmethod
    def get_patronymic(self) -> str:
        pass

    @abstractmethod
    def set_patronymic(self, patronymic: str):
        pass

    def __str__(self):
        return ('User['
                f'"last name"="{self.get_last_name()}"'
                f', "first name"="{self.get_first_name()}"'
                f', "patronymic"="{self.get_patronymic()}'
                ']')


class UserGroup(ABC):

    group: list = None

    def __init__(self, group):
        self.set_group(group if group and isinstance(group, list) else list())

    @abstractmethod
    def set_group(self, group: list):
        pass

    @abstractmethod
    def get_group(self) -> list:
        pass

    @abstractmethod
    def add(self, value: User) -> None:
        pass

    @abstractmethod
    def remove(self, index: int) -> User:
        pass

    def __len__(self) -> int:
        return len(self.group)

    def __getitem__(self, item):
        return self.group[item]

    def __setitem__(self, key, value):
        self.group[key] = value

    def __delitem__(self, key):
        del self.group[key]

    def __iter__(self):
        return iter(self.group)

    def __reversed__(self):
        return reversed(self.group)


class Worker(User):

    worker_id: str = None

    def __init__(self, worker_id: str, last_name: str, first_name: str, patronymic: str):
        super().__init__(last_name, first_name, patronymic)
        self.set_id(worker_id)

    def get_id(self):
        return self.worker_id

    def set_id(self, worker_id: str):
        self.worker_id = worker_id

    def get_last_name(self) -> str:
        return self.last_name

    def set_last_name(self, last_name: str):
        self.last_name = last_name

    def get_first_name(self) -> str:
        return self.first_name

    def set_first_name(self, first_name: str):
        self.first_name = first_name

    def get_patronymic(self) -> str:
        return self.patronymic

    def set_patronymic(self, patronymic: str):
        self.patronymic = patronymic

    def __str__(self):
        return ('Worker['
                f'"worker id"={self.get_id()}'
                f', "last name"="{self.get_last_name()}"'
                f', "first name"="{self.get_first_name()}"'
                f', "patronymic"="{self.get_patronymic()}'
                ']')


class WorkersGroup(UserGroup):

    def __init__(self, group):
        super().__init__(group)

    def set_group(self, group: list):
        self.group = group

    def get_group(self) -> list:
        return self.group

    def add(self, value: User) -> None:
        self.group.append(value)

    def remove(self, index: int) -> User:
        return self.group.pop(index)

    def __str__(self):
        return f'WorkersGroup{list(map(str, self.get_group()))}'


class Teacher(Worker):

    def __init__(self, worker_id: str, last_name: str, first_name: str, patronymic: str):
        super().__init__(worker_id, last_name, first_name, patronymic)
        pass

    def __str__(self):
        return ('Teacher['
                f'"worker id"={self.get_id()}'
                f', "last name"="{self.get_last_name()}"'
                f', "first name"="{self.get_first_name()}"'
                f', "patronymic"="{self.get_patronymic()}'
                ']')