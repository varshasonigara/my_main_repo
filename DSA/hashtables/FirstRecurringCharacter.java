package DSA.hashtables;

import java.util.HashMap;
import java.util.Map;

public class FirstRecurringCharacter {
    public static void main(String[] args) {
        int[] arr = {2,5,5,2,3,5,1,2,4};
        System.out.println(findFirstRecurring1(arr));
    }

    private static int findFirstRecurring1(int[] arr) {
        // O(N^2)
        int lowestIndex = arr.length;
        for (int i=0; i< arr.length; i++) {
            for (int j=i+1; j< arr.length; j++) {
                if(arr[i] == arr[j]) {
                    lowestIndex = Math.min(lowestIndex, j);
                }
            }
        }
        return lowestIndex == arr.length ? -1: arr[lowestIndex];
    }

    private static int findFirstRecurring(int[] arr) {
        // Loop through the array and store in  hash if i have seen it.
        // As soon as i see , return
        Map<Integer, Boolean> hash = new HashMap<>();

        // TC = O(N) SP = O(N)
        for(int i=0; i<arr.length; i++) {
            if(hash.containsKey(arr[i])) {
                return arr[i];
            }
            hash.put(arr[i], true);
        }
        return -1;
    }
}
