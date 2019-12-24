import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.util.ArrayList;

class AStarPane extends JPanel {
    AStarPane() {
//        ArrayList<CellPane> cells = new ArrayList<CellPane>();
        CellPane[][] cells = new CellPane[AStar.N][AStar.N];
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
//                cells.add(cellPane);
                cells[row][col] = cellPane;
                add(cellPane, gbc);
            }
        }
        PathFinder path = new PathFinder(cells);
        path.findPath(1,2,45,45);
//        System.out.println(length);
    }
}