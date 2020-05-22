/*
Date - May 13, 2020

Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.

-----------------------------------------------------------
Example 1:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
-----------------------------------------------------------
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class RemoveKDigits {

    public static String removeKdigits(String num, int k) {
        int len = num.length();
        if (k == len) {
            return "0";
        } else if (k == 0) {
            return num;
        }
        
        num = getKDeletedNumber(num, k);
        return getNumberWithoutLeadingZeros(num);
    }
    
    private static String getKDeletedNumber(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        for (; index < num.length(); index++) {
            char c = num.charAt(index);
            while (!stack.empty() && stack.peek() > c && k > 0) {
                stack.pop();
                k--;        
            }
            
            if (k <= 0) {
                break;
            }
            stack.push(c);
        }
        
        String subString = num.substring(index, num.length());
        while (!stack.empty()) {
            if (k > 0) {
                stack.pop();
                k--;   
            } else {
                subString = stack.pop() + subString;
            }
        }
        
        return subString;
    }
    
    private static String getNumberWithoutLeadingZeros(String num) {
        int lastLeadingZeroIndex = -1;
        for(int index = 0; index < num.length(); index++) {
            if (num.charAt(index) == '0') {
                lastLeadingZeroIndex = index;
            } else {
                break;
            }
        }
        
        if (lastLeadingZeroIndex == -1) {
            return num;
        } else if (lastLeadingZeroIndex == num.length() - 1) {
            return "0";
        } else {
            return num.substring(lastLeadingZeroIndex + 1, num.length());
        }
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
        System.out.println(removeKdigits("10200", 1));
        System.out.println(removeKdigits("10", 2));
    }
}