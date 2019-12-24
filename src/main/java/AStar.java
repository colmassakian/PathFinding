import javax.swing.*;
import java.awt.*;

public class AStar {
    static final int N = 100;
    public static void main(String[] args) {
        new AStar();
    }

    // TODO: Move to Draw class
    private AStar() {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ignored) {
                } catch (InstantiationException ignored) {
                } catch (IllegalAccessException ignored) {
                } catch (UnsupportedLookAndFeelException ignored) {
                }

                JFrame frame = new JFrame("AStar");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new AStarPane());
                frame.setPreferredSize(new Dimension(1600, 1400));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}