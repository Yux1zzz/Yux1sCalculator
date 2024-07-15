import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 计算机GUI类
 * 实现计算机的显示部分
 * */
public class CalculatorGUI extends JFrame {

    private Calculator calculator;

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
        JLabel formulaText = new JLabel("1+1+1");
        formulaText.setBounds(0, 0, 400, 100);
        formulaText.setFont(new Font("myFont", Font.BOLD, 20));

        //各项按钮
        JButton button_delete = createJButton(0, 100, "delete");
        JButton button_squire = createJButton(100, 100, "x²");
        JButton button_root = createJButton(200, 100, "√￣x");
        JButton button_division = createJButton(300, 100, "÷");
        JButton button_seven = createJButton(0, 200, "7");
        JButton button_eight = createJButton(100, 200, "8");
        JButton button_nine = createJButton(200, 200, "9");
        JButton button_multiplication = createJButton(300, 200, "x");
        JButton button_four = createJButton(0, 300, "4");
        JButton button_five = createJButton(100, 300, "5");
        JButton button_six = createJButton(200, 300, "6");
        JButton button_subtraction = createJButton(300, 300, "-");
        JButton button_one = createJButton( 0, 400, "1");
        JButton button_two = createJButton(100, 400, "2");
        JButton button_three = createJButton(200, 400, "3");
        JButton button_add = createJButton(300, 400, "+");
        JButton button_returnZero = createJButton(0, 500, "C");
        JButton button_zero = createJButton( 100, 500, "0");
        JButton button_point = createJButton(200, 500, ".");
        JButton button_equal = createJButton(300, 500, "=");



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

        }
    }

    private JButton createJButton(int x, int y, String text){
        JButton button = new JButton(text);
        button.setBounds(x, y, 95, 95);
        button.setFocusable(false);
        button.setFont(new Font("buttonFont", Font.BOLD, 20));
        return button;
    }

}
