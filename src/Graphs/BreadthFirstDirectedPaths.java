package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Kumar_Garg on 7/5/2016.
 */
public class BreadthFirstDirectedPaths {
    private int edgeTo[];
    private boolean marked[];
    private int s;
    private int distTo[];

    public BreadthFirstDirectedPaths(Digraph G, int s) {
        this.edgeTo = new int[G.V()];
        this.marked = new boolean[G.V()];
        this.distTo = new int[G.V()];
        this.s = s;

        bfs(G, s);
    }

    private void bfs(Digraph G, int s) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            marked[v] = true;

            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    queue.add(w);
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                }
            }
        }
    }
}
