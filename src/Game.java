
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Game extends JPanel {
    // Keep The Thread Running if True
    private volatile boolean running = true;

    private int speed;
    boolean isStopped = true;
    private int x;
    private int y;
    private Dimension dimension;
    public Game(Dimension dimension){
        this.dimension = dimension;
        x = dimension.width;
        y = dimension.height;
    }

    //object initiation
    private Player player;
    private final Ball[] redball = new Ball[20];
    private final Rectangle[] rect = new Rectangle[3];


    public void init() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                mouseClickInitiated(e, e.getX(), e.getY());
            }
        });
        setVisible(true);
        setFocusable(true);
        requestFocusInWindow();
        setSize(dimension);
        //cursor initialization
        Font f = new Font("Times New Roman", Font.BOLD, 20);
        Cursor cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
        setCursor(cursor);

        //background color
        Color myColor = new Color(250, 250, 255);
        setBackground(Color.BLACK);

        //Font set
        setFont(f);

        speed = 15;

        player = new Player();
        Random rand = new Random();
        int Xrad = rand.nextInt() % 4;
        int Yrad = rand.nextInt() % 4;
        if (Xrad == 0)
            Xrad = Xrad + 1;
        if (Yrad == 0)
            Yrad = Yrad + 1;


        rect[0] = new Rectangle(x - 70, y - 700, "0_0");
        rect[1] = new Rectangle(x - 670, y - 700, "-_-");
        rect[2] = new Rectangle(x - 1000, y - 700, ">_<");

        redball[0] = new Ball(30, x / 2, y / 2, Xrad, Yrad, 1, Color.WHITE, player, "1", rect);
        redball[1] = new Ball(30, x / 2, y / 2, Xrad, Yrad, 1, Color.WHITE, player, "2", rect);
        redball[2] = new Ball(30, x / 2, y / 2, Xrad, Yrad, 1, Color.WHITE, player, "3", rect);
        redball[3] = new Ball(30, x / 2, y / 2, Xrad, Yrad, 1, Color.WHITE, player, "4", rect);
        redball[4] = new Ball(30, x / 2, y / 2, Xrad, Yrad, 1, Color.WHITE, player, "5", rect);
        redball[5] = new Ball(30, x / 2, y / 2, Xrad, Yrad, 1, Color.WHITE, player, "6", rect);
        redball[6] = new Ball(30, x / 2, y / 2, Xrad, Yrad, 1, Color.WHITE, player, "7", rect);
        redball[7] = new Ball(30, x / 2, y / 2, Xrad, Yrad, 1, Color.WHITE, player, "8", rect);
        redball[8] = new Ball(30, x / 2, y / 2, Xrad, Yrad, 1, Color.WHITE, player, "9", rect);
        redball[9] = new Ball(30, x / 2, y / 2, Xrad, Yrad, 1, Color.WHITE, player, "10", rect);
        redball[10] = new Ball(30, x / 2, y / 2, Xrad, Yrad, 1, Color.WHITE, player, "11", rect);
        redball[11] = new Ball(30, x / 2, y / 2, Xrad, Yrad, 1, Color.WHITE, player, "12", rect);
        redball[12] = new Ball(30, x / 2, y / 2, Xrad, Yrad, 1, Color.WHITE, player, "13", rect);
        redball[13] = new Ball(30, x / 2, y / 2, Xrad, Yrad, 1, Color.WHITE, player, "14", rect);
        redball[14] = new Ball(30, x / 2, y / 2, Xrad, Yrad, 1, Color.WHITE, player, "15", rect);
        redball[15] = new Ball(30, x / 2, y / 2, Xrad, Yrad, 1, Color.WHITE, player, "16", rect);
        redball[16] = new Ball(30, x / 2, y / 2, Xrad, Yrad, 1, Color.WHITE, player, "17", rect);
        redball[17] = new Ball(30, x / 2, y / 2, Xrad, Yrad, 1, Color.WHITE, player, "18", rect);
        redball[18] = new Ball(30, x / 2, y / 2, Xrad, Yrad, 1, Color.WHITE, player, "19", rect);
        redball[19] = new Ball(30, x / 2, y / 2, Xrad, Yrad, 1, Color.WHITE, player, "20", rect);

    }


    // Get Mouse Click
    public boolean mouseClickInitiated(MouseEvent e, int x, int y) {
        if (!isStopped) {
            if (redball[0].isHit(x, y)) {
                redball[0].ballWasHit();
            } else if (redball[1].isHit(x, y)) {
                redball[1].ballWasHit();
            } else if (redball[2].isHit(x, y)) {
                redball[2].ballWasHit();
            } else if (redball[3].isHit(x, y)) {
                redball[3].ballWasHit();
            } else if (redball[4].isHit(x, y)) {
                redball[4].ballWasHit();
            } else if (redball[5].isHit(x, y)) {
                redball[5].ballWasHit();
            } else if (redball[6].isHit(x, y)) {
                redball[6].ballWasHit();
            } else if (redball[7].isHit(x, y)) {
                redball[7].ballWasHit();
            } else if (redball[8].isHit(x, y)) {
                redball[8].ballWasHit();
            } else if (redball[9].isHit(x, y)) {
                redball[9].ballWasHit();
            } else if (redball[10].isHit(x, y)) {
                redball[10].ballWasHit();
            } else if (redball[11].isHit(x, y)) {
                redball[11].ballWasHit();
            } else if (redball[12].isHit(x, y)) {
                redball[12].ballWasHit();
            } else if (redball[13].isHit(x, y)) {
                redball[13].ballWasHit();
            } else if (redball[14].isHit(x, y)) {
                redball[14].ballWasHit();
            } else if (redball[15].isHit(x, y)) {
                redball[15].ballWasHit();
            } else if (redball[16].isHit(x, y)) {
                redball[16].ballWasHit();
            } else if (redball[17].isHit(x, y)) {
                redball[17].ballWasHit();
            } else if (redball[18].isHit(x, y)) {
                redball[18].ballWasHit();
            } else if (redball[19].isHit(x, y)) {
                redball[19].ballWasHit();
            }

        } else if (isStopped && e.getClickCount() == 2) {
            isStopped = false;
            init();
        }
        return true;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Anti-Aliasing
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        if (player != null && player.getLives() > 0) {
            g2.setColor(Color.BLUE);
            g2.drawLine(0, 90, x, 90);
            g2.drawLine(0, 91, x, 91);

            g2.setColor(Color.YELLOW);
            g2.drawLine(0, 325, x, 325);
            g2.drawLine(0, 326, x, 326);

            g2.drawString("Score : " + player.getScore(), x - (x - 10), y - (y - 20));
            g2.drawString("Lives : " + player.getLives(), x - 150, y - (y - 20));

            redball[0].drawBall(g2);
            redball[1].drawBall(g2);
            redball[2].drawBall(g2);
            redball[3].drawBall(g2);
            redball[4].drawBall(g2);
            redball[5].drawBall(g2);
            redball[6].drawBall(g2);
            redball[7].drawBall(g2);
            redball[8].drawBall(g2);
            redball[9].drawBall(g2);
            redball[10].drawBall(g2);
            redball[11].drawBall(g2);
            redball[12].drawBall(g2);
            redball[13].drawBall(g2);
            redball[14].drawBall(g2);
            redball[15].drawBall(g2);
            redball[16].drawBall(g2);
            redball[17].drawBall(g2);
            redball[18].drawBall(g2);
            redball[19].drawBall(g2);


            rect[0].drawRectangle(g2);
            rect[1].drawRectangle(g2);
            rect[2].drawRectangle(g2);

            if (isStopped) {
                g2.setColor(Color.yellow);
                g2.drawString("Double click on applet to start the game!", x / 3, y / 3);
            }

        } else if (player != null && player.getLives() < 1) {
            g2.setColor(Color.yellow);
            g2.drawString("Game Over!", x / 3, y / 2);
            g2.drawString("You score is: " + player.getScore() + " Points!", x / 3, y / 2 + 20);

            // comments on score
            g2.drawString("Double click on applet to start the game!", x / 3, y / 3);
            isStopped = true;

        }
    }

    public boolean start() {
        startGame();
        new Timer(0, e -> {
            repaint();   // ~60 FPS
        }).start();

        return  running;
    }

    public boolean startGame(){
        if (running) {
            if (player.getLives() > 0 && !isStopped) {
                redball[0].move();
                redball[1].move();
                redball[2].move();
                redball[3].move();
                redball[4].move();
                redball[5].move();
                redball[6].move();
                redball[7].move();
                redball[8].move();
                redball[9].move();
                redball[10].move();
                redball[11].move();
                redball[12].move();
                redball[13].move();
                redball[14].move();
                redball[15].move();
                redball[16].move();
                redball[17].move();
                redball[18].move();
                redball[19].move();


                rect[0].move();
                rect[1].move();
                rect[2].move();
            }
        }

        return  running;
    }


    // Stop
    public void stop() {
        running = false;
    }
}
