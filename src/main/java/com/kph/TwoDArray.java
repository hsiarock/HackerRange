package com.kph;

import java.util.HashMap;

public class TwoDArray {

    public static void main(String[] args) {

        String[] inpStr = new String[]{ "3", "0", "0", "0", "0", "0", "0", "0"
//                "5",   //num of input lines
//                "5 41 77 74 22 44", //
//                "1 12",
//                "4 37 34 36 52",
//                "0",
//                "3 20 22 33",
//                "5",    // num of query line
//                "1 3",  // return above 2D array[1][3] value
//                "3 4",
//                "3 1",
//                "4 3",
//                "5 5"
        };
        HashMap<Integer, String> mtx = new HashMap<>();
        int ln = Integer.parseInt(inpStr[0]);
        int i = 1;
        for (i = 1 ; i <= ln; i++) {
            //String[] inp = br.readLine().split(" ");
            String[] inp = inpStr[i].split(" ");
            if (inp == null) break; // exit with bad input line
            int fnum = Integer.parseInt(inp[0]); // field num
            for (int j = 1; j <= fnum; j++) {
                mtx.put(i * 10 + j, inp[j]); // autobox key as Integer?
            }
        }

       // int qln = Integer.parseInt(br.readLine()); // read in query num
        int qln = Integer.parseInt(inpStr[i]);
        int k = 0 ;
        for (k=0; k<qln; k++) {
            //String[] qlnp = br.readLine().split(" ");
            String[] qlnp = inpStr[k + i + 1].split(" ");
            int ky = Integer.parseInt(qlnp[0] + qlnp[1]);
            String val = mtx.get(ky);
            if (val != null) {
                System.out.println(val);
            } else {
                System.out.println("ERROR!");
            }
        }

    }
}
