import javax.swing.*;
import java.awt.*;

public class AStar {
    public static final int N = 100;
    public static void main(String[] args) {
        new AStar();
    }

    // TODO: Move to Draw class
    public AStar() {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("AStar");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new AStarPane());
                frame.setPreferredSize(new Dimension(1600, 1400));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
//                int ind = findPath(1,1, 8, 8);
//                cells.get(ind).setColor();
            }
        });
    }
}