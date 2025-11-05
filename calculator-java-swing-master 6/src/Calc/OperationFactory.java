package Calc;

class OperationFactory {

    public static Operation createOperation(String operator) {
        switch (operator) {
            case "+": return new AddOperation();
            case "-": return new SubtractOperation();
            case "×": return new MultiplyOperation();
            case "÷": return new DivideOperation();
            default: throw new IllegalArgumentException("Unknown operation: " + operator);
        }
    }
}