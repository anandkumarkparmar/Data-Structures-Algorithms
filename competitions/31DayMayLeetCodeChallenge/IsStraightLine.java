/*
Date - May 8, 2020

You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.


-----------------------------------------------------------
Example:
Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true

Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false

Constraints:
2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.
-----------------------------------------------------------
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class IsStraightLine {

    public static boolean checkStraightLine(int[][] coordinates) {
        int len = coordinates.length;
        double slope = (coordinates[1][1] - coordinates[0][1]) / ((coordinates[1][0] - coordinates[0][0]) * 1.00); 
        int[] lastCoordinate = coordinates[1];
        //System.out.println("slop - " + slope);
        for (int i=2; i<len; i++) {
            double slopeCurrent = (coordinates[i][1] - lastCoordinate[1]) / ((coordinates[i][0] - lastCoordinate[0])*1.00); 
            //System.out.println("slop - " + slopeCurrent);
            if (slopeCurrent != slope) {
                return false;
            }
            lastCoordinate = coordinates[i];
        }
        
        return true;
    }

    public static void main(String[] args) {
    	int[][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        System.out.println(checkStraightLine(coordinates));
    }
}