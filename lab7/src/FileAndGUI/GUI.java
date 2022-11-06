package FileAndGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI {
    String[] show;
    GUI() {
        JFrame frame = new JFrame("Read and Write file");
        frame.setBounds(300, 200, 900, 500);
        //create and add panel
        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set basic element in the panel
        JLabel label1 = new JLabel("Reading File Name");
        JTextField textField1 = new JTextField("/Users/luyaowang/annual.csv");
        JButton button1 = new JButton("Click to read the file");
        JLabel label2 = new JLabel("First five lines of file:");
        JTextArea textArea1 = new JTextArea();

        //add elements of reading part into panel and set reading part layout 
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

        //show the content of read method 
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputFileName = textField1.getText();
                ReadAndWriteFile read = new ReadAndWriteFile();
                try {
                    show = read.readFile(inputFileName);
                    textArea1.setText(show[0]);
                } catch (Exception c) {
                    c.printStackTrace();
                }
            }
        });

        //add element of writing part into panel
        JLabel label3 = new JLabel("File name to write ");
        JTextField textField2 = new JTextField("<user input>");
        JButton button2 = new JButton("Click to write to file");
        JLabel label4 = new JLabel("First five lines of file");
        JTextArea textArea2 = new JTextArea();
        
        //and element of writing part into panel and set writing part layout 
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
        
        //write out three field of first five line
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReadAndWriteFile writeFile = new ReadAndWriteFile();
                textArea2.setText(show[1]);
                writeFile.write(textField2.getText(), show[1]);
            }
        });
    }
}

