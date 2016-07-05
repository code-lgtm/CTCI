package ShortestPaths;

import MST.IndexMinPQ;

import java.util.Stack;

/**
 * Created by Kumar_Garg on 7/4/2016.
 */
public class Dijkstra {
    private double distTo[];
    private DirectedEdge edgeTo[];
    private IndexMinPQ<Double> pq;
    private int s;

    public Dijkstra(EdgeWeightedDigraph G, int s) {
        this.pq = new IndexMinPQ<>(G.V());
        this.edgeTo = new DirectedEdge[G.V()];
        this.distTo = new double[G.V()];
        this.s = s;

        for (int i = 0; i < G.V(); i++)
            this.distTo[i] = Double.POSITIVE_INFINITY;

        this.distTo[s] = 0.0;
        dijkEager(G, s);
    }

    private void dijkEager(EdgeWeightedDigraph G, int s) {
        pq.insert(s, distTo[s]);

        while (!pq.isEmpty()) {
            int v = pq.deleteMin();
            relax(G, v);
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) {
                    pq.decreaseKey(w, distTo[w]);
                }
                else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    public boolean hasPathTo(int w) {
        return edgeTo[w] != null;
    }

    public Iterable<DirectedEdge> path(int w) {
        if(!hasPathTo(w)) return null;
        Stack<DirectedEdge> stack = new Stack<>();

        while (w != s) {
            stack.push(edgeTo[w]);
            w = edgeTo[w].from();
        }

        return stack;
    }

    public static void main(String[] args) {
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(8);
        G.addEdge(new DirectedEdge(4, 5, 0.35));
        G.addEdge(new DirectedEdge(5, 4, 0.35));
        G.addEdge(new DirectedEdge(4, 7, 0.37));
        G.addEdge(new DirectedEdge(5, 7, 0.28));
        G.addEdge(new DirectedEdge(7, 5, 0.28));
        G.addEdge(new DirectedEdge(5, 1, 0.32));
        G.addEdge(new DirectedEdge(0, 4, 0.38));
        G.addEdge(new DirectedEdge(0, 2, 0.26));
        G.addEdge(new DirectedEdge(7, 3, 0.39));
        G.addEdge(new DirectedEdge(1, 3, 0.29));
        G.addEdge(new DirectedEdge(2, 7, 0.34));
        G.addEdge(new DirectedEdge(6, 2, 0.40));
        G.addEdge(new DirectedEdge(3, 6, 0.52));
        G.addEdge(new DirectedEdge(6, 0, 0.58));
        G.addEdge(new DirectedEdge(6, 4, 0.93));

        Dijkstra dijkstra = new Dijkstra(G, 0);

        for (DirectedEdge e : dijkstra.path(6))
            System.out.println(e);
    }
}