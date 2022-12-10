import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.*;

/* Menu.java requires no other files. */
public class Menu extends WindowAdapter {
    public int numWindows = 0;
    private Point lastLocation = null;
    private int maxX = 500;
    private int maxY = 500;

    public Menu() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        maxX = screenSize.width - 50;
        maxY = screenSize.height - 50;
        makeNewWindow();
    }

    public void makeNewWindow() {
        JFrame frame = new MyFrame(this);

        if (lastLocation != null) {
            //Move the window over and down 40 pixels.
            lastLocation.translate(40, 40);
            if ((lastLocation.x > maxX) || (lastLocation.y > maxY)) {
                lastLocation.setLocation(0, 0);
            }
            frame.setLocation(lastLocation);
        } else {
            lastLocation = frame.getLocation();
        }

        frame.setVisible(true);
    }

    //This method must be evoked from the event-dispatching thread.
    public void quit(JFrame frame) {
        if (quitConfirmed(frame)) {
            System.out.println("Quitting.");
            System.exit(0);
        }
    }

    private boolean quitConfirmed(JFrame frame) {
        String s1 = "Quit";
        String s2 = "Cancel";
        Object[] options = { s1, s2 };
        int n = JOptionPane.showOptionDialog(frame,
                "Windows are still open.\nDo you really want to quit?",
                "Quit Confirmation", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, s1);
        if (n == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }
    public void help(JFrame frame) {
        JOptionPane.showMessageDialog(null, "Click the mouse to start, and use the arrow keys to control the paddle to eliminate bricks by using a ball.");
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    static void createAndShowGUI() {
        Menu menu = new Menu();
    }



    class MyFrame extends JFrame {
        protected Dimension defaultSize = new Dimension(200, 200);
        protected Menu menu = null;

        public MyFrame(Menu controller) {
            super("Menu");
            menu = controller;
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            addWindowListener(menu);

            JMenu menu = new JMenu("Menu");
            menu.setMnemonic(KeyEvent.VK_W);
            JMenuItem item = null;

            //new
            item = new JMenuItem("New Game");
            item.setMnemonic(KeyEvent.VK_N);
            item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new Play();
                }
            });
            menu.add(item);

            //help
            item = new JMenuItem("Help");
            item.setMnemonic(KeyEvent.VK_H);
            item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    MyFrame.this.menu.help(MyFrame.this);
                }
            });
            menu.add(item);

            //quit
            item = new JMenuItem("Quit");
            item.setMnemonic(KeyEvent.VK_Q);
            item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Quit request");
                    MyFrame.this.menu.quit(MyFrame.this);
                }
            });
            menu.add(item);

            JMenuBar menuBar = new JMenuBar();
            menuBar.add(menu);
            setJMenuBar(menuBar);

            setSize(defaultSize);
        }
    }
}
