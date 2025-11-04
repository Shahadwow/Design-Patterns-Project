
package Calc;

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
