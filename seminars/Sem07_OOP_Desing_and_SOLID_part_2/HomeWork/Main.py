from Application import *


def main():
    controller = MainController()
    controller.get_view()['__ComplexCalculatorView__'].run()


def test():
    request = dict(left=str(complex('3+1j')),
                   operation='+',
                   right=str(complex('4+2j'))
                   )
    # request = json.dumps(request)
    # service = CalculatorService(request, ComplexCalculator)
    # print('{left} {operation} {right} = {result}'.format(**json.loads(service.get_result())))


if __name__ == '__main__':
    main()
