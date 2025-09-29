package Stage1FactoryMethod;
import java.util.Scanner;

interface Operation {
    float execute(float prev, float curr);
}

class AddOperation implements Operation {
    public float execute(float prev, float curr) {
        return prev + curr;
    }
}

class SubtractOperation implements Operation {
    public float execute(float prev, float curr) {
        return prev - curr;
    }
}

class MultiplyOperation implements Operation {
    public float execute(float prev, float curr) {
        return prev * curr;
    }
}

class DivideOperation implements Operation {
    public float execute(float prev, float curr) {
        if (curr == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return prev / curr;
    }
}

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

public class Calculator {

    private String currentOperand;
    private String previousOperand;
    private String operation;

    public void compute() {
        if (this.currentOperand.equals("") || this.previousOperand.equals("")) {
            return;
        }

        float curr = Float.parseFloat(this.currentOperand);
        float prev = Float.parseFloat(this.previousOperand);

        if (Float.isNaN(curr) || Float.isNaN(prev)) {
            return;
        }

        Operation op = OperationFactory.createOperation(this.operation);
        float computation = op.execute(prev, curr);

        this.currentOperand = (computation - (int) computation) != 0 ? Float.toString(computation) : Integer.toString((int) computation);
        this.previousOperand = "";
        this.operation = "";
    }
    
    

    // A method for user to enter numbers
    public void setOperands(String previousOperand, String currentOperand, String operation) {
        this.previousOperand = previousOperand;
        this.currentOperand = currentOperand;
        this.operation = operation;
    }

    // A method to show results
    public String getResult() {
        return this.currentOperand;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        
        System.out.print("Enter first number: ");
        String firstNum = scanner.nextLine();

        System.out.print("Enter operation (+, -, ×, ÷): ");
        String operator = scanner.nextLine();

        System.out.print("Enter second number: ");
        String secondNum = scanner.nextLine();

        calculator.setOperands(firstNum, secondNum, operator);
        calculator.compute();
        System.out.println("Result: " + calculator.getResult());
    }
}
