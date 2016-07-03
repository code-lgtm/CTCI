package Graphs;

import java.util.Stack;

/**
 * Created by kumar_garg on 7/3/16.
 */
public class Paths {
    private int edgeTo[];
    private boolean marked[];
    private int s;

    Paths(UndirectedGraph G, int s) {
        this.edgeTo = new int[G.V()];
        this.marked = new boolean[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(UndirectedGraph G, int s) {
        marked[s] = true;

        for (int v : G.adj(s)) {
            if(!marked[v]) {
                edgeTo[v] = s;
                dfs(G, v);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if(!marked[v]) return null;
        Stack<Integer> path = new Stack<>();
        while (v != s) {
            path.push(v);
            v = edgeTo[v];
        }
        path.push(s);
        return path;
    }

    public static void  main(String[] args) {
        UndirectedGraph G = new UndirectedGraph(5);
        G.addEdge(0, 1);
        G.addEdge(1, 2);
        G.addEdge(2, 3);
        G.addEdge(0, 3);

        Paths p = new Paths(G, 0);
        System.out.println(p.hasPathTo(2));

        for(int i : p.pathTo(2))
            System.out.println(i);
    }
}
