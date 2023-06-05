package Application.Abstract;

import Application.Interface.MathOperations;

public abstract class Calculator implements MathOperations {
    protected double result;
    public Calculator() {
        this.result = 0;
    }

    public abstract Double getResult();
    public abstract Double getResult(double left, String operation, double right) throws Exception;
    public abstract Double getResult(double right, String operation) throws Exception;
}
