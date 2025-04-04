package DSA.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class Leetcode175 {
    public static void main(String[] args) {
//        int[] nums = {0, 1, 2, 3, 3, 0, 2, 7, 1};
//        System.out.println(removeElement(nums, 3));
//
        int[] nums = {0, 0, 1, 1, 4,1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        // 0, 0, 1, 1, 1, 1, 2, 3, 3
        // 0, 0, 1, 1, 2, 3, 3
        // cnt <= 2 and same element => allow
        // other elment cnt = 1 => allow

        HashMap<Integer,Integer> map = new HashMap<>();
        int index =0;
        for(int i=0; i<nums.length;i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], i);
                nums[index] = nums[i];
                index++;
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(index);

//        int index = 1; int el = nums[0], cnt = 1;
//        for(int i = 1; i< nums.length; i++) {
//            if(nums[i] == el && cnt <2) {
//                // allow
//                nums[index] = nums[i];
//                index++;
//                cnt++;
//            } else if(nums[i] != el) {
//                cnt =1;
//                el = nums[i];
//                //allow
//                nums[index] = nums[i];
//                index++;
//            }
//        }
//        System.out.println(Arrays.toString(nums));
        return index;
    }

    public static int removeElement(int[] nums, int val) {
        // 0, 1, 2, 3, 3, 0, 2, 7, 1 val = 3
        // 0, 1, 2, 0, 2, 7, 1, (7, 1)
        // First loop through array and set index =0;
        // keep filling the index iteration with elements not equal to given value

        int p1 = 0;
        for (int i =0; i< nums.length; i++) {
            if(nums[i] != val) {
                nums[p1] = nums[i];
                p1++;
            }
        }
        return p1;
    }
}
