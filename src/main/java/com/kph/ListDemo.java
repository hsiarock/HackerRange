package com.kph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {

        String[] inpstr = {
                "5",
                "12 0 1 78 12",
                "2",
                "Insert",
                "5 23",
                "Delete",
                "0"
        };

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try {
            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(inpstr[0]);
            List<String> inplist = Arrays.asList(inpstr[1].split(" "));
            ArrayList<String> inpn = new ArrayList<String>(inplist);
            int qn = Integer.parseInt(inpstr[2]);
            for (int i=0; i<qn; i++) {
                String qstr = inpstr[3+i*2];
                if (qstr.equals("Insert")) {
                    String[] insertq = inpstr[4+i].split(" ");
                    int idx = Integer.parseInt(insertq[0]);
                    inpn.add(idx, insertq[1]);
                } else {
                    if (qstr.equals("Delete")) {
                        inpn.remove(Integer.parseInt(inpstr[4+i*2])); // don't forget just as 2 elements
                    }
                }
            }

            for (String s: inpn) {
                System.out.print(s + " ");
            }

        } catch(Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
}
