import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AStar {
    static final int N = 100;
    static int setStart = 0;
    static int setEnd = 0;
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
                AStarPane starPane = new AStarPane();
                frame.add(starPane);
                frame.setPreferredSize(new Dimension(1600, 1400));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.addKeyListener(new KeyListener() {
                    public void keyPressed(KeyEvent e) {
                        if(e.getKeyCode() == KeyEvent.VK_B)
                            makeBorder = !makeBorder;
                    }

                    public void keyReleased(KeyEvent e) {}

                    public void keyTyped(KeyEvent e) {}
                });
                frame.setFocusable(true);
                JButton setStartPoint = new JButton("Set Start Point");
                setStartPoint.addActionListener(e -> setStart ++);
                setStartPoint.setFocusable(false);
                JButton setEndPoint = new JButton("Set End Point");
                setEndPoint.addActionListener(e -> setEnd ++);
                setEndPoint.setFocusable(false);
//                JButton selector = new JButton("Dijkstra/AStar");
                JButton start = new JButton("START!");
                start.addActionListener(e -> starPane.startPathFinder());
                start.setFocusable(false);
                JPanel panel1 = new JPanel();
                panel1.add(setStartPoint);
                panel1.add(setEndPoint);
//                panel1.add(selector);
                panel1.add(start);
                frame.add(panel1, BorderLayout.NORTH);  // add the panel to the frame
//                frame.setFocusable(true);
                frame.setVisible(true);

            }
        });
    }
}