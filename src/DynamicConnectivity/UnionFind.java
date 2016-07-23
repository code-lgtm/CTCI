package DynamicConnectivity;

/**
 * Created by Kumar_Garg on 7/23/2016.
 */
public class UnionFind {
    private int[] id;

    UnionFind(int N) {
        this.id = new int[N];
        for (int i = 0; i < N; i++)
            this.id[i] = i;
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        if (pid == qid) return;

        for (int i = 0; i < id.length; i++)
            if (id[i] == pid)
                id[i] = qid;
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    private int find(int p) {
        return -1;
    }

    private int count() {
        return -1;
    }
}
