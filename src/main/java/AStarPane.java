import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class AStarPane extends JPanel {
    private CellPane[][] cells = new CellPane[AStar.N][AStar.N];
    AStarPane() {

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        for (int row = 0; row < AStar.N; row++) {
            for (int col = 0; col < AStar.N; col++) {
                gbc.gridx = col;
                gbc.gridy = row;

                CellPane cellPane = new CellPane();

                Border border;
                if (row < 4) {
                    if (col < 4) {
                        border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
                    }
                } else {
                    if (col < 4) {
                        border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
                    }
                }
                cellPane.setBorder(border);
                cells[row][col] = cellPane;
                if(row == 0 || row == AStar.N - 1 || col == 0 || col == AStar.N - 1)
                    cells[row][col].setColor(Color.BLACK);
                add(cellPane, gbc);
            }
        }
    }

    void startPathFinder()
    {
        PathFinder path = new PathFinder(cells);
        path.findPath(45,45,85,85);
    }
}