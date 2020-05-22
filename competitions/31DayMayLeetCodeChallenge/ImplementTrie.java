/*
Date - May 14, 2020

Implement a trie with insert, search, and startsWith methods.

-----------------------------------------------------------
Example:

Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true

Note:
You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
-----------------------------------------------------------
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class ImplementTrie {

    Node head;
    
    class Node {
        Node[] nodes;
        boolean isWordEnd;
        
        public Node () {
            nodes = new Node[26];
            isWordEnd = false;
        }
    }
    
    /** Initialize your data structure here. */
    public ImplementTrie() {
        head = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }
        
        Node tempNode = head;
        int len = word.length();
        for (int index = 0; index < len; index++) {
            int position = word.charAt(index) - 'a';
            boolean isWordEnd = (index == len - 1);
            if (tempNode.nodes[position] == null) {
                tempNode.nodes[position] = new Node();
                tempNode.nodes[position].isWordEnd = isWordEnd;
                tempNode = tempNode.nodes[position];
            } else {
                if (isWordEnd) {
                    tempNode.nodes[position].isWordEnd = isWordEnd;
                }
                tempNode = tempNode.nodes[position];
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        
        Node tempNode = head;
        int len = word.length();
        for (int index = 0; index < len; index++) {
            int position = word.charAt(index) - 'a';
            boolean isWordEnd = (index == len - 1);
            if (tempNode.nodes[position] == null) {
                return false;
            } else {
                if (isWordEnd) {
                    if (tempNode.nodes[position].isWordEnd == true) {
                        return true;
                    } else {
                        return false;
                    }
                }
                tempNode = tempNode.nodes[position];
            }
        }
        
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            return false;
        }
        
        Node tempNode = head;
        int len = prefix.length();
        for (int index = 0; index < len; index++) {
            int position = prefix.charAt(index) - 'a';
            boolean isWordEnd = (index == len - 1);
            if (tempNode.nodes[position] == null) {
                return false;
            } else {
                if (isWordEnd) {
                    return true;
                }
                tempNode = tempNode.nodes[position];
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
    	ImplementTrie trie = new ImplementTrie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));   // returns true
		System.out.println(trie.search("app"));     // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");   
		System.out.println(trie.search("app"));     // returns true
    }
}