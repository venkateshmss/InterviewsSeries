package com.venkatesh.Dp;

import java.util.Arrays;

public class DynamicProgramming {
    public static void main(String[] args) {
        // int n = 30;
        // long[] dp = new long[n + 1];
        // Arrays.fill(dp, -1);
        // System.out.println(findFib(n, dp));
        // // System.out.println(Arrays.toString(dp));
        // System.out.println(findFibTab(n));

        int[] num = { 1, 2, 4, 9 };
        System.out.println(maxAdjSum(num, num.length - 1));
    }

    private static int maxAdjSum(int[] num, int n) {
        if (n == 0) {
            return num[0];
        }
        if (n < 0) {
            return 0;
        }
        int notPick = 0 + maxAdjSum(num, n - 1);
        int pick = num[n] + maxAdjSum(num, n - 2);
        return Math.max(pick, notPick);
    }

    private static long findFib(int n, long[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = findFib(n - 1, dp) + findFib(n - 2, dp);
        return dp[n];
    }

    private static int findFibTab(int n) {
        if (n <= 1) {
            return n;
        }
        int prev = 1;
        int prevPrev = 0;
        int cur = 0;
        for (int i = 2; i <= n; i++) {
            cur = prev + prevPrev;
            prevPrev = prev;
            prev = cur;
        }
        return cur;

    }
}
