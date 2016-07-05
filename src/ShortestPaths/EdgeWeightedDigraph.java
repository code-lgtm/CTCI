package ShortestPaths;

import java.util.LinkedList;

/**
 * Created by Kumar_Garg on 7/4/2016.
 */
public class EdgeWeightedDigraph {
    private LinkedList<DirectedEdge> adj[];
    private int V;
    private int E;


    public EdgeWeightedDigraph(int V) {
        this.adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            this.adj[i] = new LinkedList<>();
        }
        this.V = V;
        this.E = 0;
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(DirectedEdge e) {
        this.adj[e.from()].add(e);
        this.E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return this.adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        LinkedList<DirectedEdge> list = new LinkedList<>();
        for (int v = 0; v < this.V; v++) {
            for(DirectedEdge e : this.adj[v]) {
                list.add(e);
            }
        }
        return list;
    }
}
