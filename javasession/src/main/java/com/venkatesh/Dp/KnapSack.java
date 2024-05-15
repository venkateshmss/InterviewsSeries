package com.venkatesh.Dp;

import java.util.Arrays;

public class KnapSack {
    public static void main(String[] args) {
        int[] wt = { 2, 5, 4 };
        int[] val = { 30, 20, 60 };
        int[][] dp = new int[wt.length][7];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(findMaxVal(wt, val, wt.length - 1, 6, dp));
        System.out.println(Arrays.deepToString(dp));

    }

    private static int findMaxVal(int[] W, int[] val, int ind, int wt, int[][] dp) {
        if (ind == 0) {
            if (wt >= W[0]) {
                return val[0];
            }
            return 0;
        }
        if (dp[ind][wt] != -1) {
            return dp[ind][wt];
        }

        int notPick = 0 + findMaxVal(W, val, ind - 1, wt, dp);
        int pick = Integer.MIN_VALUE;
        if (wt >= W[ind]) {
            pick = val[ind] + findMaxVal(W, val, ind - 1, wt - W[ind], dp);
        }
        dp[ind][wt] = Math.max(pick, notPick);
        return dp[ind][wt];
    }
}
