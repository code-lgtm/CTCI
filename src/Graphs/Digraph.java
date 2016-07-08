package Graphs;

import java.util.LinkedList;

/**
 * Created by Kumar_Garg on 7/5/2016.
 */
public class Digraph {
    private int V;
    private int E;
    private LinkedList<Integer> adj[];
    private int indegree[];

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new LinkedList[this.V];
        this.indegree = new int[this.V];
        for (int i = 0; i < this.V; i++)
            this.adj[i] = new LinkedList<>();
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(int v, int w) {
        this.adj[v].add(w);
        this.E++;
        this.indegree[w]++;
    }

    public Iterable<Integer> adj(int v) {
        return this.adj[v];
    }

    public int indegree(int v) {
        return this.indegree[v];
    }

    private int outdegree(int v) {
        return this.adj[v].size();
    }
}
