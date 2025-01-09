package DSA.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class FindCommon {
    public static void main(String args[]) {
        char []arr1 = {'a', 'a', 'c', 'd'};
        char []arr2 = {'x', 'x', 'd'};
        System.out.println(findCommonItem(arr1, arr2));
        System.out.println(findCommonItem1(arr1, arr2));
    }
    public static boolean findCommonItem(char[] arr1, char[] arr2) {
        if(arr1.length == 0 || arr2.length == 0) return false;

        HashMap<Character, Boolean> map = new HashMap<>();

        for (char c: arr1) {
            if(!map.containsKey(c)) {
                map.put(c, true);
            }
        }
        //System.out.println(map);

        for (char c: arr2) {
            if(map.containsKey(c)) return true;
        }
        return false;
    }

    public static  boolean findCommonItem1(char[] arr1, char[] arr2) {
        if(arr1.length == 0 || arr2.length == 0) return false;

        // sort the arrays O(NLogN + MLogM)
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        // User two pointers to compare
        int p1=0, p2=0;

        while(p1 < arr1.length && p2 < arr2.length) { // O(M + N) worst case
            if(arr1[p1] == arr2[p2]) return true;
            if(arr1[p1] > arr2[p2]){
                p2++;
            } else if(arr1[p1] < arr2[p2]) {
                p1++;
            }
        }
        return false;
    }
    /*
        Given 2 arrays find if there exists any common item.
        arr1 = ['a', 'b', 'c', 'd']
        arr2 = ['a', 'x', 'y']
        true

        arr1 = ['a', 'b', 'c', 'd']
        arr2 = ['w', 'x', 'y']
        false

        Clarify
        1. These arrays contains alphabets only, or can be integers, or mix and match generic type?. - alphabets only
        2. can it have duplicates in single array - yes
        3. What is the size, does it fit in memory? - for now yes!

        Solution
        1. Brute force
        O(a*b)
        SP - O(1)

        2. Better
         for arr1 -> create a hashtable
         {a: true, b:true, c: true... }
         for arr2 -> check if key exists

         O(a+b)
         Sp - O(a)

         3. What if memory cannot be handled, any solution to get rid of this space
          yes - Time complexity would increase though
          sort the array
          and use two pointers to compare
           O(NLogN + MLogM) to sort
           and O(N + M) to traverse using two pointers
     */
}
