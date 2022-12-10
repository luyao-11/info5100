import javax.swing.JFrame;
import java.awt.*;

public class Play {
    public Play(){
        JFrame frame = new JFrame("Pong");
        int width = 410;
        int height = 600;
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        PongPanel pongPanel = new PongPanel();
        frame.add(pongPanel);
        frame.setVisible(true);
        pongPanel.getGamePanel().startGame();
        toCenter(frame);
    }

    //keep the interface in the center of the screen
    public static void toCenter(Component comp){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle rec = ge.getDefaultScreenDevice().getDefaultConfiguration().getBounds();
        comp.setLocation(((int)rec.getWidth()-comp.getWidth())/2,((int)rec.getHeight()-comp.getHeight())/2);
    }
}
