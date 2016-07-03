package Graphs;

/**
 * Created by kumar_garg on 7/3/16.
 */
public class Search {
    private boolean marked[];
    private int count;

    Search(UndirectedGraph g, int s) {
        this.marked = new boolean[g.V()];
        this.count = 0;
        dfs(g, s);
    }

    private void dfs(UndirectedGraph g, int s) {
        marked[s] = true;
        count++;

        for (int v : g.adj(s)) {
            if (!marked[v]) {
                dfs(g, v);
            }
        }
    }

    boolean marked(int v) {
        return marked[v];
    }

    int count() {
        return this.count;
    }

    public static void  main(String[] args) {
        UndirectedGraph G = new UndirectedGraph(5);
        G.addEdge(0, 1);
        G.addEdge(1, 2);
        G.addEdge(2, 3);
        G.addEdge(0, 3);

        Search s = new Search(G, 1);
        assert s.count() == 4 : "count";
        assert !s.marked(4) : "not connected";
        assert s.marked(2) : "connected";

        if(s.count == G.V()) System.out.println("Connected");
        else System.out.println("Not Connected");
    }
}
