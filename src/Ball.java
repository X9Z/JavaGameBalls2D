import java.awt.*;
import java.util.Random;

public class Ball {
    //instances variables
    private int x_pos;
    private int y_pos;
    private int x_vel;
    private int y_vel;


    private boolean hit;
    private boolean score;
    private boolean loose_life;

    private int x_init;
    private int y_init;

    private int radius;

    private int max_vel;

    private String name;
    //instance final variables
    private final int x_leftout = 25;
    private final int x_rightout = 1330;
    private int y_upout = 350;
    private final int y_downout = 660;

    private final int diff_factor = 30;
    //referrnce variables
    Color color;
    private Random rand = new Random();
    //object initiation
    Player player;
    Rectangle[] rect;


    //constructor
    public Ball(int rad, int x, int y, int xv, int yv, int mv, Color color, Player player, String nm, Rectangle[] rect) {
        this.radius = rad;

        x_pos = x;
        y_pos = y;

        x_init = x;
        y_init = y;

        x_vel = xv;
        y_vel = yv;

        name = nm;
        max_vel = mv;

        this.color = color;
        this.player = player;
        this.rect = rect;

    }

    //ball movement
    public void move() {
        x_pos += x_vel;
        y_pos += y_vel;
        isTouched();
        isOut();
        isScored();
    }

    //if hit then change the direction
    public void ballWasHit() {
        y_vel = -25;
        x_vel = 0;
        hit = true;

    }

    // determine if ball is hit by the user
    public boolean isHit(int x_hit, int y_hit) {
        double x = x_hit - x_pos;
        double y = y_hit - y_pos;

        double distance = Math.sqrt((x * x) + (y * y));

        if (distance < diff_factor && y_pos >= 350) {
            y_upout = 90;
            return true;
        } else {
            hit = false;
            return false;
        }
    }

    // Determines if the ball touched the rect or not
    public void isTouched() {
        if (y_pos <= 90) {
            if (x_pos >= rect[0].getXR() - 30 && x_pos <= rect[0].getXR() + 70 && y_pos <= rect[0].getYR()) {
                if (rect[0].score_available) {
                    score = true;
                }
                rect[0].score_available = false;
            } else if (x_pos >= rect[1].getXR() - 30 && x_pos <= rect[1].getXR() + 70 && y_pos <= rect[1].getYR()) {
                if (rect[1].score_available) {
                    score = true;
                }
                rect[1].score_available = false;
            } else if (x_pos >= rect[2].getXR() - 30 && x_pos <= rect[2].getXR() + 70 && y_pos <= rect[2].getYR()) {
                if (rect[2].score_available) {
                    score = true;
                }
                rect[2].score_available = false;
            } else {
                loose_life = true;
            }
            //Random rand  = new Random();
            int X = rand.nextInt() % 2;
            if (X == 0) {
                X = X - 1;
            }
            x_vel = X;
        }
    }

    // add score or loose life
    void isScored() {
        int s = Integer.parseInt(name);
        if (score) {
            player.addScore(s);
            score = false;
        } else if (loose_life) {
            player.looseLife();
            loose_life = false;
        }
    }

    // determine if ball is out of boundary and player loose life
    public boolean isOut() {
        if (!hit && y_pos >= 350) {
            y_upout = 350;
        }
        if (x_pos <= x_leftout) {
            x_vel = rand();
            move();
            return true;
        } else if (x_pos >= x_rightout) {
            x_vel = randB();
            move();
            return true;
        } else if (y_pos <= y_upout) {
            if (y_upout <= 90) {
                y_vel = 25;
            } else {
                y_vel = rand();
            }
            move();

            return true;
        } else if (y_pos >= y_downout) {
            y_upout = 350;
            y_vel = randB();
            move();

            return true;
        } else return false;
    }

    int rand() {
        //Random rand = new Random();
        return 1 + rand.nextInt(5) % 5;
    }

    int randB() {
        //Random rand = new Random();
        return -(1 + rand.nextInt(5) % 5);
    }

    // draw the ball
    public void drawBall(Graphics2D g2) {
        g2.setColor(color);
        g2.fillOval(x_pos - radius, y_pos - radius, 2 * radius, 2 * radius);
        g2.setColor(Color.GREEN);


        // Draw Text At The Center
        FontMetrics fm = g2.getFontMetrics();
        // Horizontal Center
        int textWidth = fm.stringWidth(name);
        int x = x_pos - textWidth / 2;
        // Vertical Center
        int y = y_pos + (fm.getAscent() - fm.getDescent()) / 2;
        g2.drawString(name, x, y);
    }
}
