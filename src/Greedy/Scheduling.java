package Greedy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Kumar_Garg on 6/18/2016.
 */
public class Scheduling {
    public static void main(String[] args)  throws Exception {
        PriorityQueue<Job> dPQ = new PriorityQueue<>(Collections.reverseOrder(new DiffComp()));
        PriorityQueue<Job> rPQ = new PriorityQueue<>(Collections.reverseOrder(new RatioComp()));
        BufferedReader br = new BufferedReader(new FileReader("D:\\CTCI\\src\\Greedy\\jobs.txt"));
        int jobCount  = Integer.parseInt(br.readLine());

        for (int i = 0; i < jobCount; i++) {
            String[] jobDetails = br.readLine().split(" ");
            int weight = Integer.parseInt(jobDetails[0]);
            int length = Integer.parseInt(jobDetails[1]);
            Job job1 = new Job(weight, length);
            Job job2 = new Job(weight, length);
            dPQ.add(job1);
            rPQ.add(job2);
        }

        Long dCompletionTime = 0L;
        Long wtDCompletionTime = 0L;
        while (!dPQ.isEmpty()) {
            Job job = dPQ.poll();
            dCompletionTime += job.getLength();
            wtDCompletionTime += (job.getWeight() * dCompletionTime);
        }

        Long rCompletionTime = 0L;
        Long wtRCompletionTime = 0L;
        while (!rPQ.isEmpty()) {
            Job job = rPQ.poll();
            rCompletionTime += job.getLength();
            wtRCompletionTime += (job.getWeight() * rCompletionTime);
        }

        System.out.println(wtDCompletionTime);
        System.out.println(wtRCompletionTime);

    }
}

