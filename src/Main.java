import javax.swing.*;

void main() {

    // FPS
    AtomicInteger fps = new AtomicInteger();
    GameFrame game = new GameFrame();
    // Initialize The Game
    game.init();
    // Start The Game
    game.start();

    // Run The Game
    new Thread(() -> {
        while (game.runGame()){
            game.runGame();
            try {
                Thread.sleep(game.getSpeed());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }).start();


    // NOTE: SHOWS 30+ FPS!
    // Generate Frames
    new Timer(0, e -> {
        fps.addAndGet(game.generateFrames());
    }).start();


    // Set FPS
    new Timer(1000, e -> {
        game.setFps(fps.get());
        fps.set(0);
    }).start();
}