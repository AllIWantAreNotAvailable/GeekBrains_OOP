from Model.VendingMachine import VendingMachine
from Model.Coffee import Coffee
from Model.Tea import Tea


def get_coffee() -> list:
    return [
        Coffee(1, 10, 50, True, 'Egoist', 'Arabic'),
        Coffee(2, 10, 50, True, 'Egoist', 'Arabic'),
        Coffee(3, 10, 50, True, 'Egoist', 'Arabic'),
        Coffee(4, 10, 50, True, 'Egoist', 'Arabic'),
        Coffee(5, 10, 50, True, 'Egoist', 'Arabic')
    ]


def get_tea() -> list:
    return [
        Tea(1, 60, 80, False, True, 'China'),
        Tea(2, 60, 80, False, True, 'China'),
        Tea(3, 60, 80, False, True, 'China'),
        Tea(4, 60, 80, False, True, 'China'),
        Tea(5, 60, 80, False, True, 'China')
    ]


def main():
    coffee_vending = VendingMachine()
    coffee_vending.load_something(get_coffee())
    print(coffee_vending.sell(5))

    tea_vending = VendingMachine()
    tea_vending.load_something(get_tea())
    print(tea_vending.sell(2))


if __name__ == '__main__':
    main()
