package misc;

import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by kumar_garg on 7/10/16.
 */

class SortByStartTime implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Integer i1[] = (Integer[]) o1;
        Integer i2[] = (Integer[]) o2;
        if(i1[0] < i2[0]) return -1;
        else if (i1[0] > i2[0]) return 1;
        return 0;
    }
}

public class MeetingPlanner {
    public static void main(String[] args) {
        Integer arrayA[][] = new Integer[4][2];
        Integer arrayB[][] = new Integer[4][2];

        arrayA[0][0] = 4;
        arrayA[0][1] = 1;

        arrayA[1][0] = 2;
        arrayA[1][1] = 12;

        arrayA[2][0] = 3;
        arrayA[2][1] = 15;

        arrayA[3][0] = 1;
        arrayA[3][1] = 12;

        arrayB[0][0] = 4;
        arrayB[0][1] = 1;

        arrayB[1][0] = 2;
        arrayB[1][1] = 12;

        arrayB[2][0] = 3;
        arrayB[2][1] = 15;

        arrayB[3][0] = 1;
        arrayB[3][1] = 12;

        Arrays.sort(arrayA, new SortByStartTime());
        Arrays.sort(arrayB, new SortByStartTime());
    }

    public static int[] planMeeting(Integer arrayA[][], Integer arrayB[][], int dur) {
        int output[] = new int[2];

        /**
         * 1. If duration of  meeting is less than dur, increment  index of that meeting
         * 2. If end time of first one is greater then start time of other, increment the index of the first one
         * 3. if duration of meeting ending first - start time of other meeting is less than sur, increment the index of the first one
         * 4. Loop while we have seen all the entries
         */

        for (int i = 0, j= 0; i < arrayA.length && j < arrayB.length;) {
            int start = Math.max(arrayA[i][0], arrayB[j][0]);
            int end = Math.min(arrayA[i][1], arrayB[j][1]);

            if (start + dur <= end)
                return new int[]{start, start + dur};
            else {
                if (arrayA[i][1] > arrayB[j][1])
                    i++;
                else
                    j++;
            }
        }

        return null;
    }
}
