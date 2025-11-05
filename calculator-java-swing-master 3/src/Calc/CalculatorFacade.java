
package Calc;



public class CalculatorFacade {
    private CalculationEngine engine;
    private DisplayManager display;
    private InputHandler input;
    
    public CalculatorFacade() {
        this.engine = new CalculationEngine();
        this.display = new DisplayManager();
        this.input = new InputHandler(engine, display);
    }
    
    public void pressNumber(String number) {
        input.handleNumber(number);
    }
    
    public void pressOperation(String operation) {
        input.handleOperation(operation);
    }
    
    public void pressEquals() {
        input.handleEquals();
    }
    
    public void pressClear() {
        input.handleClear();
    }
    
    public void pressDelete() {
        input.handleDelete();
    }
    
    public void pressPlusMinus() {
        input.handlePlusMinus();
    }
    
    public void pressDot() {
        input.handleDot();
    }
    
    public javax.swing.JPanel getView() {
        return display.getView();
    }
}