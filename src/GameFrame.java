import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private Dimension dimension;
    private GamePanel gamePanel;

    public GameFrame(){
        dimension = new Dimension(1366, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GAME YAY!");
        setSize(dimension);
        setVisible(true);
    }

    public void init(){
        gamePanel = new GamePanel(dimension);
        gamePanel.setSize(dimension);
        gamePanel.setupUI();
        add(gamePanel);
        gamePanel.setVisible(true);

        JSlider slider = new JSlider(0, 100, 25); // min, max, initial
        //slider.setSize(dimension.width, 40);


        JFrame controlFrame = new JFrame("Control Frame");
        //controlFrame.setSize(dimension.width, 70);
        controlFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        controlFrame.setAlwaysOnTop(true);

        JButton setAntiAliasingJButton = new JButton(gamePanel.isAntiAliasingEnabled()? "Disable anti aliasing" : "Enable anti aliasing");
        setAntiAliasingJButton.addActionListener(actionEvent -> {
            if (gamePanel.isAntiAliasingEnabled()){
                gamePanel.setAntiAliasingEnabled(false);
                setAntiAliasingJButton.setText("Enable anti aliasing");
            } else if (!gamePanel.isAntiAliasingEnabled()) {
                gamePanel.setAntiAliasingEnabled(true);
                setAntiAliasingJButton.setText("Disable anti aliasing");
            }
        });


        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.PAGE_AXIS));
        //controlPanel.setSize(dimension.width, 70);


        JTextField jTextField = new JTextField("Speed Delay: " + getSpeed() + "ms");
        //jTextField.setSize(dimension.width, 30);

        slider.addChangeListener(e -> {
            int value = slider.getValue();
            setSpeed(value);
            jTextField.setText("Speed Delay: " + getSpeed() + "ms");
        });

        controlFrame.add(controlPanel);
        controlPanel.add(jTextField);
        controlPanel.add(slider);
        controlPanel.add(setAntiAliasingJButton);

        setAntiAliasingJButton.setVisible(true);
        controlPanel.setVisible(true);
        jTextField.setVisible(true);
        slider.setVisible(true);
        controlFrame.pack();
        controlFrame.setVisible(true);
    }

    public void start(){
        gamePanel.init();
        gamePanel.start();
    }

    public int generateFrames(){
        return gamePanel.generateFrames();
    }

    // Run The Game
    public boolean runGame(){
        return gamePanel.runGame();
    }

    // Set FPS
    public void setFps(int fps){
        gamePanel.setFps(fps);
    }


    // SPEED -------------
    private int speed = 25;
    // Get Speed
    public int getSpeed() {
        return speed;
    }
    // Set Speed
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
