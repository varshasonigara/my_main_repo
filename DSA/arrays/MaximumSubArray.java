package DSA.arrays;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(findSubarrayWithLargestSum(arr));
        System.out.println(findSubarrayWithLargestSum1(arr));
    }

    private static int findSubarrayWithLargestSum1(int[] arr) {
        // Loop the array and caluclate sum and maxSum.
        // If anytime sum < 0, say sum =0 because then that subarray will reduce our answer.
        // O(n)
        // This is kadane algorithm.
        int maxSum = Integer.MIN_VALUE;
        int sum =0;
        int start =0, end =-1;
        for(int i =0; i< arr.length; i++) {
            sum = sum + arr[i];
            if(sum > maxSum) {
                end = i;
            }
            maxSum = Math.max(maxSum, sum);

            if(sum < 0) {
                sum = 0;
                start = i+1;
            }
        }
        System.out.println(start + ": " + end); // indices of subarray with maxSum
        return maxSum;
    }


    private static int findSubarrayWithLargestSum(int[] arr) {
        // O(n^2) find all subarrays
        int maxSum =Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            int sum = 0;
            for(int j =i; j<arr.length; j++) {
                sum = sum + arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
