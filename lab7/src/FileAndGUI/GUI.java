package FileAndGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class GUI extends JFrame {
    public static void placeComponents(JPanel panel) {

        //set basic element in the panel
        JLabel label1 = new JLabel("Reading File Name");
        JTextField textField1 = new JTextField("/Users/luyaowang/annual.csv");
        JButton button1 = new JButton("Click to read the file");
        JLabel label2 = new JLabel("First five lines of file:");
        JTextArea textArea1 = new JTextArea();

        //add element of reading part into panel
        panel.setLayout(null);
        panel.add(label1);
        label1.setForeground(Color.blue);
        label1.setBounds(20, 20, 350, 30);
        panel.add(textField1);
        textField1.setBounds(20,50,350,30);
        panel.add(button1);
        button1.setForeground(Color.red);
        button1.setBounds(20, 80, 350, 30);
        panel.add(label2);
        label2.setBounds(20, 150, 350, 30);
        panel.add(textArea1);
        textArea1.setBounds(20, 180, 350, 200);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                ReadAndWriteFile fileRead = new ReadAndWriteFile();
                String path = textField1.getText();

                ArrayList content = fileRead.readFile(path);
                textArea1.setText(content.get(0)+"\n"+content.get(1)+"\n"+content.get(2)+"\n"+content.get(3)+"\n"+content.get(4)
                );
            }
        });

        ////add element of writing part into panel
        JLabel label3 = new JLabel("File name to write ");
        JTextField textField2 = new JTextField("<user input>");
        JButton button2 = new JButton("Click to write to file");
        JLabel label4 = new JLabel("First five lines of file");
        JTextArea textArea2 = new JTextArea();

        panel.add(label3);
        label3.setForeground(Color.blue);
        label3.setBounds(500, 20, 350, 30);
        panel.add(textField2);
        textField2.setBounds(500,50,350,30);
        panel.add(button2);
        button2.setForeground(Color.red);
        button2.setBounds(500, 80, 350, 30);
        panel.add(label4);
        label4.setBounds(500, 150, 350, 30);
        panel.add(textArea2);
        textArea2.setBounds(500, 180, 350, 200);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }

        });


    }
}

