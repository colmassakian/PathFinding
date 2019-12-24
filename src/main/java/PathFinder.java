import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class PathFinder {
    CellPane[][] cells;
    private Timer timer;
    private int delay = 1500; // every 1 second
    private Color border = Color.BLACK;

    PathFinder(CellPane[][] cells) {
        this.cells = cells;
        timer = new Timer(delay, action);
        timer.setInitialDelay(0);
        timer.start();
    }

    private ActionListener action = new ActionListener()
    {
        public void actionPerformed(ActionEvent event)
        {
//            if(i == 0)
//            {
//                timer.stop();
//            }
//            else
//            {
//                cells[1][1].setColor(c);
//            }
        }
    };

    int findPath(int startX, int startY, int endX, int endY) {
        // Set borders to be white
        for (int i = 0; i < AStar.N; i ++)
        {
            for (int j = 0; j < AStar.N; j ++)
            {
                if(i == 0 || i == AStar.N - 1 || j == 0 || j == AStar.N - 1)
                    cells[i][j].setColor(border);
            }
        }

        for (int i = 0; i < 5; i ++)
            System.out.println("IntelliJ Test");
        return dijkstra(startX, startY, endX, endY);
    }

    private int dijkstra(int startX, int startY, int endX, int endY)
    {
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
                return dist[minIndex];

            // Get neighbors of current node and update their cost if necessary
            neighbors = getNeighbors(min);
            for (Tuple neighbor : neighbors) {
                neighborIndex = neighbor.getSingle();
                if (dist[minIndex] + cost < dist[neighborIndex])
                    dist[neighborIndex] = dist[minIndex] + cost;

            }
        }
//        action.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null) {});
        return -1;
    }

    // Return the indices of all neighboring nodes that are in bounds and not borders
    private ArrayList<Tuple> getNeighbors(Tuple minIndex) {
        ArrayList<Tuple> neighbors = new ArrayList<Tuple>();

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
