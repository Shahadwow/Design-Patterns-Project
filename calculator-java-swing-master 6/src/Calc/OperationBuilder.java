package Calc;

// Builder Pattern for Operations
public class OperationBuilder {
    private String operand1;
    private String operand2;
    private String operator;

    // ... (setters remain the same) ...

    public OperationBuilder setOperand1(String operand1) {
        this.operand1 = operand1;
        return this;
    }

    public OperationBuilder setOperand2(String operand2) {
        this.operand2 = operand2;
        return this;
    }

    public OperationBuilder setOperator(String operator) {
        this.operator = operator;
        return this;
    }

    public String buildAndCompute() {
        if (operator == null) {
            throw new IllegalArgumentException("Operator cannot be null");
        }

        float op1, op2;
        float result;
        Operation operationInstance; // 👈 المتغير الذي سيحمل كائن العملية الحقيقي

        // 1. مرحلة التحقق والتحويل (Preprocessing & Validation)
        // --------------------------------------------------------
        if (operator.equals("√")) {
            if (operand1 == null) {
                throw new IllegalArgumentException("Missing operand for sqrt");
            }
            op1 = Float.parseFloat(operand1);
            op2 = 0; // يتم تعيينه إلى صفر كقيمة افتراضية
            
            // 💡 ملاحظة: يجب إضافة كلاس SqrtOperation جديد للتعامل مع هذا
            operationInstance = new SqrtOperation(); 

        } else {
            // التعامل مع العمليات الثنائية
            if (operand1 == null || operand2 == null) {
                throw new IllegalArgumentException("Operands cannot be null");
            }
            op1 = Float.parseFloat(operand1);
            op2 = Float.parseFloat(operand2);
            
            // 2. مرحلة المصنع (Factory Decision)
            // ------------------------------------
            switch (operator) {
                case "+": operationInstance = new AddOperation(); break;
                case "-": operationInstance = new SubtractOperation(); break;
                case "×": operationInstance = new MultiplyOperation(); break;
                case "÷": operationInstance = new DivideOperation(); break;
                case "^": operationInstance = new PowerOperation(); break; // افتراض وجود PowerOperation
                default:
                    throw new IllegalArgumentException("Unknown operation: " + operator);
            }
        }

        // 3. التنفيذ (Execution)
        // -----------------------
        // يتم الآن استدعاء الدالة execute() على الكائن الحقيقي
        result = operationInstance.execute(op1, op2);

        // 4. معالجة الأخطاء والتنسيق (Error Handling & Formatting)
        // -------------------------------------------------------
        // (يجب أن يتم التعامل مع الأخطاء التي تطلقها execute() في try/catch بـ CalculationEngine)
        
        return formatResult(result);
    }

    private String formatResult(float result) {
        return (result - (int) result) != 0 ?
                Float.toString(result) : Integer.toString((int) result);
    }
}