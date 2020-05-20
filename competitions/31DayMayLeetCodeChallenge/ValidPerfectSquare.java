/*
Date - May 9, 2020

Given a positive integer num, write a function which returns True if num is a perfect square else False.
Follow up: Do not use any built-in library function such as sqrt.
-----------------------------------------------------------
Example 1:
Input: num = 16
Output: true

Example 2:
Input: num = 14
Output: false

Constraints:
1 <= num <= 2^31 - 1
-----------------------------------------------------------
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class ValidPerfectSquare {

    public static boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        
        for (int i=2; i<=num/2; i++) {
            int product = i*i;
            if (product == num) {
                return true;
            }
            
            if (product > num) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(14));
    }
}