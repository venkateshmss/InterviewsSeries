package com.venkatesh.Dp;

import java.util.Arrays;

public class TriangleSum {
    public static void main(String[] args) {
        int[][] triangle = {
                { 1 },
                { 2, 3 },
                { 3, 6, 7 },
                { 8, 9, 1, 10 }
        };
        int[][] dp = new int[triangle.length][triangle.length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(findMinSum(triangle, 0, 0, dp));
        int maxSum = Integer.MIN_VALUE;
        int[][] square = {
                { 1, 2, 10, 4 },
                { 100, 3, 2, 1 },
                { 1, 1, 20, 2 },
                { 1, 2, 2, 1 }
        };
       

    }

    private static int findMinSum(int[][] triangle, int i, int j, int[][] dp) {
        if (i == triangle.length - 1) {
            return triangle[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int down = triangle[i][j] + findMinSum(triangle, i + 1, j, dp);
        int downPlusOne = triangle[i][j] + findMinSum(triangle, i + 1, j + 1, dp);
        dp[i][j] = Math.min(down, downPlusOne);
        return dp[i][j];
    }
}
