package Trees;

import CTCI_Questions.MatrixZero_1_7;
import com.sun.org.apache.xalan.internal.xsltc.dom.KeyIndex;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;

/**
 * Created by Kumar_Garg on 7/8/2016.
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root = null;
    Queue<Item> items;

    class Item {
        int level;
        Key sibling;
        Node node;

        public Item(Node node, int level, Key sibling) {
            this.node = node;
            this.level = level;
            this.sibling = sibling;
        }
    }

    class NodeLevel {
        Node node;
        int level;

        NodeLevel(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    class Node {
        Key key;
        Value value;
        int count;
        Node left;
        Node right;

        Node(Key key, Value value, int count) {
            this.key = key;
            this.value = value;
            this.count = count;
        }
    }

    public Value get(Key key) {
        Node x = get(root, key);

        if(x == null) return null;
        return x.value;
    }

    public int size(Node x) {
        if(x == null) return 0;
        return x.count;
    }

    private Node get(Node x, Key key) {
        if(x == null) return null;

        if(key.compareTo(x.key) < 0) return get(x.left, key);
        else if(key.compareTo(x.key) > 0) return get(x.right, key);
        return x;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if(x == null) return new Node(key, value, 1);

        if(key.compareTo(x.key) < 0) x.left = put(x.left, key, value);
        else if(key.compareTo(x.key) > 0) x.right = put(x.right, key, value);
        else x.value = value;

        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    /*
    * Traversals
    */
    public void preorder() {
        preorder(root);
    }

    private void preorder(Node x) {
        if (x == null) return;
        System.out.println(x.key);
        preorder(x.left);
        preorder(x.right);
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(Node x) {
        if (x == null) return;
        postorder(x.left);
        postorder(x.right);
        System.out.println(x.key);
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

    public Queue<Item> levelorder() {
        return levelorder(root);
    }

    private Queue<Item> levelorder(Node x) {
        if (x == null) return null;
        Queue<NodeLevel> list = new LinkedList<NodeLevel>();
        items = new LinkedList<>();

        list.add(new NodeLevel(x, 0));
        items.add(new Item(x, 0, null));
        int level = 0;

        while (!list.isEmpty()) {
            NodeLevel nodeLevel = list.poll();

            if(nodeLevel.node.left != null) {
                list.add(new NodeLevel(nodeLevel.node.left, nodeLevel.level+1));
                Node sibling = null;
                if(nodeLevel.node.right != null) sibling  = nodeLevel.node.right;
                items.add(new Item(nodeLevel.node.left, nodeLevel.level+1, sibling.key));
            }
            if(nodeLevel.node.right != null) {
                list.add(new NodeLevel(nodeLevel.node.right, nodeLevel.level+1));
                Node sibling = null;
                if(nodeLevel.node.left != null) sibling  = nodeLevel.node.left;
                items.add(new Item(nodeLevel.node.right, nodeLevel.level+1, sibling.key));
            }
        }
        return items;
    }

    public int height() {
        return height(root);
    }

    private int height(Node x) {
        if (x == null) return 0;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    public void printSiblings(Key key) {
        if (key == null) return;

        // Find the level of the key
        int level = -1;
        for (Item item : items)
            if (item.node.key == key)
                level = item.level;

        if (level == -1) return; // Key not Found

        // Print Keys at the same level
        while (!items.isEmpty()) {
            Item item = items.poll();
            if (item.level == level && item.node.key != key && item.sibling != key)
                System.out.println(item.node.key);
        }
    }

    public void printAllLevels() {
        int height = height();

        for (int i = 1; i <= height; i++)
            printGivenLevel(root, i, 1);
    }

    public void printGivenLevel(Node x, int level, int currentLevel) {
        if (x == null) return;
        if (level == currentLevel) System.out.println(x.key);
        else if(currentLevel < level) {
            printGivenLevel(x.left, level, currentLevel + 1);
            printGivenLevel(x.right, level, currentLevel + 1);
        }
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node x) {
        if(x == null) return false;

        return Math.abs(height(x.left) - height(x.right)) <= 1;
    }

    public static void main(String[] args) {
        BST<Integer, Integer> bst = new BST<>();

        bst.put(10, 3);
        bst.put(5, 3);
        bst.put(15, 3);
        bst.put(2, 3);
        bst.put(8, 3);
        bst.put(12, 3);
        bst.put(18, 3);
        bst.put(1, 3);
        bst.put(3, 3);
        bst.put(7, 3);
        bst.put(9, 3);
        bst.put(11, 3);
        bst.put(14, 3);
        bst.put(17, 3);
        bst.put(20, 3);

        bst.levelorder();
        //bst.printSiblings(7);
        //System.out.println(bst.height());
        bst.printAllLevels();
    }
}
