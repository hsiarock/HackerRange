package com.kph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ArrayHourglass {

    public static void main(String[] args) throws IOException {
/*** input data
-1 -1 0 -9 -2 -2
-2 -1 -6 -8 -2 -5
-1 -1 -1 -2 -3 -4
-1 -9 -2 -4 -4 -5
-7 -3 -3 -2 -9 -9
-1 -3 -1 -2 -4 -5
****/
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int width = 3;
        try {
            for (int i = 0; i < 6; i++) {

                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            }
            for (int k = 0; k <= 6 - width; k++) {
                for (int j = 0; j <= arr.get(k).size() - width; j++) {
                    List<Integer> ln1 = arr.get(k);
                    List<Integer> ln2 = arr.get(k + 1);
                    List<Integer> ln3 = arr.get(k + 2);
                    int myval = ln1.get(j) + ln1.get(j + 1) + ln1.get(j + 2) +
                            ln2.get(j + 1) +
                            ln3.get(j) + ln3.get(j + 1) + ln3.get(j + 2);
                    System.out.printf("cal: %d with %d val: %d: %d+%d+%d-%d-%d+%d+%d\n", k, j, myval,
                            ln1.get(j), ln1.get(j + 1),
                            ln1.get(j + 2), ln2.get(j + 1),
                            ln3.get(j), ln3.get(j + 1), ln3.get(j + 2));

                    if (myval > max) max = myval;
                }
            }



        } catch (IOException ex) {
                throw new RuntimeException(ex);
        }
        bufferedReader.close();
        System.out.println(max);
    }
}
