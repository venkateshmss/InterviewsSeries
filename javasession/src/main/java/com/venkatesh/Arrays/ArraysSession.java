package com.venkatesh.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraysSession {

    public static void main(String[] args) {

        // int[] a = { 1, 1, 2, 3, 4, 5 };
        // int[] b = { 2, 3, 4, 4, 5, 6 };

        // System.out.println(findUnion(a, b));

        int[] arr = { 1, 2, 3, 1, 1, 1, 1, 4, 2, 3 };
        System.out.println(findMaxLength(arr, 3));
    }

    private static int findMaxLength(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLength = i + 1;
            }
            if (map.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - (map.get(sum - k)));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLength;
    }

    private static List<Integer> findUnion(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();
        int aPointer = 0, bPointer = 0;
        while (aPointer < a.length && bPointer < b.length) {
            if (a[aPointer] < b[bPointer]) {
                if (result.isEmpty() || result.get(result.size() - 1) != a[aPointer]) {
                    result.add(a[aPointer]);
                }
                aPointer += 1;
            } else {
                if (result.isEmpty() || result.get(result.size() - 1) != b[bPointer]) {
                    result.add(b[bPointer]);
                }
                bPointer += 1;
            }
        }

        while (aPointer < a.length) {
            result.add(a[aPointer++]);
        }

        while (bPointer < b.length) {
            result.add(b[bPointer++]);
        }
        return result;
    }

}
