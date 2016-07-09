package Trees;

/**
 * Created by Kumar_Garg on 7/8/2016.
 */
public class Trie<Value> {
    private static final int R = 256;
    private Node root;
    private int n;

    static class Node {
        Object value;
        private Node next[] = new Node[R];
    }

    public Trie() {
    }

    public Value get(String key)
    {
        Node x = get(root, key, 0);
        if(x == null) return null;
        else return (Value) x.value;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if(d == key.length()) return x;

        return get(x.next[key.charAt(d)], key, d+1);
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {
        if (x == null)  x = new Node();

        if (d == key.length()) {
            if (x.value == null) n++;
            x.value = val;
            return x;
        }


        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d+1);

        return x;
    }

}
