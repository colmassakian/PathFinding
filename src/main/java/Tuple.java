public class Tuple {
    final int x;
    final int y;


    private int dist;

    Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Tuple(int minIndex) {
        x = minIndex / AStar.N;
        y = minIndex % AStar.N;
    }

    int getDist() {
        return dist;
    }

    void setDist(int dist) {
        this.dist = dist;
    }

    int getSingle() {
        return (x * AStar.N) + y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple tuple = (Tuple) o;
        return x == tuple.x &&
                y == tuple.y;
    }

    @Override
    public int hashCode() {
        return this.getSingle();
    }

    @Override
    public String toString() {
        return "Tuple{" + "x = " + x + ", y = " + y + '}';
    }
}