from Application.Models.Model import CalculatorService, ComplexCalculator

import json


def main():
    request = dict(left=str(complex('3+1j')),
                   operation='+',
                   right=str(complex('4+2j'))
                   )

    request = json.dumps(request)

    service = CalculatorService(request, ComplexCalculator)
    print('{left} {operation} {right} = {result}'.format(**json.loads(service.get_result())))


if __name__ == '__main__':
    main()
