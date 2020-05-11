/*
Date - May 3, 2020

Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

-----------------------------------------------------------
Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true
 
Constraints: You may assume that both strings contain only lowercase letters.
-----------------------------------------------------------
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (magazine == null || ransomNote == null) {
            return false;
        }
        
        int[] dict = new int[26];
        
        char[] magazineChars = magazine.toCharArray();
        int magazineLen = magazine.length();
        for (int i=0; i<magazineLen; i++) {
            int position = magazineChars[i] - 'a';
            dict[position] = dict[position] + 1;
        }
        
        char[] ransomNoteChars = ransomNote.toCharArray();
        int ransomNoteLen = ransomNote.length();
        for (int i=0; i<ransomNoteLen; i++) {
            int position = ransomNoteChars[i] - 'a';
            dict[position] = dict[position] - 1;
        }
        
        for (int i=0; i<26; i++) {
            if (dict[i] < 0) {
                return false;
            }
        }
        
        
        return true;
    }

    public static void main(String[] args) {
    	System.out.println(canConstruct("a", "b"));
    }
}