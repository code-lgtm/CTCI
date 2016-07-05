package ShortestPaths;

/**
 * Created by Kumar_Garg on 7/4/2016.
 */
public class DirectedEdge {
    private int from;
    private int to;
    private double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.from = v;
        this.to = w;
        this.weight = weight;
    }

    public double weight() {
        return this.weight;
    }

    public int from() {
        return this.from;
    }

    public int to() {
        return this.to;
    }

    public String toString() {
        return from + "->" + to + String.format("%5.2f", weight);
    }

    public static void main(String[] args) {
        DirectedEdge e = new DirectedEdge(12, 34, 5.67);
        System.out.println(e);
    }
}
