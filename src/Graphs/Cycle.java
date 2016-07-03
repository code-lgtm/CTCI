package Graphs;

import java.util.Stack;

/**
 * Created by kumar_garg on 7/3/16.
 */
public class Cycle {
    private Stack<Integer> cycle;
    private int edgeTo[];
    private boolean marked[];

    public Cycle(UndirectedGraph G) {
        this.edgeTo = new int[G.V()];
        this.marked = new boolean[G.V()];

        for(int v = 0; v < G.V(); v++)
            if(!marked[v]) dfs(G, -1, v);
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return this.cycle;
    }

    public void dfs(UndirectedGraph G, int u, int v) { // u is kept to see where v came from
        marked[v] = true;

        for (int w : G.adj(v)) {
            if (cycle != null) return;

            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, v, w);
            }
            else if(u != w) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
         }
    }

    public static void main(String[] args) {
        UndirectedGraph G1 = new UndirectedGraph(3);
        G1.addEdge(0, 1);
        G1.addEdge(1, 2);
        G1.addEdge(2, 0);

        Cycle cycle = new Cycle(G1);
        assert cycle.hasCycle();
        for(int i : cycle.cycle())
            System.out.print(i + " ");

        UndirectedGraph G2 = new UndirectedGraph(3);
        G2.addEdge(0, 1);
        G2.addEdge(1, 2);

        Cycle cycle2 = new Cycle(G2);
        assert !cycle2.hasCycle();

    }
}
