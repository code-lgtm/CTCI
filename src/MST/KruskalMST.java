package MST;

import DynamicConnectivity.WtQuickUnion;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Kumar_Garg on 7/24/2016.
 */
public class KruskalMST {
    private Queue<Edge> mst = new LinkedList<Edge>();
    private double wt = 0.0;

    public KruskalMST(EdgeWeightedGraph G) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (Edge e : G.edges())
            pq.add(e);

        WtQuickUnion uf = new WtQuickUnion(G.V());

        while (!pq.isEmpty() && mst.size() < G.V()-1) {
            Edge e = pq.poll();
            int v = e.either();
            int w = e.other(v);

            if (uf.connected(v, w))
                continue;

            uf.union(v, w);
            mst.add(e);
            wt += e.weight();
        }
    }

    public double weight() {
        return wt;
    }

    public Iterable<Edge> mst() {
        return this.mst;
    }
}
