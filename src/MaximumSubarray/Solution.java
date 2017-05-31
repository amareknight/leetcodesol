package MaximumSubarray;

import java.util.Arrays;

/**
 * 1. divide and conquer, nlogn
 * 2. dp, n, maxSum&maxSumEndingHere
 * 3. dp, only store previous values instead of entire intermediate array
 * 3 is a space-optimized version of 2, it's still dp. It's also called Kadane's algorithm.
 * https://zh.wikipedia.org/wiki/%E6%9C%80%E5%A4%A7%E5%AD%90%E6%95%B0%E5%88%97%E9%97%AE%E9%A2%98
 * The solution in wikipedia shows two variations that whether it allows returning empty array.
 */
// mistake made : result should contain at least one element (even if it's negative)
// pay attention to sum initialization (not initialized as zero, but as an element's value)
// pay attention to comparing values.
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int mid = nums.length/2;
        int[] leftSubArray = Arrays.copyOfRange(nums,0, mid);
        int maxLeft = maxSubArray(leftSubArray);
        int[] rightSubArray = Arrays.copyOfRange(nums, mid, nums.length);
        int maxRight = maxSubArray(rightSubArray);
        int maxSum = maxLeft > maxRight ? maxLeft : maxRight;

        int maxSumToLeft = leftSubArray[leftSubArray.length - 1];
        int sum = 0;
        for (int i = leftSubArray.length - 1; i >= 0; i--) {
            sum += leftSubArray[i];
            maxSumToLeft = sum > maxSumToLeft ? sum : maxSumToLeft;
        }

        int maxSumToRight = rightSubArray[0];
        sum = 0;
        for (int i = 0; i < rightSubArray.length; i++) {
            sum += rightSubArray[i];
            maxSumToRight = sum > maxSumToRight ? sum : maxSumToRight;
        }

        int maxMiddle = maxSumToLeft + maxSumToRight;
        return maxSum > maxMiddle ? maxSum : maxMiddle;
    }
    public int maxSubArray1(int[] nums) {
        int[] maxSum = new int[nums.length];
        int[] maxSumEndingHere = new int[nums.length];
        maxSum[0] = nums[0];
        maxSumEndingHere[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSumEndingHere[i] = maxSumEndingHere[i-1] > 0 ? maxSumEndingHere[i-1] + nums[i]: nums[i]; //mistake made
            maxSum[i] = maxSum[i-1] > maxSumEndingHere[i] ? maxSum[i-1] : maxSumEndingHere[i];
        }
        return maxSum[nums.length - 1];
    }
    public int maxSubArray2(int[] nums) {
        int maxSumPrev = nums[0];
        int maxSumEndingHerePrev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxSumEndingHerePrev = maxSumEndingHerePrev > 0 ? maxSumEndingHerePrev + nums[i] : nums[i]; //mistake made
            maxSumPrev = maxSumPrev > maxSumEndingHerePrev ? maxSumPrev : maxSumEndingHerePrev;
        }
        return maxSumPrev;
    }
}