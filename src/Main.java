
import javax.swing.*;
import java.awt.*;

void main() {
    Game game = new Game(Toolkit.getDefaultToolkit().getScreenSize());
    JFrame jFrame = new JFrame("GAME YAY!");
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.add(game);
    jFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
    jFrame.setVisible(true);
    game.init();
    game.start();

    new Thread(() -> {
        boolean play = true;
        while (play){
            play = game.startGame();
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }).start();

}
