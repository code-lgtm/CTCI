package MST;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Kumar_Garg on 6/18/2016.
 */
public class DAAExPrimAlgo {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\CTCI\\src\\MST\\input.txt"));
        String graphDetails[] = reader.readLine().split(" ");
        int V = Integer.parseInt(graphDetails[0]);
        int E = Integer.parseInt(graphDetails[1]);

        EdgeWeightedGraph G = new EdgeWeightedGraph(V);
        for (int i=0; i < E; i++) {
            String edgeDetails[] = reader.readLine().split(" ");
            int v = Integer.parseInt(edgeDetails[0]) - 1; // Subtracting 1 for zero based indexes
            int w = Integer.parseInt(edgeDetails[1]) - 1; // Subtracting 1 for zero based indexes
            int wt = Integer.parseInt(edgeDetails[2]);
            Edge e = new Edge(v, w, wt);
            G.addEdge(e);
        }

        PrimLazy mst = new PrimLazy(G);
        //PrimEager mst = new PrimEager(G);
        System.out.println(mst.weight());
    }
}
