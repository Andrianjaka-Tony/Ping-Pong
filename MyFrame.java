package front;
import javax.swing.JFrame;
import front.Table_de_jeu;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;
public class MyFrame extends JFrame{
    int width = 700;
    int height = 600;
    Table_de_jeu table;
    JLabel p1, p2; // labels qui indiquent les score


    public MyFrame() {
        setTitle("                                                                ETU 001765");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        table = new Table_de_jeu(this);
        table.setLayout(new FlowLayout());

        // panel contennant les labels
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 800));
        panel.setLayout(new GridLayout(2,1));

        p1 = new JLabel("Player 1:       " + 0);
        p2 = new JLabel("Player 2:       " + 0);

        // ajout des score dans panel
        panel.add(p1);
        panel.add(p2);

        // ajout dans MyFrame
        add(panel, BorderLayout.EAST);
        add(table, BorderLayout.CENTER);

        // ajout des listeners
        addKeyListener(table.getListener());
        addKeyListener(table.getEnvoi());

        // visibilite
        setVisible(true);
    }


    public JLabel getP1() {
        return p1;
    }
    public void setP1(JLabel p1) {
        this.p1 = p1;
    }
    public JLabel getP2() {
        return p2;
    }
    public void setP2(JLabel p2) {
        this.p2 = p2;
    }
}
// 50