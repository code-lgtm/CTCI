package Greedy;

import java.util.Comparator;

/**
 * Created by Kumar_Garg on 6/18/2016.
 */
public class Job {
    private int weight;
    private int length;

    public Job(int weight, int length) {
        this.weight = weight;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return this.getWeight() + ":" + this.getLength();
    }
}

class DiffComp implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        int h1 = o1.getWeight() - o1.getLength();
        int h2 = o2.getWeight() - o2.getLength();

        if(h1 < h2) return -1;
        else if(h1 > h2) return 1;
        else {
            if (o1.getWeight() < o2.getWeight()) return -1;
            else if (o1.getWeight() > o2.getWeight()) return 1;
            else return 0;
        }
    }
}

class RatioComp implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        double h1 = o1.getWeight() * 1.0 / o1.getLength();
        double h2 = o2.getWeight() * 1.0 / o2.getLength();

        if(h1 < h2) return -1;
        else if(h1 > h2) return 1;
        else return 0;
    }
}