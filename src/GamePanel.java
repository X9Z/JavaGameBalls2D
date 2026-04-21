
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GamePanel extends JPanel {
    // Keep The Thread Running if True
    private volatile boolean running = true;
    private boolean antiAliasingEnabled = false;

    private int speed;
    private int fps = 0;
    boolean isStopped = true;
    private int x;
    private int y;
    private Dimension dimension;
    public GamePanel(Dimension dimension){
        this.dimension = dimension;
        x = dimension.width;
        y = dimension.height;
    }

    //object initiation
    private Player player;
    private final Ball[] balls = new Ball[20];
    private final Rectangle[] rect = new Rectangle[3];


    // Set UI
    public void setupUI() {
        setFocusable(true);
        requestFocusInWindow();

        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        setFont(new Font("Times New Roman", Font.BOLD, 20));
        setBackground(Color.BLACK);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseClickInitiated(e, e.getX(), e.getY());
            }
        });
    }


    // Init
    public void init() {
        speed = 15;
        player = new Player();

        Random rand = new Random();
        int Xrad = rand.nextInt(3) + 1; // 1 to 3
        int Yrad = rand.nextInt(3) + 1;

        rect[0] = new Rectangle(x - 70, y - 700, "0_0", dimension);
        rect[1] = new Rectangle(x - 670, y - 700, "-_-", dimension);
        rect[2] = new Rectangle(x - 1000, y - 700, ">_<", dimension);

        int startX = x / 2;
        int startY = y / 2;

        for (int i = 0; i < balls.length; i++) {
            balls[i] = new Ball(
                    30,
                    startX,
                    startY,
                    Xrad,
                    Yrad,
                    1,
                    Color.WHITE,
                    player,
                    String.valueOf(i + 1),
                    rect,
                    dimension
            );
        }
    }


    // Get Mouse Click
    public boolean mouseClickInitiated(MouseEvent e, int mx, int my) {

        if (!isStopped) {
            for (Ball b : balls) {
                if (b != null && b.isHit(mx, my)) {
                    b.ballWasHit();
                    break; // stop after first hit (same as your else-if chain)
                }
            }
        } else if (isStopped && e.getClickCount() == 2) {
            isStopped = false;
            init();
        }
        return true;
    }


    // Paint
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Anti-Aliasing
        Graphics2D g2 = (Graphics2D) g;
        if (isAntiAliasingEnabled()){
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }

        if (player != null && player.getLives() > 0) {
            g2.setColor(Color.BLUE);
            g2.drawLine(0, 90, x, 90);
            g2.drawLine(0, 91, x, 91);

            g2.setColor(Color.YELLOW);
            g2.drawLine(0, 325, x, 325);
            g2.drawLine(0, 326, x, 326);

            g2.drawString("Score : " + player.getScore(), x - (x - 10), y - (y - 30));
            g2.drawString("Lives : " + player.getLives(), x - 150, y - (y - 30));
            g2.drawString("FPS : " + getFps(), x - (x / 2), y - (y - 30));

            // Draw balls
            for (Ball b : balls) {
                b.drawBall(g2);
            }

            // Draw rectangles
            for (Rectangle r : rect) {
                r.drawRectangle(g2);
            }
            if (isStopped) {
                g2.setColor(Color.yellow);
                g2.drawString("Double click on the game to start!", x / 3, y / 3);
            }

        } else if (player != null && player.getLives() < 1) {
            g2.setColor(Color.yellow);
            g2.drawString("Game Over!", x / 3, y / 2);
            g2.drawString("You score is: " + player.getScore() + " Points!", x / 3, y / 2 + 20);

            // comments on score
            g2.drawString("Double click on the game to start!", x / 3, y / 3);
            isStopped = true;

        }
    }

    // Start Game
    public boolean start() {
        runGame();
        return  running;
    }


    // Generate Frames / Refresh Frames
    public int generateFrames(){
        repaint();
        return 1;
    }

    // Run The Game
    public boolean runGame(){
        if (!running || player == null) return running;
        if (player.getLives() > 0 && !isStopped) {
            for (Ball b : balls) { b.move(); }
            for (Rectangle r : rect) { r.move(); }
        }
        return  running;
    }


    // Stop
    public void stop() {
        running = false;
    }

    // Get FPS
    public int getFps() {
        return fps;
    }
    // SET FPS
    public void setFps(int fps) {
        this.fps = fps;
    }

    // Set Anti Aliasing
    public boolean isAntiAliasingEnabled() {
        return antiAliasingEnabled;
    }
    // Get Anti Aliasing
    public void setAntiAliasingEnabled(boolean antiAliasingEnabled) {
        this.antiAliasingEnabled = antiAliasingEnabled;
    }
}
