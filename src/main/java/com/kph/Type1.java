package com.kph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Type1 {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int ln = Integer.parseInt(br.readLine());
            String inp=null;
            for (int i = 0; i < ln; i++) {
                inp = br.readLine();
                System.out.println(printTypeTest(inp));
            }
        } catch(IOException ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
    }

    public static String printTypeTest(String inp) {
        boolean pr = false;
        double dbv = Math.floor(Math.abs(Double.parseDouble(inp)));
        StringBuilder bf = new StringBuilder();
        // note inpuat are integer, so don't worry about the decimal part
        if (dbv <= Byte.MAX_VALUE) {
            bf.append("* byte\n");
            pr = true;
        }
        if (dbv <= Short.MAX_VALUE) {
            bf.append("* short\n");
            pr = true;
        }
        if (dbv <= Integer.MAX_VALUE) {
            bf.append("* int\n");
            pr = true;
        }

        if (dbv <= Long.MAX_VALUE) {
            bf.append("* long\n");
            pr = true;
        }

        if (pr) {
            return inp + " can be fitted in:" + bf.toString();
        } else {
            return inp + " can't be fitted in anywhere";
        }
    }
}
