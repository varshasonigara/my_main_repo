package DSA.arrays;
import java.util.*;
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 18};
        int sum = 9;
        System.out.println(Arrays.toString(twoSum(nums, sum)));
    }
    public static int[] twoSum(int[] nums, int target) {
        // [2, 7, 11, 15] sum = 9 res = 0,1
        // sort this array - O(NLogN) and use two pointer -> O(N)
        // Have i seen the sum - el , if yes what index, O(N) sp -> O(N)

        int[] res = new int[2];
        Map<Integer, Integer> bucket = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int lookFor = target - nums[i];
            if(bucket.containsKey(lookFor)) {
                res[0] =i;
                res[1] = bucket.get(lookFor);
                return res;
            }

            bucket.put(nums[i], i);
        }
        return res;
    }
}
