import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 计算机GUI类
 * 实现计算机的显示部分
 * */
public class CalculatorGUI extends JFrame {

    private Calculator calculator;

    //先把按钮创建好方便使用
    JLabel formulaText;
    JButton button_delete;
    JButton button_squire;
    JButton button_root;
    JButton button_division;
    JButton button_seven;
    JButton button_eight;
    JButton button_nine;
    JButton button_multiplication;
    JButton button_four;
    JButton button_five;
    JButton button_six;
    JButton button_subtraction;
    JButton button_one;
    JButton button_two ;
    JButton button_three;
    JButton button_add;
    JButton button_returnZero;
    JButton button_zero;
    JButton button_point;
    JButton button_equal;

    public CalculatorGUI(String title, Calculator calculator){
        //对本身JFrame的设置
        super(title);
        setVisible(true);
        setSize(410, 635);
        setLocation(650, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //传入Calculator
        this.calculator = calculator;

        //设置布局
        setLayout(null);

        //设置各项组件
        //显示算式的标签
        formulaText = new JLabel("");
        formulaText.setBounds(0, 0, 400, 100);
        formulaText.setFont(new Font("myFont", Font.BOLD, 20));

        //各项按钮
        button_delete = createJButton(0, 100, "delete");
        button_delete.addActionListener(new DeleteButtonEvent());
        button_squire = createJButton(100, 100, "x²");
        button_squire.addActionListener(new SquireButtonEvent());
        button_root = createJButton(200, 100, "√￣x");
        button_root.addActionListener(new RootButtonEvent());
        button_division = createJButton(300, 100, "÷");
        button_division.addActionListener(new DivisionButtonEvent());
        button_seven = createJButton(0, 200, "7");
        button_seven.addActionListener(new SevenButtonEvent());
        button_eight = createJButton(100, 200, "8");
        button_eight.addActionListener(new EightButtonEvent());
        button_nine = createJButton(200, 200, "9");
        button_nine.addActionListener(new NineButtonEvent());
        button_multiplication = createJButton(300, 200, "x");
        button_multiplication.addActionListener(new MultiplicationButtonEvent());
        button_four = createJButton(0, 300, "4");
        button_four.addActionListener(new FourButtonEvent());
        button_five = createJButton(100, 300, "5");
        button_five.addActionListener(new FiveButtonEvent());
        button_six = createJButton(200, 300, "6");
        button_six.addActionListener(new SixButtonEvent());
        button_subtraction = createJButton(300, 300, "-");
        button_subtraction.addActionListener(new SubtractionButtonEvent());
        button_one = createJButton( 0, 400, "1");
        button_one.addActionListener(new OneButtonEvent());
        button_two = createJButton(100, 400, "2");
        button_two.addActionListener(new TwoButtonEvent());
        button_three = createJButton(200, 400, "3");
        button_three.addActionListener(new ThreeButtonEvent());
        button_add = createJButton(300, 400, "+");
        button_add.addActionListener(new AddButtonEvent());
        button_returnZero = createJButton(0, 500, "C");
        button_returnZero.addActionListener(new ReturnZeroButtonEvent());
        button_zero = createJButton( 100, 500, "0");
        button_zero.addActionListener(new ZeroButtonEvent());
        button_point = createJButton(200, 500, ".");
        button_point.addActionListener(new PointButtonEvent());
        button_equal = createJButton(300, 500, "=");
        button_equal.addActionListener(new EqualButtonEvent());



        //添加各项组件
        Container container = getContentPane();
        container.add(formulaText);
        container.add(button_delete);
        container.add(button_squire);
        container.add(button_root);
        container.add(button_division);
        container.add(button_seven);
        container.add(button_eight);
        container.add(button_nine);
        container.add(button_multiplication);
        container.add(button_four);
        container.add(button_five);
        container.add(button_six);
        container.add(button_subtraction);
        container.add(button_one);
        container.add(button_two);
        container.add(button_three);
        container.add(button_add);
        container.add(button_returnZero);
        container.add(button_zero);
        container.add(button_point);
        container.add(button_equal);




    }

    public void run(){
        while (true){
            formulaText.setText(calculator.getFormula());
        }
    }

    //创建按钮的方法
    private JButton createJButton(int x, int y, String text){
        JButton button = new JButton(text);
        button.setBounds(x, y, 95, 95);
        button.setFocusable(false);
        button.setFont(new Font("buttonFont", Font.BOLD, 20));
        return button;
    }

    //删除一个字符
    class DeleteButtonEvent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculator.formulaDelete();
            System.out.println("删除");
        }
    }

    //计算结果并求平方
    class SquireButtonEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!calculator.isEmpty()){
                float result = calculator.calculate(calculator.getFormula());
                result = (float) Math.pow(result, 2);
                calculator.setFormula(Float.toString(result));
            }
        }
    }

    //计算结果并求根号
    class RootButtonEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!calculator.isEmpty()){
                float result = calculator.calculate(calculator.getFormula());
                result = (float) Math.sqrt(result);
                calculator.setFormula(Float.toString(result));
            }
        }
    }

    //除
    class DivisionButtonEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculator.setFormula(calculator.getFormula() + "/");
        }
    }

    //7
    class SevenButtonEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculator.setFormula(calculator.getFormula() + "7");
        }
    }

    //8
    class EightButtonEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculator.setFormula(calculator.getFormula() + "8");
        }
    }

    //9
    class NineButtonEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculator.setFormula(calculator.getFormula() + "9");
        }
    }

    //*
    class MultiplicationButtonEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculator.setFormula(calculator.getFormula() + "*");
        }
    }

    //4
    class FourButtonEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculator.setFormula(calculator.getFormula() + "4");
        }
    }

    //5
    class FiveButtonEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculator.setFormula(calculator.getFormula() + "5");
        }
    }

    //6
    class SixButtonEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculator.setFormula(calculator.getFormula() + "6");
        }
    }

    //-
    class SubtractionButtonEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculator.setFormula(calculator.getFormula() + "-");
        }
    }

    //1
    class OneButtonEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculator.setFormula(calculator.getFormula() + "1");
        }
    }

    //2
    class TwoButtonEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculator.setFormula(calculator.getFormula() + "2");
        }
    }

    //3
    class ThreeButtonEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculator.setFormula(calculator.getFormula() + "3");
        }
    }

    //+
    class AddButtonEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculator.setFormula(calculator.getFormula() + "+");
        }
    }

    //归零
    class ReturnZeroButtonEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculator.setFormula("");
        }
    }

    //0
    class ZeroButtonEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculator.setFormula(calculator.getFormula() + "0");
        }
    }

    //小数点
    class PointButtonEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculator.setFormula(calculator.getFormula() + ".");
        }
    }

    //=
    class EqualButtonEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            calculator.setFormula(String.valueOf(calculator.calculate(calculator.getFormula())));
        }
    }
}

