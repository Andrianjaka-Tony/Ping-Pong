package front;
import front.MyFrame;
import front.Player;
import front.Table_de_jeu;
public class Balle {
    int x;
    int y;
    boolean move;

    public Balle(int x, int y) {
        this.x = x;
        this.y = y;
        this.move = false;
    }

    // fonction pour savoir s'il y a un rebond
    public boolean rebond(Player player) {
        return(x <= player.getX() + 25 && x >= player.getX() - 5 || x >= player.getX() + 26 && x <= player.getX() + 55);
    }

    // fonction pour avoir le nombre de points de chaque joueur
    public void win(Player p1, Player p2, Table_de_jeu jeu) {
        if(y <= 10 && move) {
            if(rebond(p1)){
                // si le joueur 1 devie la balle
                move = false;
            } else { 
                // si le joueur 1 ne devie pas la balle
                x = p2.getX() + 15;
                y = p2.getY() - 15;
                p2.setScore(p2.getScore() + 1);
                jeu.getFrame().getP2().setText("Player 2:       " + p2.getScore());
                move = false;
            }
        }
        if(y >= 530 && move) {
            if(rebond(p2)) {
                // si le joueur 2 devie la balle
                move = false;
            } else {
                // si le joueur 1 ne devie pas la balle
                x = p1.getX() + 15;
                y = p1.getY() + 15;
                p1.setScore(p1.getScore() + 1);
                jeu.getFrame().getP1().setText("Player 1:       " + p1.getScore());
                move = false;
            }
        }
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
    public boolean isMove() {
        return move;
    }
    public void setMove(boolean move) {
        this.move = move;
    }
}
// 69
