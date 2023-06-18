package front;
public class Player {
    int x;
    int y;
    int score;

    
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.score = 0;
    }
    
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
// 29