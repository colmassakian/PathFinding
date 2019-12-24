import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AStar {
    static final int N = 100;
    static boolean makeBorder;

    public static void main(String[] args) {
        new AStar();
    }

    private AStar() {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ignored) {
                }

                JFrame frame = new JFrame("AStar");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new AStarPane());
                frame.setPreferredSize(new Dimension(1600, 1400));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.addKeyListener(new KeyListener() {
                    public void keyPressed(KeyEvent e) {
                        if(e.getKeyCode() ==KeyEvent.VK_B)
                            makeBorder = !makeBorder;
                    }

                    public void keyReleased(KeyEvent e) {}

                    public void keyTyped(KeyEvent e) {}
                });
                frame.setVisible(true);

            }
        });
    }
}