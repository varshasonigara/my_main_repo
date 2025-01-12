package DSA.arrays;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(findSubarrayWithLargestSum(arr));
        System.out.println(findSubarrayWithLargestSum1(arr));
    }

    private static int findSubarrayWithLargestSum1(int[] arr) {

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
