/*
Date - May 6, 2020

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

-----------------------------------------------------------
Example 1:
Input: [3,2,3]
Output: 3

Example 2:
Input: [2,2,1,1,1,2,2]
Output: 2
-----------------------------------------------------------
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int ansElement = -1;
        int ansValue = -1;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            int currentValue = 1;
            if (map.containsKey(num)) {
                currentValue = map.get(num) + 1;
            }
            map.put(num, currentValue);
            if (currentValue > ansValue) {
                ansValue = currentValue;
                ansElement = num;
            }
        }
        
        return ansElement;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {3,2,3}));
    }
}