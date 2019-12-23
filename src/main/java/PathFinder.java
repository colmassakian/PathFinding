import java.util.ArrayList;

public class PathFinder {
    ArrayList<CellPane> cells = new ArrayList<CellPane>();
    public PathFinder(ArrayList<CellPane> cells) {
        this.cells = cells;
    }

    public int findPath(int startX, int startY, int endX, int endY) {
        int adjIndex;

        for (int i = 0; i < AStar.N; i ++)
        {
            for (int j = 0; j < AStar.N; j ++)
            {
                adjIndex = (i * AStar.N) + j;
                if(adjIndex % 2 == 0)
                    cells.get(adjIndex).setColor();
            }
        }
        return 0;
    }
}
