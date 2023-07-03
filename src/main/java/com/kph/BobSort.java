package com.kph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BobSort {

    public static void main(String[] args) {

        //List<String> inp = (ArrayList<String>)Arrays.asList( "2", "12", "3", "9", "11", "8", "1" );
        int[] inp = {2, 12, 3, 9, 11, 8, 1 };
        Arrays.sort(inp);
        System.out.println("Use Arrays.sort()");
        Arrays.stream(inp)
                .forEach(System.out::println);

        //String[] inpStr = new String[]{"2", "12", "3", "9", "11", "8", "1" };
        int[] inp2 = {2, 12, 3, 9, 11, 8, 1 };
        //Arrays.stream(inpStr)
        System.out.println("Sort by for loop and comparator()");
        for (int i=0; i < inp2.length; i++) {
            boolean swapped = false;
            for (int j=0; j < inp2.length - i -1; j++) {
                        if (inp2[j] < inp2[j+1]) {
                            // swap j and j+1
                            int temp = inp2[j+1];
                            inp2[j+1] = inp2[j];
                            inp2[j] = temp;
                            swapped = true;
                        }
            };
            if (swapped == false)
                break; // sorted!
        }
        Arrays.stream(inp)
            .forEach(System.out::println);
    }
}
