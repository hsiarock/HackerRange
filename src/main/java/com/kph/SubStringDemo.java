package com.kph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubStringDemo {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String s = br.readLine();
            int k = Integer.parseInt(br.readLine());
            System.out.println(getSmallestAndLargest(s, k));

        } catch(IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
    }

    public static String getSmallestAndLargest(String s, int k) {
        List<String> inpstr = new ArrayList<>();
        int cnt = 0;
        for (int i=0; i<= s.length()-k; i++) {
            inpstr.add(s.substring(i,i+k));
            cnt++;
        }

        //Arrays.sort(inpstr);  --> use for String[]
        Collections.sort(inpstr);

        return inpstr.get(0) + "\n" + inpstr.get(cnt-1);
    }


}
