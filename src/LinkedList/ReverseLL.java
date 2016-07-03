package LinkedList;

/**
 * Created by kumar_garg on 7/2/16.
 */
public class ReverseLL {
    private static class Node {
        int data;
        Node next;
    }

    public static Node reverse(Node x) {
        if (x == null) return null;
        if(x.next == null) return x;

        Node newHead = reverse(x.next);

        Node child = x.next;
        Node parent = x;
        child.next = parent;
        parent.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        Node head = new Node();
        head.data = 5;

        head.next = new Node();
        head.next.data = 6;

        head.next.next = new Node();
        head.next.next.data = 7;

        Node newHead = reverse(head);
        while (newHead != null) {
            System.out.println(newHead.data);
            newHead = newHead.next;
        }

    }
}
