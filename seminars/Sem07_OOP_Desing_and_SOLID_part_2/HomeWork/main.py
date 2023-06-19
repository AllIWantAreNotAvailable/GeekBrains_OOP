from Application import *

import json


def main():
    controller = Controller(None, ComplexCalculator)
    controller.post(json.dumps(dict(left='1+2j', operation='+', right='2+1j')))
    print(controller.get())


if __name__ == '__main__':
    main()