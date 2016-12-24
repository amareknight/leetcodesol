package MajorityElement;

/**
 * Four methods:
 * 1. sort, get size/2
 * 2. hashtable, store <num,count>
 * 3. moore voting
 * 4. bit operation
 */
// multiple solutions
public class Solution {
    /* moore voting */
    public int majorityElement(int[] nums) {
        int majority = nums[0], count = 1;
        for (int i = 1; i<nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
                count++;
            } else {
                if(nums[i] == majority) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return majority;
    }

    /* bit operation */
    public int majorityElement1(int[] nums) {
        final int SIZE = 32;
        int[] bitCount = new int[SIZE];
        for(int num : nums) {
            for(int i=0; i<SIZE; i++){
                if( ((num>>i) & 1) == 1) {
                    bitCount[i]++;
                }
            }
        }
        int majority = 0;
        for(int i=0; i<SIZE; i++) {
            if(bitCount[i] > nums.length/2) {
                bitCount[i] = 1;
            } else {
                bitCount[i] = 0;
            }
            majority += bitCount[i] * (1<<i); // review logic again
        }
        return majority;
    }
}