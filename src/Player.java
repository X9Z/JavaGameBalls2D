public class Player {
    // Player Lives
    private int lives;
    // Player Score
    private int score;

    // constructor
    public Player() {
        lives = 10;
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public int getLives() {
        return lives;
    }

    public void addScore(int hit) {
        score += hit;
    }

    public void looseLife() {
        lives--;
    }
}