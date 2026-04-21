import javax.swing.*;

void main() {

    // FPS holder
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


    // Set to "0"  means max fps by the device
    // Set to 16 for around 60 fps if device can produce
    // NOTE: SHOWS 30+ FPS!
    // Generate Frames
    int fpsLimit = 60;
    new Timer(1000/fpsLimit, e -> {
        fps.addAndGet(game.generateFrames());
    }).start();


    // SHOW FPS on the SCREEN
    new Timer(1000, e -> {
        game.setFps(fps.get());
        fps.set(0);
    }).start();
}