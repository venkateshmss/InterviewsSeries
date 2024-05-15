package com.venkatesh.Dp;

import java.util.Arrays;

public class SubsetSum {
    static int count = 0;

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3 };
        int target = 3;
        int[][] dp = new int[arr.length][target + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(findSubSetSum(arr, arr.length - 1, target, dp));
        System.out.println(count);
        // System.out.println(Arrays.deepToString(dp));
    }

    private static boolean findSubSetSum(int[] arr, int n, int target, int[][] dp) {
        if (target == 0) {
            return true;
        }
        if (n == 0) {
            return target == arr[0];
        }
        if (dp[n][target] != -1) {
            if (dp[n][target] == 1) {
                return true;
            }
            return false;
        }
        boolean notPick = findSubSetSum(arr, n - 1, target, dp);
        boolean pick = false;
        if (target >= arr[n]) {
            pick = findSubSetSum(arr, n - 1, target - arr[n], dp);
        }
        if (notPick || pick) {
            count += 1;
            dp[n][target] = 1;
        }
        return notPick || pick;
    }
}
