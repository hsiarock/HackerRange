package com.kph;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;

public class Dequeue {

    public static void main(String[] args) {
        try {
            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            //String[] inpStr = br.readLine().split(" ");
            int n = 6;
            int m =3;
            String[] valarry = { "5", "3", "5", "2", "3", "2"};

            HashSet<Integer> ipn = new HashSet<>();
            for (int i=0; i< m; i++) { // found the 1st group from beginnine
                ipn.add(Integer.parseInt(valarry[i]));
            }
            int maxn = ipn.size();
            for (int i=1; i< n-m; i++) { // check from 2nd group
                ipn.clear();
                for (int j=0; j< m; j++) { // found the 1st group from beginnine
                    ipn.add(Integer.parseInt(valarry[i+j]));
                }
                maxn = (maxn < ipn.size()) ? ipn.size(): maxn;
            }

            System.out.println(maxn);

        } catch(Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
}
