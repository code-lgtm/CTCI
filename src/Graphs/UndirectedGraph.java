package Graphs;

import java.util.LinkedList;

/**
 * Created by kumar_garg on 7/3/16.
 */
public class UndirectedGraph {
    private int V;
    private int E;
    private LinkedList<Integer> adj[];


    public UndirectedGraph(int V) {
        this.V = V;
        this.E = 0;

        this.adj = new LinkedList[V];
        for (int i = 0; i < V; i++)
            this.adj[i] = new LinkedList<Integer>();
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(int v, int w) {
        this.adj[v].add(w);
        this.adj[w].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return this.adj[v];
    }
}
