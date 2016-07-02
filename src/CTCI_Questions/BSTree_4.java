package CTCI_Questions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Kumar_Garg on 5/23/2016.
 */
public class BSTree_4<Key extends Comparable, Value> {
    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int count;

        Node(Key key, Value value, int count) {
            this.key = key;
            this.value = value;
            this.count = count;
        }
    }

    private Node root = null;

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private int size(Node x) {
        if(x == null) return 0;
        return x.count;
    }

    private Node put(Node x, Key key, Value value) {
        if(x == null) return new Node(key, value, 1);

        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if(cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;

        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Value get(Key key) {
        Node x = get(root, key);
        if (x == null) return null;
        return x.value;
    }

    private Node get(Node x, Key key) {
        if(x == null) return null;

        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if(cmp > 0) return  get(x.right, key);
        else return x;
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(Node x) {
        if (x == null) return;
        System.out.println(x.key);
        preorder(x.left);
        preorder(x.right);
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(Node x) {
        if (x == null) return;
        inorder(x.left);
        System.out.println(x.key);
        inorder(x.right);
    }

    public int height() {
        return height(root);
    }

    public void levelOrder() {
        levelOrder(root);
    }

    private void levelOrder(Node x) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(x);

        while (!queue.isEmpty()) {
            x = queue.poll();
            System.out.println(x.key);
            if (x.left != null) queue.add(x.left);
            if (x.right != null) queue.add(x.right);
        }
    }

    private int height(Node x) {
        if (x == null) return 0;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    public boolean isBalanced() {
        return isBalanced(root, 0, height(root));
    }

    private boolean isBalanced(Node x, int d, int height) {
        if (x == null) return true;
        if (x.left == null && x.right == null) {
            if(Math.abs(d - height) <= 1)  return true;
            else return false;
        }

        return isBalanced(x.left, d+1, height) && isBalanced(x.right, d+1, height);
    }

    public void insertSorted(BSTree_4 tree, int[] a, int left, int right) {
        if (left > right) return;
        int mid = (left + right) / 2;
        tree.put(a[mid], 0);
        insertSorted(tree, a, 0, mid - 1);
        insertSorted(tree, a, mid + 1, right);
    }


    public static void main(String[] args) {
        BSTree_4<Integer, Integer> bs = new BSTree_4<Integer, Integer>();

        bs.put(7, 1);
        bs.put(5, 2);
        bs.put(6, 3);
        bs.put(4, 4);
        bs.put(12, 5);
        bs.put(10, 6);
        bs.put(14, 7);

        bs.levelOrder();
    }
}
