package MST;

import java.util.Iterator;

/**
 * Created by Kumar_Garg on 6/17/2016.
 */
public class Bag<Item> implements Iterable<Item> {
    private Item items[];
    private int N = 0;

    public Bag() {
        items = (Item []) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void add(Item item) {
        if(N == items.length) resize(2 * N);
        items[N++] = item;
    }

    private void resize(int capacity) {
        Item copy[] = (Item []) new Object[capacity];
        for (int i = 0; i < items.length;i++)
            copy[i] = items[i];
        items = copy;
    }

    @Override
    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item> {
        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return items[--i];
        }
    }

    public static void main(String[] args) {
        Bag<Integer> bag = new Bag<>();
        bag.add(5);
        bag.add(7);
        bag.add(8);

        for (int i : bag)
            System.out.println(i);
    }
}
