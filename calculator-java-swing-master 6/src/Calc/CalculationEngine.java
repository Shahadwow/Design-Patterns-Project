package Calc;

// Pure business logic - NO UI
class CalculationEngine {
    private String currentOperand = "";
    private String previousOperand = "";
    private String operation = "";
    
    public void appendNumber(String number) {
        if (this.currentOperand.equals("0") && number.equals("0")) {
            return;
        }

        if (number.equals(".") && this.currentOperand.contains(".")) {
            return;
        }

        if (this.currentOperand.equals("0")
                && !number.equals("0")
                && !number.equals(".")) {
            this.currentOperand = "";
        }

        this.currentOperand += number;
    }
    
    public void chooseOperation(String operation) {
        if (this.currentOperand.equals("") && !this.previousOperand.equals("")) {
            this.operation = operation;
        }
        if (this.currentOperand.equals("")) {
            return;
        }

        if (!this.previousOperand.equals("")) {
            this.compute();
        }

        this.operation = operation;
        this.previousOperand = this.currentOperand;
        this.currentOperand = "";
    }
    
    public void compute() {
        if (this.currentOperand.equals("") || this.previousOperand.equals("")) {
            return;
        }

        try {
            // USING BUILDER PATTERN HERE
            OperationBuilder builder = new OperationBuilder()
                .setOperand1(this.previousOperand)
                .setOperand2(this.currentOperand)
                .setOperator(this.operation);
            
            this.currentOperand = builder.buildAndCompute();
        } catch (ArithmeticException e) {
            this.clear();
            this.currentOperand = "Error";
            return;
        } catch (IllegalArgumentException e) {
            return;
        }

        this.previousOperand = "";
        this.operation = "";
    }
    
    // ADD THIS NEW METHOD for square root operation
    public void computeSqrt() {
        if (this.currentOperand.equals("")) {
            return;
        }

        try {
            // USING BUILDER PATTERN FOR SQUARE ROOT
            OperationBuilder builder = new OperationBuilder()
                .setOperand1(this.currentOperand)
                .setOperator("√");
            
            this.currentOperand = builder.buildAndCompute();
        } catch (ArithmeticException | IllegalArgumentException e) {
            this.currentOperand = "Error";
        }
    }
    
    // ADD THIS NEW METHOD for power operation
    public void choosePowerOperation() {
        this.chooseOperation("^");
    }
    
    public void clear() {
        this.currentOperand = "";
        this.previousOperand = "";
        this.operation = "";
    }
    
    public void deleteLast() {
        if (!this.currentOperand.equals("")) {
            this.currentOperand = this.currentOperand.substring(0, this.currentOperand.length() - 1);
        }
    }
    
    public void toggleSign() {
        if (!this.currentOperand.isBlank() && !this.currentOperand.equals("Error")) {
            float tmp = -Float.parseFloat(this.currentOperand);
            this.currentOperand = (tmp - (int) tmp) != 0 ? 
                Float.toString(tmp) : Integer.toString((int) tmp);
        }
    }
    
    public void addDot() {
        if (this.currentOperand.isBlank()) {
            this.currentOperand = "0.";
        } else if (!this.currentOperand.contains(".")) {
            this.currentOperand += ".";
        }
    }
    
    // Getters for display
    public String getCurrent() { return currentOperand; }
    public String getPreviousWithOperation() { 
        return previousOperand + " " + operation; 
    }
    public String getOperation() { return operation; }
}