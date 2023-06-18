package listener;
import java.awt.event.*;
import front.*;
public class Clavier implements KeyListener{
    Table_de_jeu table;
    int rebond = 0;

    public Clavier(Table_de_jeu table) {
        this.table = table;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // mettre le jeu en pause
        if(e.getKeyCode() == 32) {
            if(table.getBalle().isMove()) {
                table.getBalle().setMove(false);
                table.setPause(1);
                System.out.println("Pause");
            } else {
                table.setPause(0);
                table.getBalle().setMove(true);
                table.repaint();
                System.out.println("Play");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // deplacer le joueur 1
        // deplacer le joueur 1 vers la gauche
        if(e.getKeyChar() == 'a' && table.getBalle().isMove()) {
            if(table.getJ1().getX() > 10) { // 10: x de la logne verticale gauche
                table.getJ1().setX(table.getJ1().getX() - 10);
                table.repaint();
            }
        }

        // deplacer le joueur 1 vers la droite
        if(e.getKeyChar() == 's' && table.getBalle().isMove()) {
            if(table.getJ1().getX() < 400) { // 10: x de la ligne droite
                table.getJ1().setX(table.getJ1().getX() + 10);
                table.repaint();
            }
        }

        // deplacer le joueur 2
        // deplacer le joueur 2 vers la gauche
        if(e.getKeyChar() == 'k' && table.getBalle().isMove()) {
            if(table.getJ2().getX() > 10) { // 10: x de la logne verticale gauche
                table.getJ2().setX(table.getJ2().getX() - 10);
                table.repaint();
            }
        }

        // deplacer le joueur 2 vers la droite
        if(e.getKeyChar() == 'l' && table.getBalle().isMove()) {
            if(table.getJ2().getX() < 400) { // 10: x de la ligne droite
                table.getJ2().setX(table.getJ2().getX() + 10);
                table.repaint();
            }
        }
    }

    
}
// 53