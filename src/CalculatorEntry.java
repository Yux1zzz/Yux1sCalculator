public class CalculatorEntry {

    //程序运行入口
    public static void main(String[] args) {
        Calculator calculator = new Calculator(20, 20);
        CalculatorGUI calculatorGUI = new CalculatorGUI("Yux1's Calculator", calculator);
        calculatorGUI.run();

    }
}
