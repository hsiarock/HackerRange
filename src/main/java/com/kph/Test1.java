package com.kph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Test1 {
    public List<String> solve(List<String> A, List<String> B) {
        ArrayList<String> output = new ArrayList<>();
        int al = A.toArray().length;
        int bl = B.toArray().length;
        int rl = (al >= bl) ? al : bl ;

        for(int i = 0; i < rl; i++) {
            if ( i > al || i > bl) {
                output.add("false");
                continue;
            }
            if (calWeight(A.get(i)) == calWeight(B.get(i))) {
                output.add("true");
            } else {
                output.add("false");
            }
        }

        return output;

    }

    public int calWeight(String lstr) {
        byte[] myw = lstr.getBytes();

        int ret = 0;

        for(int i=0; i < myw.length; i++) {
            ret += myw[i] - 'a';
        }

        return ret;
    }

    public static HashSet<String> findTwoSum(int[] list, int sum) {

        HashSet<String> ret = new HashSet<>();;
        int n1 = 0;

        for (int i=0; i<list.length; i++) {
            n1 = list[i];
            for (int j=i+1; j < list.length; j++) {
                if ( (sum - n1) == list[j]) {
                    ret.add(n1 + "+" + list[j]);
                }
            }
        }
        return ret;
    }

}
