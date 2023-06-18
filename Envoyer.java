package listener;
import java.awt.event.*;
import front.*;
public class Envoyer implements KeyListener {
    Table_de_jeu table;

    public Envoyer(Table_de_jeu table) {
        this.table = table;
    }

    public void keyPressed(KeyEvent e) {
        // direction vers la gauche
        if(e.getKeyCode() == 37 && table.getBalle().isMove() == false && table.getPause() == 0) {
            table.setxMove(-1);
            table.getBalle().setMove(true);
            table.repaint();
        }

        // direction vers la droite
        if(e.getKeyCode() == 39 && table.getBalle().isMove() == false && table.getPause() == 0) {
            table.setxMove(1);
            table.getBalle().setMove(true);
            table.repaint();
        }

        // direction verticale
        if(e.getKeyCode() == 38 && table.getBalle().isMove() == false && table.getPause() == 0) {
            table.setxMove(0);
            table.getBalle().setMove(true);
            table.repaint();
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
}
// 32