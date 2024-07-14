public class CalculatorEntry {

    //程序运行入口
    public static void main(String[] args) {
        Calculator calculator = new Calculator(10, 10);
        CalculatorGUI calculatorGUI = new CalculatorGUI("Yux1's Calculator", calculator);
    }
}
