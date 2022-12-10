import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    //Define various controls
    private JLabel labelAccount = new JLabel("Your account:");
    private JTextField inputAccount = new JTextField(10);
    private JLabel labelPassword = new JLabel("Your password:");
    private JPasswordField inputPassword = new JPasswordField(10);
    private JButton login = new JButton("Login");
    private JButton register = new JButton("Register");
    private JButton exit = new JButton("Exit");

    //Set login interface
    public Login() {
        super("Login");
        this.setLayout(new FlowLayout());
        this.add(labelAccount);
        this.add(inputAccount);
        this.add(labelPassword);
        this.add(inputPassword);
        this.add(login);
        this.add(register);
        this.add(exit);
        this.setSize(250, 180);
        toCenter(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        //add action listener for three buttons to achieve goals
        login.addActionListener(this);
        register.addActionListener(this);
        exit.addActionListener(this);
    }


    //take action according to the button pressed
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String account = inputAccount.getText();
            String password = new String(inputPassword.getPassword());
            if (Save.account == null || !Save.password.equals(password)) {
                JOptionPane.showMessageDialog(this, "Login failed.");
                return;
            }
            JOptionPane.showMessageDialog(this, "Login successfully!");
            this.dispose();

            //Schedule a job for the event-dispatching thread:
            //creating and showing this application's GUI.
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new Menu();
                }
            });
        } else if (e.getSource() == register) {
            this.dispose();
            new Register();
        } else {
            JOptionPane.showMessageDialog(this, "Have a good day!");
            System.exit(0);
        }
    }

    //keep the interface in the center of the screen
    public static void toCenter(Component comp) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle rec = ge.getDefaultScreenDevice().getDefaultConfiguration().getBounds();
        comp.setLocation(((int) rec.getWidth() - comp.getWidth()) / 2, ((int) rec.getHeight() - comp.getHeight()) / 2);
    }
}