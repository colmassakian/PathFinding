import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class PathFinder {
    private CellPane[][] cells;
    private int straightDist;
    private Color border = Color.BLACK;

    PathFinder(CellPane[][] cells) {
        this.cells = cells;
    }

    class DijkstraWorker extends SwingWorker<Void, Tuple>
    {
        protected Void doInBackground() throws Exception
        {
            int startX = 40;
            int startY = 40;
            int endX = 60;
            int endY = 60;
            straightDist = getStraightLineDist(startX, startY, endX, endY);
            int numNodes = AStar.N * AStar.N;

            Tuple min;
            int minIndex, neighborIndex;
            int cost = 1;
            int dist[] = new int[numNodes];
            boolean visited[] = new boolean[numNodes];
            ArrayList<Tuple> neighbors;

            Tuple start = new Tuple(startX, startY);
            Tuple end = new Tuple(endX, endY);
            cells[startX][startY].setColor(Color.GREEN);
            cells[endX][endY].setColor(Color.RED);

            // Initial Dijkstra conditions
            for (int i = 0; i < numNodes; i ++)
            {
                dist[i] = Integer.MAX_VALUE;
                visited[i] = false;
            }

            dist[start.getSingle()] = 0;
            // Continue while there are unvisited nodes
            while ((min = getMin(dist, visited, numNodes)) != null)
            {
                minIndex = min.getSingle();
                visited[minIndex] = true;
                // If we visit the end we can stop searching
                if(min.equals(end))
                    return null;

                // Get neighbors of current node and update their cost if necessary
                neighbors = getNeighbors(min);
                for (Tuple neighbor : neighbors) {
                    neighborIndex = neighbor.getSingle();
                    if (dist[minIndex] + cost < dist[neighborIndex])
                        dist[neighborIndex] = dist[minIndex] + cost;
                    neighbor.setDist(dist[neighborIndex]);
                    Thread.sleep(1);
                    publish(neighbor);
                }
            }
            return null;
        }

        protected void process(List<Tuple> pairs) {
            double normal;
            for (Tuple pair : pairs) {
                // Add gradient while searching based on distance
                normal = ((double) pair.dist / straightDist) * 255;
                if(normal > 255) { normal = 255;}
                cells[pair.x][pair.y].setColor(new Color(0, (int) normal / 2, (int) normal));
            }
        }
    }

    private int getStraightLineDist(int startX, int startY, int endX, int endY) {
        int xDiff = endX - startX;
        int yDiff = endY - endX;
        return (int) Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
    }

    void findPath(int startX, int startY, int endX, int endY) {
        // Set borders to be white
        for (int i = 0; i < AStar.N; i ++)
        {
            for (int j = 0; j < AStar.N; j ++)
            {
                if(i == 0 || i == AStar.N - 1 || j == 0 || j == AStar.N - 1)
                    cells[i][j].setColor(border);
            }
        }

        new DijkstraWorker().execute();
//        return dijkstra(startX, startY, endX, endY);
    }

    // Return the indices of all neighboring nodes that are in bounds and not borders
    private ArrayList<Tuple> getNeighbors(Tuple minIndex) {
        ArrayList<Tuple> neighbors = new ArrayList<>();

        for (int i = -1; i <= 1; i ++)
        {
            for (int j = -1; j <= 1; j ++)
            {
                // Check if index is in bounds
                if(minIndex.x + i >= 0 && minIndex.x + i <= AStar.N - 1 && minIndex.y + j >= 0 && minIndex.y + j <= AStar.N - 1)
                {
                    // Check if cell is a border
                    if(cells[minIndex.x + i][minIndex.y + j].getBackground() != border)
                        neighbors.add(new Tuple(minIndex.x + i, minIndex.y + j));
                }
            }
        }
        return neighbors;
    }

    // Return the unvisited node with the lowest cost
    private Tuple getMin(int[] dist, boolean[] visited, int numNodes) {

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < numNodes; i ++)
        {
            if(!visited[i] && dist[i] < min)
            {
                min = dist[i];
                minIndex = i;
            }
        }

        if(minIndex != -1)
            return new Tuple(minIndex);
        else
            return null;
    }
}
