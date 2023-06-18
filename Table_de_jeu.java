package front;
import javax.swing.JPanel;
import front.MyFrame;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import listener.*;
import java.awt.Image;
public class Table_de_jeu extends JPanel {
    int width = 450;
    int height = 580;
    Player j1, j2;
    Clavier listener;
    Envoyer envoi;
    Balle balle;
    int xMove = 1;
    int yMove = 1;
    MyFrame frame;
    int pause;

    public Table_de_jeu(MyFrame f) {
        this.frame = f;
        setSize(width, height);

        // les composants
        j1 = new Player(205, 10);
        j2 = new Player(205, 530);
        balle = new Balle(220, 30);

        // les listeners
        listener = new Clavier(this);
        envoi = new Envoyer(this);

        // ajout des isteners
        addKeyListener(listener);
        addKeyListener(envoi);

        // pause
        this.pause = 0;
    }
    
    public void paint(Graphics g) {
        super.paint(g);

        // dessiner un rectangle
        g.setColor(Color.green);
        g.fillRect(10, 10, 440, 540);

        // dessiner les lignes
        g.setColor(Color.white);
        // les lignes verticales
        g.drawLine(10, 10, 10, 550);  // gauche
        g.drawLine(450, 10, 450, 550);  // droite
        // les lignes horizontales
        g.drawLine(10, 10, 450, 10);  // haut
        g.drawLine(10, 270, 450, 270);  // milieu
        g.drawLine(10, 550, 450, 550);  // bas
        

        // dessiner les joueurs
        // joueur 1
        g.setColor(Color.blue);
        g.drawRect(j1.getX(), j1.getY(), 50, 20);
        // joueur 2
        g.setColor(Color.red);
        g.drawRect(j2.getX(), j2.getY(), 50, 20);


        // dessiner le ballon
        g.setColor(Color.gray);
        g.fillOval(balle.getX(), balle.getY(), 20, 20);


        // move
        if(balle.isMove() == true) {
            try {
                Thread.sleep(1);
            } catch(Exception e) {
    
            }
    
            // deplacement de la balle
            balle.setX(balle.getX() + xMove);
            balle.setY(balle.getY() + yMove);
    
            // compter les points
            balle.win(j1, j2, this);

            // conditions pour que la balle ne depasse pas la table
            if(balle.getX() >= 430 || balle.getX() <= 10) {
                xMove = -xMove;
            }
            if(balle.getY() >= 530 || balle.getY() <= 10) {
                yMove = -yMove;
            }
            
            // naturellement paintisation
            repaint();
        } else {
            
        }
    }

    public Clavier getListener() {
        return listener;
    }
    public Player getJ1() {
        return j1;
    }
    public Player getJ2() {
        return j2;
    }
    public Balle getBalle() {
        return balle;
    }
    public void setBalle(Balle balle) {
        this.balle = balle;
    }
    public int getxMove() {
        return xMove;
    }
    public void setxMove(int xMove) {
        this.xMove = xMove;
    }
    public int getyMove() {
        return yMove;
    }
    public void setyMove(int yMove) {
        this.yMove = yMove;
    }
    public MyFrame getFrame() {
        return frame;
    }
    public Envoyer getEnvoi() {
        return envoi;
    }
    public void setEnvoi(Envoyer envoi) {
        this.envoi = envoi;
    }
    public int getPause() {
        return pause;
    }
    public void setPause(int pause) {
        this.pause = pause;
    }
}

// 111
