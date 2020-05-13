/*
Date - May 7, 2020

In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

-----------------------------------------------------------
Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false

Note:
The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
-----------------------------------------------------------
*/

import java.util.*;
import java.lang.*;
import java.io.*;
import javafx.util.*;

public class CousinsInBinaryTree {

    public static boolean isCousins(TreeNode root, int x, int y) {
        Pair<Integer, Integer> pairX = depthOfNumber(root, x, -1, 0);
        Pair<Integer, Integer> pairY = depthOfNumber(root, y, -1, 0);
        
        if (pairX != null && pairY != null 
            && pairX.getKey() == pairY.getKey() && pairX.getValue() != pairY.getValue()) {
            return true;
        }
        return false;
    }
    
    public static Pair<Integer, Integer> depthOfNumber(TreeNode root, int n, int parent, int depth) {
        if (root == null) {
            return null;
        }
        
        if (root.val == n) {
            return new Pair<>(depth, parent);
        }
        
        Pair<Integer, Integer> pairLeft = depthOfNumber(root.left, n, root.val, depth+1);
        
        if (pairLeft != null) {
            return pairLeft;
        }
        return depthOfNumber(root.right, n, root.val, depth+1);
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);

        one.left = two;
        one.right = three;
        two.left = four;
        System.out.println(isCousins(one, 4, 3));
    }

	public static class TreeNode {
 		int val;
 		TreeNode left;
 		TreeNode right;
 		TreeNode(int val) { this.val = val; }
 	}
}