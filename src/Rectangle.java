
import java.awt.*;
import java.util.Random;

public class Rectangle {
    private Dimension screenDimension = new Dimension(1366, 768);
    Random rand = new Random();
    private String[] str = {"0_0", ">_<", "-_-", "P_P", "q_q", "6.6", "*_*", "0.o", "^.^"};
    private int randomX;
    private int randomY;



    private int moving_x_val = -3;
    private int x_pos;
    private int y_pos;
    private String impression;
    public boolean score_available = false;

    // construct
    public Rectangle(int x, int y, String imp, Dimension dimension) {
        this.screenDimension = dimension;
        x_pos = x;
        y_pos = y;
        impression = imp;
        randomX = rand.nextInt(30) % 30;
        randomY = rand.nextInt(30) % 30;
    }

    // move rectangle
    public void move() {
        x_pos = x_pos + moving_x_val;
        isAtEnd();
    }

    private void isAtEnd() {

        if (x_pos <= 0) {
            int x = rand.nextInt(9) % 9;
            randomX = rand.nextInt(30) % 30;
            randomY = rand.nextInt(30) % 30;
            impression = str[x];
            score_available = true;
            moving_x_val = 3;
        } else if (x_pos >= (screenDimension.width - 64)) {
            int x = rand.nextInt(3) % 3;
            randomX = rand.nextInt(30) % 30;
            randomY = rand.nextInt(30) % 30;
            impression = str[x];
            score_available = true;
            moving_x_val = -3;
        }
    }

    // draw the rectangle
    public void drawRectangle(Graphics2D g2) {
        if (score_available) {
            g2.setColor(Color.GREEN);
        } else if (!score_available) {
            g2.setColor(Color.LIGHT_GRAY);
        }
        g2.drawRoundRect(x_pos, y_pos, 60, 60, 5, 5);
        g2.fillRect(x_pos + 3, y_pos + 3, 54, 54);
        g2.setColor(Color.WHITE);
        g2.drawString(impression, x_pos + randomX, y_pos + randomY);
    }

    // returns the current X position of rectangle
    public int getXR() {
        return x_pos;
    }

    // returns the current Y + 70 position of rectangle
    public int getYR() {
        return y_pos + 70;
    }

    public Dimension getScreenDimension() {
        return screenDimension;
    }

    public void setScreenDimension(Dimension screenDimension) {
        this.screenDimension = screenDimension;
    }
}
