package Graphs;

/**
 * Created by kumar_garg on 7/3/16.
 */
public class ConnectedComponents {
    private boolean marked[];
    private int count;
    private int id[];

    public ConnectedComponents(UndirectedGraph G) {
        this.marked = new boolean[G.V()];
        this.count = 0;
        this.id = new int[G.V()];

        for(int v = 0; v < G.V(); v++) {
            if(!marked[v])  {
                this.count++;
                dfs(G, v, this.count);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return this.count;
    }

    private void dfs(UndirectedGraph G, int s, int n) {
        marked[s] = true;
        id[s] = n;

        for (int v : G.adj(s)) {
            if(!marked[v]) {
                dfs(G, v, n);
            }
        }
    }

    public static void main(String[] args) {
        UndirectedGraph G = new UndirectedGraph(5);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(1, 2);
        G.addEdge(3, 4);

        ConnectedComponents cc = new ConnectedComponents(G);
        assert cc.count() == 2;
        assert cc.id(0) == 1;
        assert cc.id(3) == 2;
        assert cc.connected(0, 1);
        assert cc.connected(3, 4);
        assert !cc.connected(0, 3);

    }
}
