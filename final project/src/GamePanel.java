import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener{

    //game variables
    private int panelWidth;
    private int panelHeight;
    private JLabel scoreLabel;
    private boolean pause;
    private boolean pressed;
    private int keyCode;
    private Timer timer;
    private final int DELAY = 100;
    private int score;

    //paddle variables
    private Paddle paddle;
    private int paddleWidth;
    private int paddleHeight;
    private int paddleSpeed;
    private int paddleX;
    private int paddleY;

    //ball variables
    private Ball ball;
    private int ballRadius;
    private int ballDiameter;
    private int ballSpeed;
    private int ballX, ballY;
    private int diffX, diffY;
    private boolean stickToPaddle;

    //brick variables
    private ArrayList<Brick> bricks;
    private int brickHeight;
    private int brickWidth;
    private int brickX, brickY;


    //GamePanel constructor
    public GamePanel(JLabel sl)
    {
        this.setBackground(Color.WHITE);
        scoreLabel = sl;
        score = 0;

        //add listeners
        addKeyListener(this);
        addMouseListener(this);
        timer = new Timer(DELAY, this);
        setFocusable(true);
    }

    //start game
    public void startGame(){

        //game
        panelWidth = this.getWidth();
        panelHeight = this.getHeight();
        System.out.println("Width: " + panelWidth);
        System.out.println("Height: " + panelHeight);
        pause = false;
        pressed = false;

        //paddle
        paddleX = 0;
        paddleY = panelHeight - 50;
        paddleWidth = 100;
        paddleHeight = 20;
        paddle = new Paddle(paddleX, paddleY, paddleWidth, paddleHeight);
        paddleSpeed = 10;

        //ball
        ballSpeed = 10;
        ballDiameter = 20;
        ballRadius = ballDiameter / 2;
        ballX = paddleX + paddleWidth / 2 - ballRadius;
        ballY = paddleY - ballDiameter;
        ball = new Ball(ballX, ballY, ballDiameter);
        stickToPaddle = true;
        diffX = 0;
        diffY = 0;

        //bricks
        brickX = 0;
        brickY = 40;
        brickWidth = 40;
        brickHeight = 20;
        bricks = new ArrayList<Brick>();
        int bricksCount = panelWidth / brickWidth;
        int rows = 3;

        //create bricks
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < bricksCount; j++)
            {
                bricks.add(new Brick(brickX, brickY, brickWidth, brickHeight));
                brickX += (brickWidth + 1);
            }
            brickX = 0;
            brickY += (brickHeight + 1);
        }

        repaint();
        timer.start();
    }

    //paint game objects
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);

        //paint paddle and ball
        paddle.paint(page);
        ball.paint(page);

        //paint all remaining bricks
        for (int i = 0; i < bricks.size(); i++)
            bricks.get(i).paint(page);

    }


    /******************************************************************************
     * Key events
     ******************************************************************************/
    @Override
    public void keyPressed(KeyEvent e) {
        pressed = true;
        keyCode = e.getKeyCode();

        //pause
        if (keyCode == KeyEvent.VK_P)
        {
            if (pause){
                pause = false;
                timer.start();
            }
            else{
                pause = true;
                timer.stop();
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        pressed = false;
    }
    @Override
    public void keyTyped(KeyEvent e) {}


    /******************************************************************************
     * Mouse events
     ******************************************************************************/
    @Override
    public void mouseClicked(MouseEvent event) {

        Point mouseClick = event.getPoint();
        int clickX = (int)mouseClick.getX();
        int clickY = (int)mouseClick.getY();


        int xP = clickX - ballX;
        int yP = ballY - clickY;
        diffX = (int) (ballSpeed * (xP/Math.sqrt(Math.pow(xP, 2) + Math.pow(yP, 2))));
        diffY = (int) (ballSpeed * (yP/Math.sqrt(Math.pow(xP, 2) + Math.pow(yP, 2))));

        ball.setVelocity(diffX, diffY);

        stickToPaddle = false;
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {}
    @Override
    public void mouseExited(MouseEvent arg0) {}
    @Override
    public void mousePressed(MouseEvent arg0) {}
    @Override
    public void mouseReleased(MouseEvent arg0) {}


    /******************************************************************************
     * Timer events
     ******************************************************************************/
    @Override
    public void actionPerformed (ActionEvent event) {
        //move the paddle
        if (pressed){
            switch(keyCode)
            {
                case KeyEvent.VK_D:
                case KeyEvent.VK_RIGHT:
                    if (paddleX < (panelWidth - paddleWidth))
                    {
                        paddleX += paddleSpeed;
                        paddle.setPos(paddleX, paddleY);
                    }
                    break;

                case KeyEvent.VK_A:
                case KeyEvent.VK_LEFT:
                    if (paddleX > 0)
                    {
                        paddleX -= paddleSpeed;
                        paddle.setPos(paddleX, paddleY);
                    }
                    break;
                default:
            }
        }

        //border collision logic
        if (ball.x >= (panelWidth - ballDiameter) ||
                ball.x <= 0){
            ball.diffX *= -1;
        }

        if (ball.y <= 0){
            ball.diffY *= -1;
        }

        else if (ball.y > (panelHeight - ballDiameter)) {
            ball.diffY *= -1;
            timer.stop();
            JOptionPane.showMessageDialog(null, "You lose!\n Your score is:" + " " + score);
            int reply = JOptionPane.showConfirmDialog(null,
                    "Try Again?", "Try Again", JOptionPane.YES_NO_OPTION);
            //restart the game
            if (ballSpeed == 10) {
                if (reply == JOptionPane.YES_OPTION) {
                    startGame();
                    ballSpeed = 10;
                    score = 0;
                    scoreLabel.setText("Score: " + score);
                }
                else {
                    System.exit(0);
                }
            }
            if (ballSpeed == 15) {
                if (reply == JOptionPane.YES_OPTION) {
                    startGame();
                    ballSpeed = 15;
                    score = 0;
                    scoreLabel.setText("Score: " + score);
                }
                else {
                    System.exit(0);
                }
            }

            else {
                if (reply == JOptionPane.YES_OPTION) {
                    startGame();
                    ballSpeed = 20;
                    score = 0;
                    scoreLabel.setText("Score: " + score);
                }
                else {
                    System.exit(0);
                }
            }

        }

        //move ball
        if (!stickToPaddle){
            ball.move();
        }
        else{
            ballX = paddleX + paddleWidth / 2 - ballRadius;
            ball.setPos(ballX, ballY);
        }

        //paddle collision
        Point overlapP = ball.overlapPoint(paddle);
        if (overlapP != null && !stickToPaddle){
            System.out.println("Overlap with paddle at " + overlapP.x + ", " + overlapP.y);
            ball.bounce(paddle, overlapP);
        }

        //brick collision
        for (int i = 0; i < bricks.size(); i++)
        {
            Point contactPoint = ball.overlapPoint(bricks.get(i));
            if (contactPoint != null){
                System.out.println("Overlap with brick at " + contactPoint.x + ", " + contactPoint.y);
                ball.bounce(bricks.get(i), contactPoint);
                bricks.remove(i);
                score++;
                scoreLabel.setText("Score: " + score);
                break;
            }
        }

        //paint new information
        repaint();

        //Check win condition and choose whether to level up
        if (bricks.size() == 0){
            timer.stop();
            JOptionPane.showMessageDialog(null, "You WIN!\n Your score is:" + " " + score);

            if(ballSpeed == 10) {
                int reply = JOptionPane.showConfirmDialog(null,
                        "Level Up?", "Level up", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION ) {
                    startGame();
                    ballSpeed = 15;
                    score = 0;
                    scoreLabel.setText("Score: " + score);
                }
                else {
                    int  levelReply = JOptionPane.showConfirmDialog(null,
                            "Try Again? ", "Try again", JOptionPane.YES_NO_OPTION);
                    if(levelReply == JOptionPane.YES_OPTION) {
                        startGame();
                        ballSpeed = 10;
                        score = 0;
                        scoreLabel.setText("Score: " + score);
                    }
                    else{
                        System.exit(0);
                    }
                }
            }
            else if(ballSpeed == 15) {
                int reply = JOptionPane.showConfirmDialog(null,
                        "Level Up?", "Level up", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION ) {
                    startGame();
                    ballSpeed = 20;
                    score = 0;
                    scoreLabel.setText("Score: " + score);
                }
                else {
                    int  levelReply = JOptionPane.showConfirmDialog(null,
                            "Try Again? ", "Try again", JOptionPane.YES_NO_OPTION);
                    if(levelReply == JOptionPane.YES_OPTION) {
                        startGame();
                        ballSpeed = 15;
                        score = 0;
                        scoreLabel.setText("Score: " + score);
                    }
                    else{
                        System.exit(0);
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "You passed all levels!");
                System.exit(0);
            }
        }
    }
}