package DSA.arrays;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = {4,2,4,0,0,3,0,5,1,0};
        //System.out.println(Arrays.toString(moveZerosToEnd(arr)));
        System.out.println(Arrays.toString(moveZerosToEnd1(arr)));
    }

    private static int[] moveZerosToEnd1(int[] arr) {
      // Think of two pointer approach
      // one pointer is navigating the array o to n-1
      // second pointer is hopping on non zero, when found, swap.
        // continue till second pointer reaches till end.
        // O(N)

        if(arr.length <=1) return arr;
        int p1 = 0; int p2 = 1;
        int n = arr.length;
        while(p2 < n && p1 <n) {
            if(arr[p1] == 0) {
                while(p2<n && arr[p2] ==0) {
                    p2++;
                }
                if(p2 < n) {
                    int temp = arr[p1];
                    arr[p1] = arr[p2];
                    arr[p2] = temp;
                }
            }
            p1++;p2++;
        }
        return arr;
    }

    private static int[] moveZerosToEnd(int[] arr) {
        // Nested loop , fix each ith index from first loop and swap zero with first non zero.
        // O(N^2)

        for(int i =0; i< arr.length; i++) {
            for (int j =i+1; j< arr.length; j++) {
                if(arr[i] !=0) break;
                else { // arr[i] is zero
                    if(arr[j] !=0) {
                        // swap arr[i] with arr[j]
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        break;
                    }
                }
                //System.out.println(Arrays.toString(arr));
            }
        }
        return arr;
    }
}
