
package Calc;

// Coordinates between engine and display
class InputHandler {
    private CalculationEngine engine;
    private DisplayManager display;
    
    public InputHandler(CalculationEngine engine, DisplayManager display) {
        this.engine = engine;
        this.display = display;
    }
    
    public void handleNumber(String number) {
        engine.appendNumber(number);
        updateDisplay();
    }
    
    public void handleOperation(String operation) {
        engine.chooseOperation(operation);
        updateDisplay();
    }
    
    public void handleEquals() {
        engine.compute();
        updateDisplay();
        if (engine.getCurrent().equals("Error")) {
            engine.clear();
        }
    }
    
    public void handleClear() {
        engine.clear();
        updateDisplay();
    }
    
    public void handleDelete() {
        engine.deleteLast();
        updateDisplay();
    }
    
    public void handlePlusMinus() {
        engine.toggleSign();
        updateDisplay();
    }
    
    public void handleDot() {
        engine.addDot();
        updateDisplay();
    }
    
    private void updateDisplay() {
        display.updateDisplay(engine.getCurrent(), engine.getPreviousWithOperation());
    }
}