package CTCI_Questions;

/**
 * Created by Kumar_Garg on 5/21/2016.
 */

/*
* Implement an algorithm to determine if a string has all unique characters.
* What if you can not use additional data structures?
* TODO: Use constant extra space - Bit Manipulation
*/
public class UniqueChar1_1 {
    public static boolean allUnique(String input) {
        int ascii[] = new int[256];

        for (int i=0; i < input.length(); i++) {
            ascii[input.charAt(i)]++;
        }

        for (int i=0; i < input.length(); i++) {
            if (ascii[input.charAt(i)] > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(allUnique("Hello"));
    }
}
