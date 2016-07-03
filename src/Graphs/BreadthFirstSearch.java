package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by kumar_garg on 7/3/16.
 */
public class BreadthFirstSearch {
    private boolean marked[];
    private int s;
    private int edgeTo[];

    public BreadthFirstSearch(UndirectedGraph G, int s) {
        this.edgeTo = new int[G.V()];
        this.s  = s;
        this.marked = new boolean[G.V()];

        bfs(G, s);
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    private void bfs(UndirectedGraph G, int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        marked[s] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : G.adj(v)) {
                if(!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    queue.add(w);
                }
            }
        }
    }

    public Iterable<Integer> pathTo(int v) {
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
        G.addEdge(0, 2);
        G.addEdge(2, 3);
        G.addEdge(3, 4);
        G.addEdge(0, 1);
        G.addEdge(1, 4);

        Paths p = new Paths(G, 0);

        for(int i : p.pathTo(4))
            System.out.print(i + " ");

        System.out.println();

        BreadthFirstSearch bfs = new BreadthFirstSearch(G, 0);
        for(int i : bfs.pathTo(4))
            System.out.print(i + " ");
    }
}
