package MajorityElementII;

import java.util.LinkedList;
import java.util.List;

/**
 * moore voting
 * To find the majority element, we can subtract k different elements each time.
 * if there is a majority element(portion > 1/3) and we subtract three different elements each time,
 * then the majority element absolutely will be reserved(numerator subtracts 1 or 0, denominator subtracts 3) in the result set.
 * In the end we will have two elements and the majority element(s) will be in the result set(2 elements set).
 */
public class Solution {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> results = new LinkedList<>();
        int candidate1 = 0, candidate2 = 1;  // to make sure that the starting numbers are different, so that we can follow the proof above.
        int count1 = 0, count2 = 0;
        for(int num : nums){
            if(num == candidate1){
                count1++;
            } else if (num == candidate2){
                count2++;
            } else if (count1 == 0){
                candidate1 = num;
                count1++;
            } else if (count2 == 0){
                candidate2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        // Now we need another pass to verify if the two are majority elements.
        // we can count their occurrences and compare with n/3
        // we can also count an occurrence of a candidate as 2, otherwise 1, then compare the result with 0.
        // e.g. count+=2 if equivalent with candidate, count-- if not equivalent.
        count1 = 0;
        count2 = 0;
        for(int num : nums){
            if(num == candidate1){
                count1++;
            } else if(num == candidate2){
                count2++;
            }
        }
        if(count1 > nums.length/3){
            results.add(candidate1);
        }
        if(count2 > nums.length/3){
            results.add(candidate2);
        }
        return  results;
    }
}