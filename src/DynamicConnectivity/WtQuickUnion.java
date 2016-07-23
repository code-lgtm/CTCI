package DynamicConnectivity;

/**
 * Created by Kumar_Garg on 7/23/2016.
 */
public class WtQuickUnion {
    private int id[];
    private int size[];

    public WtQuickUnion(int N) {
        this.id = new int[N];
        this.size = new int[N];
        for (int i = 0; i < N; i++) {
            this.id[i] = i;
            this.size[i] = 1;
        }
    }

    private int root(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (size[i] > size[j]) {
            id[j] = i;
            size[i] += size[j];
        } else {
            id[i] = j;
            size[j] += size[i];
        }
    }
}
