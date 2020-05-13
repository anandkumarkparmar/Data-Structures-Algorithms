/*
Date - May 5, 2020

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

-----------------------------------------------------------
Example:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters.
-----------------------------------------------------------
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class FirstUniqueCharacter {

    public static int firstUniqChar(String s) {
        int[] minIndex = new int[26];
        int len = s.length();
        for (int i=0; i<len; i++) {
            int c = s.charAt(i) - 'a';
            if (minIndex[c] == 0) {
                minIndex[c] = i+1;
            } else {
                minIndex[c] = -1;
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i=0; i<26; i++) {
            int index = minIndex[i];
            if (index > 0 && answer > index) {
                answer = index;
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer - 1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
}