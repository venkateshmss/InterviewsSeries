package com.venkatesh.Reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NewMains {
    public static void main(String[] args) {

        // List<Integer> list = List.of(5, 3, 2, 7, 4, 9);
        // List<Integer> mutableList = new ArrayList<>();
        // System.out.println(list);
        // mutableList.addAll(list);
        // Collections.sort(mutableList);
        // System.out.println(mutableList);

        // Map<Integer, Integer> map = new HashMap<>();
        // AsecdingComparator asc = new AsecdingComparator(map);
        // Map<Integer, Integer> customMap = new TreeMap<Integer, Integer>(asc);
        // map.put(5, 3);
        // map.put(6, 1);
        // map.put(2, 5);
        // map.put(4, 6);
        // map.put(7, 4);
        // map.put(8, 5);
        // map.put(1, 5);

        // System.out.println(map);
        // customMap.putAll(map);
        // System.out.println(customMap);

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(4);
        List<Integer> newList = new ArrayList<>(list);
        System.out.println(list);
        System.out.println(modifyList(list, 3, 3));

        System.out.println(newList);
        System.out.println(anotherWay(newList, 3, 2));
    }

    private static List<Integer> modifyList(List<Integer> sourceList, int value, int position) {

        position = position - 1;
        if (position < 0 || position > sourceList.size()) {
            throw new ArrayIndexOutOfBoundsException(String.format("'%s' position is invalid", position));
        }
        if (position == sourceList.size()) {
            sourceList.add(value);
            return sourceList;
        }
        int temp = 0;
        int n = sourceList.size();
        for (int i = position; i <= n; i++) {
            if (i < n) {
                temp = sourceList.get(i);
                sourceList.set(i, value);
            } else {
                sourceList.add(value);
            }
            value = temp;
        }
        return sourceList;
    }

    private static List<Integer> anotherWay(List<Integer> list, int value, int position) {

        list.add(position, value);
        return list;
    }

}

class AsecdingComparator implements Comparator<Integer> {

    Map<Integer, Integer> map;

    public AsecdingComparator(Map<Integer, Integer> map) {
        this.map = map;
    }

    @Override
    public int compare(Integer arg0, Integer arg1) {
        if (map.get(arg1) > map.get(arg0)) {
            return -1;
        } else {
            return 1;
        }
    }

}
