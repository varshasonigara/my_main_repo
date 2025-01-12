package DSA.arrays;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {3,45, 78};
        int[] arr2 = {1, 5, 45, 56, 79};
        int[] res = mergeSortedArrays(arr1, arr2);
        System.out.println(Arrays.toString(res));
    }



    private static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        // Keep pointer at both arrays and compare,
        // the smaller gets entry in new array and keep moving the pointer when we add el of one array
        // do this till all el visited

        // O(a+b) SP =O(1) resultant space = O(a+b)
        if(arr1 == null && arr2 == null) return null;
        if(arr1 == null || arr1.length==0) return arr2;
        if(arr2 ==null || arr2.length==0) return arr1;

        int m = arr1.length;
        int n = arr2.length;
        int i=0; int j=0; int k=0;
        int[] res = new int[m+n];

        while(i<m && j<n) {
            if(arr1[i] <= arr2[j]) {
                res[k] = arr1[i];
                i++;
            } else if(arr2[j] <= arr1[i]) {
                res[k] = arr2[j];
                j++;
            }
            k++;
        }

        while(i<m) {
            res[k] = arr1[i];
            i++;
        }

        while(j<n) {
            res[k] = arr2[j];
            j++;
        }
        return res;

    }



}
