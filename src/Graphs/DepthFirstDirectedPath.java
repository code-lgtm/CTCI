package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Kumar_Garg on 7/5/2016.
 */
public class DepthFirstDirectedPath {
    private int edgeTo[];
    private boolean marked[];
    private int s;
    private Queue<Integer> postOrder;


    public DepthFirstDirectedPath(Digraph G, int s) {
        this.edgeTo = new int[G.V()];
        this.marked = new boolean[G.V()];
        this.s = s;
        postOrder = new LinkedList<>();
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;

        for (int w : G.adj(v)) {
            if(!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }

        postOrder.add(v);
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Stack<Integer> reversePostOrder() {
        Stack<Integer> stack = new Stack<>();

        for (int i : postOrder)
            stack.push(i);
        return stack;
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;

        Stack<Integer> stack = new Stack<>();
        while (v != s) {
            stack.push(v);
            v = edgeTo[v];
        }
        stack.push(s);
        return stack;
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(13);
        G.addEdge(2, 3);
        G.addEdge(0, 6);
        G.addEdge(0, 1);
        G.addEdge(2, 0);
        G.addEdge(11, 12);
        G.addEdge(9, 12);
        G.addEdge(9, 10);
        G.addEdge(9, 11);
        G.addEdge(3, 5);
        G.addEdge(8, 7);
        G.addEdge(5, 4);
        G.addEdge(0, 5);
        G.addEdge(6, 4);
        G.addEdge(6, 9);
        G.addEdge(7, 6);

        DepthFirstDirectedPath depthFirstDirectedPath = new DepthFirstDirectedPath(G, 0);
        Stack<Integer> reversePostOrder = depthFirstDirectedPath.reversePostOrder();

        while (!reversePostOrder.isEmpty())
            System.out.print(reversePostOrder.pop() + " ");
    }
}
