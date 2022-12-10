import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame implements ActionListener {
    //Define various controls
    private JLabel labelAccount = new JLabel("Your account:");
    private JTextField inputAccount = new JTextField(10);
    private JLabel labelPassword = new JLabel("Your password:");
    private JPasswordField inputPassword = new JPasswordField(10);
    private JLabel labelPassword1 = new JLabel("Confirm password:");
    private JPasswordField inputPassword1 = new JPasswordField(10);
    private JLabel labelEmail = new JLabel("Your email:");
    private JTextField inputEmail = new JTextField(10);
    private JLabel gender = new JLabel("Your gender");
    private JRadioButton gender1 = new JRadioButton("male",true);
    private JRadioButton gender2 = new JRadioButton("female",false);
    private ButtonGroup genderBnt = new ButtonGroup();
    private JButton register = new JButton("Register");
    private JButton back = new JButton("Back");

    //Set register interface
    public Register(){
        super("Register");
        this.setLayout(new FlowLayout());
        this.add(labelAccount);
        this.add(inputAccount);
        this.add(labelPassword);
        this.add(inputPassword);
        this.add(labelPassword1);
        this.add(inputPassword1);
        this.add(labelEmail);
        this.add(inputEmail);
        genderBnt.add(gender1);
        genderBnt.add(gender2);
        this.add(gender);
        this.add(gender1);
        this.add(gender2);
        this.add(register);
        this.add(back);
        this.add(register);
        this.add(back);
        this.setSize(280,250);
        toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        //add action listener for two buttons to achieve goals
        register.addActionListener(this);
        back.addActionListener(this);
    }

    //take action according to the button pressed
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==register) {
            String password = new String(inputPassword.getPassword());
            String password1 = new String(inputPassword.getPassword());
            if (!password.equals(password1)) {
                JOptionPane.showMessageDialog(this, "Passwords not match！");
                return;
            }
            String account = inputAccount.getText();
            String email = inputEmail.getText();
            String gender;
            if (gender1.isSelected())
                gender = (String) gender1.getText();
            else
                gender = (String) gender2.getText();

            Save.account = account;
            Save.password = password;
            JOptionPane.showMessageDialog(this,account +"(" + gender + ";" + email + ")"+ " has registered successfully!");
            this.dispose();
            new Login();
        }else if(e.getSource()==back){
            this.dispose();
            new Login();
        }
    }

    //keep the interface in the center of the screen
    public static void toCenter(Component comp){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle rec = ge.getDefaultScreenDevice().getDefaultConfiguration().getBounds();
        comp.setLocation(((int)rec.getWidth()-comp.getWidth())/2,((int)rec.getHeight()-comp.getHeight())/2);
    }
}

