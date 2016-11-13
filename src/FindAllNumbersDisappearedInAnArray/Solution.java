package FindAllNumbersDisappearedInAnArray;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.abs;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            int tagIdx = abs(nums[i]) - 1; // use abs to avoid negative values
            nums[tagIdx] = (-1)*abs(nums[tagIdx]); // use opposite number as a flag
        }
        for(int i =0; i < nums.length; i++) {
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
    }
}