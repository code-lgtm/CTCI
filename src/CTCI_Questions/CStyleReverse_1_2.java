package CTCI_Questions;

/**
 * Created by Kumar_Garg on 5/21/2016.
 */
public class CStyleReverse_1_2 {
}

//#include <stdio.h>
//        #include <stdlib.h>
//        #include <string.h>
//
//        char* reverse(char *input)
//        {
//        int l = 0;
//        int i;
//        int j;
//        char *x = input;
//
//        while(*x)
//        {
//        l++;
//        x++;
//        }
//
//        for(i=0, j=l-1; i<l/2; i++,j--)
//        {
//        char t = input[i];
//        input[i] = input[j];
//        input[j] = t;
//        }
//
//        return input;
//        }
//
//        int main()
//        {
//        char* x = (char *) malloc(10 * sizeof(char));
//
//        strcpy(x, "Hello");
//        printf("%s", reverse(x));
//        free(x);
//        }
