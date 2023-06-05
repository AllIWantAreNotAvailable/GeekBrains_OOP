package Application.Objects;

import Application.Abstract.Calculator;

public class SimpleCalculator extends Calculator {
    public SimpleCalculator() {
        super();
    }

    @Override
    public Double getResult() {
        return super.result;
    }

    @Override
    public Double getResult(double left, String operation, double right) throws Exception {
        return switch (operation) {
            case "+" -> add(left, right);
            case "-" -> subtract(left, right);
            case "*", "x" -> multiply(left, right);
            case "/" -> divide(left, right);
            case "^" -> exponent(left, right);
            default -> throw new Exception("No such operation exception");
        };
    }

    @Override
    public Double getResult(double right, String operation) throws Exception {
        return getResult(super.result, operation, right);
    }

    @Override
    public Double add(double left, double right) {
        super.result = left + right;
        return super.result;
    }

    @Override
    public Double add(double right) {
        return add(super.result, right);
    }

    @Override
    public Double subtract(double left, double right) {
        super.result = left - right;
        return super.result;
    }

    @Override
    public Double subtract(double right) {
        return subtract(super.result, right);
    }

    @Override
    public Double multiply(double left, double right) {
        super.result = left * right;
        return super.result;
    }

    @Override
    public Double multiply(double right) {
        return multiply(super.result, right);
    }

    @Override
    public Double divide(double left, double right) {
        super.result = left / right;
        return super.result;
    }

    @Override
    public Double divide(double right) {
        return divide(super.result, right);
    }

    @Override
    public Double exponent(double base, double exponent) {
        super.result = 1;
        for (int i = 0; i < exponent; i++) {
            super.result *= base;
        }
        return super.result;
    }

    @Override
    public Double exponent(double exponent) {
        return exponent(super.result, exponent);
    }

    @Override
    public Integer integerDivision(double left, double right) throws Exception {
        throw new Exception("No such operation exception");
    }

    @Override
    public Integer integerDivision(double right) throws Exception {
        throw new Exception("No such operation exception");
    }

    @Override
    public Integer remainderDivision(double left, double right) throws Exception {
        throw new Exception("No such operation exception");
    }

    @Override
    public Integer remainderDivision(double right) throws Exception {
        throw new Exception("No such operation exception");
    }
}
