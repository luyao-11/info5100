package lab6_GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GUI extends JFrame {
    //set basic parameter of frame
    GUI() {
        setTitle("Student Grade Calculator");
        setJPanel();
        setBounds(300, 200, 800, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // set text field to let user enter
    JTextField textField1 = new JTextField(10);
    JTextField textField2 = new JTextField(10);
    JTextField textField3 = new JTextField(10);
    JTextField textField4 = new JTextField(10);

    private void setJPanel() {
        //set container and labels,  add label and text field to the panel
        JPanel panel = new JPanel();
        this.setContentPane(panel);

        JLabel label1 = new JLabel("Total Assignment Points");
        panel.add(label1);
        panel.add(textField1);
        JLabel label2 = new JLabel("Earned  Points");
        panel.add(label2);
        panel.add(textField2);
        JLabel label3 = new JLabel("Percentage of class");
        panel.add(label3);
        panel.add(textField3);

        // add button and it can calculate the grade when click the button,
        JButton button = new JButton("Click to calculate score");
        button.setOpaque(true);
        panel.add(button, BorderLayout.CENTER);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculation();
            }
        });
        JLabel label4 = new JLabel(" Weighted Score");
        panel.add(label4);
        panel.add(textField4);
    }

    public void calculation() {
        // returns the double value by the text field input
        double pointTotal = Double.parseDouble(textField1.getText());
        double earnedPoints = Double.parseDouble(textField2.getText());
        double assignmentPercentage = Double.parseDouble(textField3.getText());

        //create a new object and call method from another class to calculate the score
        WeightedGradeCal gradeCal = new WeightedGradeCal(pointTotal, earnedPoints, assignmentPercentage);
        double totalWeightedGrade = Double.parseDouble(String.valueOf(gradeCal.calculation()));
        textField4.setText (String.valueOf(totalWeightedGrade));
    }
}