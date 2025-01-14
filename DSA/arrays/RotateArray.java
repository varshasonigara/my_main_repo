package DSA.arrays;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(rotateToRight(arr, 3)));
    }

    private static int[] rotateToRight(int[] arr, int k) {
        // Inplace solution
        int n = arr.length;
        k = k % n;
        if (k==0) return arr;
        //  o to n-k-1 -> reverse
        // n-k to n-1 -> reverse
        // 0 to n-1 -> reverse
        // O(N)
        reverse(arr, 0, n-k-1);
        reverse(arr, n-k, n-1);
        reverse(arr, 0, n-1);
        return arr;
    }

    private static void reverse(int[] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end --;
        }
    }
}
