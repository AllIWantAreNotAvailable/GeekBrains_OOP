package Application.Interface;

public interface MathOperations {
    Double add(double left, double right);
    Double add(double right);
    Double subtract(double left, double right);
    Double subtract(double right);
    Double multiply(double left, double right);
    Double multiply(double right);
    Double divide(double left, double right);
    Double divide(double right);
    Integer integerDivision(double left, double right) throws Exception;
    Integer integerDivision(double right) throws Exception;
    Integer remainderDivision(double left, double right) throws Exception;
    Integer remainderDivision(double right) throws Exception;
    Double exponent(double base, double exponent);
    Double exponent(double exponent);
}
