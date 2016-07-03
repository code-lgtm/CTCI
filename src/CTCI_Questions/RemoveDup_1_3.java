package CTCI_Questions;

/**
 * Created by Kumar_Garg on 5/21/2016.
 */
public class RemoveDup_1_3 {
    public static char[] remDup(char[] input) {
        if (input == null) return null;
        int length = input.length;
        int tail = 1;

        for (int i = 1; i < length; i++) {
            int j = 0;
            for (j=0; j < tail; j++)
                if (input[i] == input[j]) break;
            if (j == tail)
                input[tail++] = input[i];
        }
        input[tail] = 0;
        return input;
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "aaaa";
        String s3 = null;
        String s4 = "aaabbb";

//        System.out.println(remDup(s1.toCharArray()));
//        System.out.println(remDup(s2.toCharArray()));
//        System.out.println(remDup(s3.toCharArray()));
//        System.out.println(remDup(s4.toCharArray()));
//
        System.out.println(s1.toCharArray().length);
        for(char c : s1.toCharArray())
            System.out.println(c);

    }
}

/*
* Approach:
* 1. Include two iterators
* 2. First i would go through the length of string in the outer loop
* 3. Second j would contain the index till when the unique characters have been identified
* 4. Iterate i from 0 to length of string
* 5. In Inside loop, from from 0 to j, check if the input[i] matches with input[j]
* 6. If not, increment i and go to step 5
* 7. If yes, what to do with empty space? shift all elements at right side of i by 1 space
*   hello
*/