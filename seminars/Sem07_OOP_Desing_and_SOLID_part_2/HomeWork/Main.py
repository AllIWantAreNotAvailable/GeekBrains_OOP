from Application import *


def main():
    # Initializing controller:
    controller = MainController()
    # Initializing model and view:
    mode_controller = CalculatorModelController(controller, ComplexCalculatorModel)
    view_controller = CalculatorViewController(controller, ComplexCalculatorView)
    # Setting dependencies:
    controller.set_model(mode_controller)
    controller.set_view(view_controller)
    # Running program
    controller.run()


if __name__ == '__main__':
    main()
