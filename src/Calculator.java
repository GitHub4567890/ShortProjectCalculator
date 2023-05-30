public class Calculator {
    private double num1;
    private double num2;
    private String operation;

    public Calculator(String num1, String num2, String operation) {
        this.num1 = Double.parseDouble(num1);
        this.num2 = Double.parseDouble(num2);
        this.operation = operation;
    }

    public String getEquation() {
        return Double.toString(num1) + operation + Double.toString(num2) + "=" + calculate();
    }

    public String getNum1() {
        return Double.toString(num1);
    }

    public String getNum2() {
        return Double.toString(num2);
    }

    public String getOperation() {
        return operation;
    }

    public double calculate() {
        if (operation.equals("/")) {
            return num1 / num2;
        } else if (operation.equals("x")) {
            return num1 * num2;
        } else if (operation.equals("-")) {
            return num1 - num2;
        } else {
            return num1 + num2;
        }
    }
}