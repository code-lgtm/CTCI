package Strings;

/**
 * Created by Kumar_Garg on 7/7/2016.
 */
public class LSD {
    public static void main(String[] args) {
        String s[] = {"green", "greet", "great", "groat", "groan", "grown", "brown"};

        sort(s, 5);
        for(String str: s)
            System.out.println(str);

    }

    private static void sort(String[] s, int W) {
        int R = 256;
        String aux[] = new String[s.length];

        for (int i = W-1; i >= 0; i--) {
            int count[] = new int[R + 1];

            for (int j = 0; j < s.length; j++)
                count[s[j].charAt(i)+1]++;

            for (int j = 1; j < count.length; j++)
                count[j] += count[j-1];

            for (int j = 0; j < aux.length; j++)
                aux[count[s[j].charAt(i)]++] = s[j];

            for (int j = 0; j < aux.length; j++)
                s[j] = aux[j];
        }
    }
}
