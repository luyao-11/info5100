package FileAndGUI;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Read and Write file");// Setting the width and height of frame
        frame.setBounds(300, 200, 900, 500);
        //create and add panel
        JPanel panel = new JPanel();
        frame.add(panel);
        FileAndGUI.GUI.placeComponents(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
