package MST;

import java.util.LinkedList;

/**
 * Created by Kumar_Garg on 6/17/2016.
 */
public class EdgeWeightedGraph {
    private final LinkedList<Edge> adj[];
    private LinkedList<Edge> edges;
    private final int V;
    private int E;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.adj = new LinkedList[V];
        this.edges = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            this.adj[i] = new LinkedList<Edge>();
        }
        this.E = 0;
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        this.adj[v].add(e);
        this.adj[w].add(e);
        edges.add(e);
        this.E++;
    }

    public Iterable<Edge> adj(int v) {
        return this.adj[v];
    }

    public Iterable<Edge> edges() {
        return edges;
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }
}
