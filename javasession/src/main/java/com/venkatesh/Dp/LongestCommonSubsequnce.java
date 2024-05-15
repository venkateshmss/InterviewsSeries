package com.venkatesh.Dp;

import java.util.Arrays;

public class LongestCommonSubsequnce {
    public static void main(String[] args) {
        String s1 = "adebc";
        String s2 = "dcadb";
        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(findLcs(s1, s2, s1.length() - 1, s2.length() - 1, dp));
        System.out.println(Arrays.deepToString(dp));

    }

    private static int findLcs(String s1, String s2, int ind1, int ind2, int[][] dp) {
        if (ind1 == 0 || ind2 == 0) {
            if (s1.charAt(ind1) == s2.charAt(ind2)) {
                return 1;
            }
            return 0;
        }

        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }

        int res = 0;
        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            res = 1 + findLcs(s1, s2, ind1 - 1, ind2 - 1, dp);
        } else {

            res = Math.max(findLcs(s1, s2, ind1 - 1, ind2, dp), findLcs(s1, s2, ind1, ind2 - 1, dp));
        }
        dp[ind1][ind2] = res;
        return dp[ind1][ind2];
    }

}
