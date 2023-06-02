public class Calculator {
    private double num1;
    private double num2;
    private String operation;

    public Calculator(String num1, String num2, String operation) {
        this.num1 = Double.parseDouble(num1);
        this.num2 = Double.parseDouble(num2);
        this.operation = operation
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