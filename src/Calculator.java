/**
 * 计算机主类
 * 实现计算的逻辑部分
 * */
public class Calculator {

    //计算机存储计算的算式
    private String formula;
    //计算机所自带的数字栈与运算符栈
    private NumberStack numberStack;
    private OperatorStack operatorStack;

    public Calculator(int numberStackMaxSize, int operatorStackMaxSize){
        //初始化数字栈与运算符栈
        this.numberStack = new NumberStack(numberStackMaxSize);
        this.operatorStack = new OperatorStack(operatorStackMaxSize);
        //初始化字符串
        formula = "";
    }


    public float calculate(String formula){
        if (formula != null){
            //用于暂存数字的字符数组
            char[] numberChar = new char[10];
            int pointer = 0;

            //遍历字符串
            for (int i = 0; i < formula.length(); i++){
                if (isOperator(formula.charAt(i))){
                    //如果字符数组内存有数字则存栈且清空数组
                    if (pointer != 0){
                        numberStack.push(charArrayToFloat(numberChar));
                        numberChar = new char[10];
                        pointer = 0;
                    }

                    if (operatorStack.isEmpty()){
                        operatorStack.push(formula.charAt(i));
                    }
                    else {
                        if (compareOperator(operatorStack.getOperator(), formula.charAt(i))){
                            operatorStack.push(formula.charAt(i));
                        }
                        else {
                            char operator = operatorStack.pop();
                            float int02 = numberStack.pop();
                            float int01 = numberStack.pop();
                            numberStack.push(simpleCalculate(int01, int02, operator));
                            operatorStack.push(formula.charAt(i));
                        }
                    }
                }
                else{
                    numberChar[pointer] = formula.charAt(i);
                    pointer++;
                }
            }
            //可能字符数组里还剩有数字，存栈
            if (pointer != 0){
                numberStack.push(charArrayToFloat(numberChar));
            }
            int counter = operatorStack.getSize();
            for (int i = 0; i < counter; i++){
                char operator = operatorStack.pop();
                float int02 = numberStack.pop();
                float int01 = numberStack.pop();
                numberStack.push(simpleCalculate(int01, int02, operator));
            }
            return numberStack.pop();
        }
        else {
            return 0;
        }
    }

    public void formulaDelete(){
        if (!formula.isEmpty()) {
            formula = formula.substring(0, formula.length() - 1);
        }
    }

    //简单的计算函数
    private float simpleCalculate(float int01, float int02, char operator){
        if (operator == '+'){
            return int01 + int02;
        }
        else if (operator == '-'){
            return int01 - int02;
        }
        else if (operator == '*'){
            return int01 * int02;
        }
        else if (operator == '/'){
            return int01 / int02;
        }
        else {
            throw new RuntimeException("未知错误！！www");
        }
    }

    //将字符数组内存储内容转化为数字
    private float charArrayToFloat(char[] c){
        return Float.parseFloat(new String(c));
    }

    //判断字符是否属于运算符
    private boolean isOperator(char c){
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    //返回第二个运算符的优先级是否高于第一个运算符
    private boolean compareOperator(char a, char b){
        return (b == '*' || b == '/') && (a == '+' || a == '-');
    }



    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public boolean isEmpty(){
        return formula.isEmpty();
    }
}

/**
 * 存放数字的栈
 * */
class NumberStack{
    int head;
    float[] array;
    int maxSize;

    public NumberStack(int maxSize){
        this.head = 0;
        this.maxSize = maxSize;
        this.array = new float[maxSize];
    }

    public void push(float a){
        if (isFull()){
            return;
        }
        else {
            array[head] = a;
            head++;
        }
    }

    public float pop(){
        if (isEmpty()){
            throw new RuntimeException("数栈为空，不能取出数据");
        }
        else {
            head--;
            return array[head];
        }
    }


    public boolean isFull(){
        return head == maxSize;
    }

    public boolean isEmpty(){
        return head == 0;
    }
}

/**
 * 存放运算符的栈
 * */
class OperatorStack{
    int head;
    char[] array;
    int maxSize;

    public OperatorStack(int maxSize){
        this.head = 0;
        this.maxSize = maxSize;
        this.array = new char[maxSize];
    }

    public void push(char a){
        if (isFull()){
            return;
        }
        else {
            array[head] = a;
            head++;
        }
    }

    public char pop(){
        if (isEmpty()){
            throw new RuntimeException("符号栈为空，不能取出数据");
        }
        else {
            head--;
            return array[head];
        }
    }

    public char getOperator(){
        if (isEmpty()){
            throw new RuntimeException("符号栈为空，不能读取数据");
        }
        else {
            return array[head - 1];
        }
    }

    public int getSize(){
        return head;
    }

    public boolean isFull(){
        return head == maxSize;
    }

    public boolean isEmpty(){
        return head == 0;
    }
}
