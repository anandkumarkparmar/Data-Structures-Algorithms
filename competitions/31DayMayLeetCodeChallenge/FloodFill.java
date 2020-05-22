/*
Date - May 11, 2020

An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.
-----------------------------------------------------------
Example:
Input: image = [[1,1,1],[1,1,0],[1,0,1]] sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]

Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.

Note:
The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
-----------------------------------------------------------
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        
        return floodFillUtil(image, sr, sc, image.length, image[0].length, image[sr][sc], newColor);
    }
    
    private static int[][] floodFillUtil(int[][] image, int sr, int sc, int rows, int columns, int oldColor, int newColor) {
        if (sr < rows && sr > -1 && sc < columns && sc > -1 && image[sr][sc] == oldColor) {
            image[sr][sc] = newColor;
            image = floodFillUtil(image, sr + 1, sc, rows, columns, oldColor, newColor);
            image = floodFillUtil(image, sr - 1, sc, rows, columns, oldColor, newColor);
            image = floodFillUtil(image, sr, sc + 1, rows, columns, oldColor, newColor);
            image = floodFillUtil(image, sr, sc - 1, rows, columns, oldColor, newColor);
            return image;
        } 
        return image;
    }

    public static void main(String[] args) {
    	int[][] image = {{1,1,1}, {1,1,0}, {1,0,1}};
    	int[][] finalImage = floodFill(image, 1, 1, 2);

    	for (int row = 0; row < finalImage.length; row++) {
    		for (int col = 0; col < finalImage[0].length; col++) {
    			System.out.print(finalImage[row][col] + " ");
    		}
    		System.out.println();
    	}
    }
}