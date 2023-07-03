package com.kph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generic {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Integer[] nums = { 1, 2, 3};
        List<Integer> inp = Arrays.asList(nums);
        printArray(inp);

        List<String> ins = Arrays.asList("Hello", "World");
        printArray(ins);

    }

    public static <T> void printArray(List<T> inp) {

        for (T t: inp) {
            System.out.println(t);
        }
    }
}
