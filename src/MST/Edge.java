package MST;

/**
 * Created by Kumar_Garg on 6/17/2016.
 */
public class Edge implements Comparable<Edge> {
    private int v;
    private int w;
    private double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return this.v;
    }

    public int other(int vertex) {
        if(this.v == vertex) return w;
        else return v;
    }

    public int compareTo(Edge that) {
        if(this.weight == that.weight) return 0;
        else if(this.weight < that.weight) return -1;
        else return 1;
    }

    public double weight() {
        return this.weight;
    }

    public String toString() {
        return v + "---->" + w + ":wt->" + weight;
    }

}
