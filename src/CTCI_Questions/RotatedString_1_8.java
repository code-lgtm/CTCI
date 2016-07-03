package CTCI_Questions;

/**
 * Created by Kumar_Garg on 5/22/2016.
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
 * call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
 */
public class RotatedString_1_8 {
    public static boolean rotatedString(String s1, String s2)
    {
        int len = s1.length();

        if(len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return s1s1.contains(s2);
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "waterbottlet";
        String s2 = "erbottlewatt";

        System.out.print(rotatedString(s1, s2));
    }
}
