public class Calculator {
    private String currentOperand = "";
    private String previousOperand = "";
    private String operation = "";

    public void compute() {
        if (this.currentOperand.equals("") || this.previousOperand.equals("")) {
            return;
        }

        try {
            Calculation calculation = new Calculation.Builder()
                    .setOperand1(this.previousOperand)
                    .setOperand2(this.currentOperand)
                    .setOperator(this.operation)
                    .build();

            this.currentOperand = calculation.compute();
        } catch (Exception e) {
            this.clear();
            this.currentOperand = "Error";
        }

        this.previousOperand = "";
        this.operation = "";
    }

    public void clear() {
        this.previousOperand = "";
        this.currentOperand = "";
        this.operation = "";
    }
}