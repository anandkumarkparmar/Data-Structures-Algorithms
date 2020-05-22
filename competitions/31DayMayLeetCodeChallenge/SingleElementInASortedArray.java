/*
Date - May 12, 2020

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

Follow up: Your solution should run in O(log n) time and O(1) space.

-----------------------------------------------------------
Example 1:
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:
Input: nums = [3,3,7,7,10,11,11]
Output: 10
 

Constraints:
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5
-----------------------------------------------------------
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class SingleElementInASortedArray {

    public static int singleNonDuplicate(int[] nums) {
        int result = nums[0];
        
        for (int i = 1; i<nums.length; i++) {
            if (i%2 == 1) {
                if (result != nums[i]) {
                    return result;
                }
            } else {
                result = nums[i];
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
    	int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }
}