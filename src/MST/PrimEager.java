package MST;

import java.util.LinkedList;

/**
 * Created by Kumar_Garg on 6/25/2016.
 */
public class PrimEager {
    private boolean marked[];
    private LinkedList<Edge> mst;
    private double weight;
    private IndexMinPQ<Double> pq;
    private Edge edgeTo[];
    private double distTo[];

    public PrimEager(EdgeWeightedGraph G) {
        pq = new IndexMinPQ<Double>(G.V());
        mst = new LinkedList<>();
        weight = 0.0;
        distTo = new double[G.V()];
        edgeTo = new Edge[G.V()];
        marked = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++)
            distTo[i] = Double.POSITIVE_INFINITY;

        for (int i = 0; i < G.V(); i++)
            if (!marked[i])
                prim(i, G);
    }

    public void prim(int s, EdgeWeightedGraph G) {
        visit(s, G);

        while (!pq.isEmpty()) {
            int v = pq.deleteMin();
            if (marked[v]) continue;
            weight += edgeTo[v].weight();
            mst.add(edgeTo[v]);
            visit(v, G);
        }
    }

    public double weight() {
        return this.weight;
    }

    public Iterable<Edge> mst() {
        return mst;
    }

    public void visit(int v, EdgeWeightedGraph G) {
        marked[v] = true;

        for(Edge edge: G.adj(v)) {
            int w = edge.other(v);
            if (marked[w]) continue;
            double edgeWt = edge.weight();
            if (!pq.contains(w)) {
                pq.insert(w, edgeWt);
                edgeTo[w] = edge;
                distTo[w] = edgeWt;
            }
            else if (edgeWt < distTo[w]) {
                pq.decreaseKey(w, edgeWt);
                edgeTo[w] = edge;
                distTo[w] = edgeWt;
            }
        }
    }

    public static void main(String[] args) {
        EdgeWeightedGraph G = new EdgeWeightedGraph(8);
        Edge e1 = new Edge(4, 5, 0.35);
        Edge e2 = new Edge(4, 7, 0.37);
        Edge e3 = new Edge(5, 7, 0.28);
        Edge e4 = new Edge(0, 7, 0.16);
        Edge e5 = new Edge(1, 5, 0.32);
        Edge e6 = new Edge(0, 4, 0.38);
        Edge e7 = new Edge(2, 3, 0.17);
        Edge e8 = new Edge(1, 7, 0.19);
        Edge e10 = new Edge(0, 2, 0.26);
        Edge e11 = new Edge(1, 2, 0.36);
        Edge e12 = new Edge(1, 3, 0.29);
        Edge e13 = new Edge(2, 7, 0.34);
        Edge e14 = new Edge(6, 2, 0.40);
        Edge e15 = new Edge(3, 6, 0.52);
        Edge e9 = new Edge(6, 0, 0.58);
        Edge e16 = new Edge(6, 4, 0.93);

       /*
 *  0-7 0.16000
 *  1-7 0.19000
 *  0-2 0.26000
 *  2-3 0.17000
 *  5-7 0.28000
 *  4-5 0.35000
 *  6-2 0.40000
 *  1.81000
        */


        G.addEdge(e1);
        G.addEdge(e2);
        G.addEdge(e3);
        G.addEdge(e4);
        G.addEdge(e5);
        G.addEdge(e6);
        G.addEdge(e7);
        G.addEdge(e8);
        G.addEdge(e9);
        G.addEdge(e10);
        G.addEdge(e11);
        G.addEdge(e12);
        G.addEdge(e13);
        G.addEdge(e14);
        G.addEdge(e15);
        G.addEdge(e16);


        PrimEager mst = new PrimEager(G);
        for (Edge e : mst.mst()) {
            System.out.println(e);
        }

        System.out.println(mst.weight());
    }
}
