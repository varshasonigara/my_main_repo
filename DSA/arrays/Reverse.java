package DSA.arrays;

import java.util.Arrays;
import java.util.Collections;

public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse("Hi My name is Varsha")); // ahsrav si eman yM iH
    }

    public static String reverse(String str) {
        // solution1 -> create a result array of same size and loop original array length-1 to 0
        // and assign chars to new array from 0 position
        // O(N), SP - O(N)

        // solution2 -> two pointers start and end, swap each char
        //O(N/2) ~ O(N) SP = O(1)

        // id String is null
        if(str == null || str.length() < 2) return str;
        char[] array = str.toCharArray();
        int l = 0; int h = array.length-1;

        while(l<h) {
            char temp = array[l];
            array[l] = array[h];
            array[h] = temp;
            l++;
            h--;
        }
        return String.valueOf(array);
    }
}
