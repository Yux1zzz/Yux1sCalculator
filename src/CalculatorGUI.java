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
        JLabel formulaText = new JLabel(new ImageIcon(setImage("src/assets/background.png", 390, 90)), SwingConstants.LEFT);
        formulaText.setBounds(0, 0, 400, 100);
        formulaText.setFont(new Font("myFont", Font.BOLD, 20));

        //各项按钮
        JButton button_delete = createJButton("src/assets/delete.png", 0, 100);
        JButton button_squire = createJButton("src/assets/squire.png", 100, 100);
        JButton button_root = createJButton("src/assets/root.png", 200, 100);
        JButton button_division = createJButton("src/assets/division.png", 300, 100);
        JButton button_seven = createJButton("src/assets/seven.png", 0, 200);
        JButton button_eight = createJButton("src/assets/eight.png", 100, 200);
        JButton button_nine = createJButton("src/assets/nine.png", 200, 200);
        JButton button_multiplication = createJButton("src/assets/multiplication.png", 300, 200);
        JButton button_four = createJButton("src/assets/four.png", 0, 300);
        JButton button_five = createJButton("src/assets/five.png", 100, 300);
        JButton button_six = createJButton("src/assets/six.png", 200, 300);
        JButton button_subtraction = createJButton("src/assets/subtraction.png", 300, 300);
        JButton button_one = createJButton("src/assets/one.png", 0, 400);
        JButton button_two = createJButton("src/assets/two.png", 100, 400);
        JButton button_three = createJButton("src/assets/three.png", 200, 400);
        JButton button_add = createJButton("src/assets/add.png", 300, 400);
        JButton button_returnZero = createJButton("src/assets/return_zero.png", 0, 500);
        JButton button_zero = createJButton("src/assets/zero.png", 100, 500);
        JButton button_point = createJButton("src/assets/point.png", 200, 500);
        JButton button_equal = createJButton("src/assets/equal.png", 300, 500);



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

    private JButton createJButton(String iconFile, int x, int y){
        JButton button = new JButton(new ImageIcon(setImage(iconFile, 90, 90)));
        button.setBounds(x, y, 95, 95);
        return button;
    }

    private Image setImage(String file, int width, int height){
        try {
            File inputFile = new File(file);
            BufferedImage bufferedImage = ImageIO.read(inputFile);
            return bufferedImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
