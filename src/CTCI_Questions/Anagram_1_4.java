package CTCI_Questions;

/**
 * Created by Kumar_Garg on 5/22/2016.
 */
public class Anagram_1_4 {
    public static boolean isAnagram(String s1, String s2) {
        int sMap1[] = new int[256];
        int sMap2[] = new int[256];

        if (s1.length() != s2.length()) return false;

        for (int i=0; i < s1.length(); i++)
            sMap1[s1.charAt(i)]++;
        for (int i=0; i < s2.length(); i++)
            sMap2[s2.charAt(i)]++;
        for (int i=0; i < 256; i++)
            if (sMap1[i] != sMap2[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("hello", "elolh"));
    }
}
