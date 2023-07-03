package com.kph;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class BigDecimalDemo {

    public static void main(String[] args) {

        String[] inpStr = {
                "9",
                "-100",
                "50",
                "0",
                "56.6",
                "90",
                "0.12",
                ".12",
                "02.34",
                "000.000"};

        try {
            List<String> bd = new ArrayList<>();
            int n = Integer.parseInt(inpStr[0]);
            for (int i=1; i<= n; i++) {
                bd.add(inpStr[i]);
            }

            //Arrays.sort(bd, 0, n, new BigDecimalComparator());
            Collections.sort(bd, new BigDecimalComparator());

            for (String b: bd) {
                System.out.println(b);
            }
        } catch(Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

        BigInteger a = new BigInteger("102390393");
        System.out.println("add: " + a.add(new BigInteger("2344")));
        System.out.println("mulitply: " + a.multiply(new BigInteger("2344")));

    }

}
class BigDecimalComparator implements Comparator<String> {

    @Override
    public int compare(String a, String b) {
        int ret = new BigDecimal(a).compareTo(new BigDecimal(b)) ;
        // keep the inserted order, don't do compareTo(Str1, Str2)
        //if (ret == 0) {
        //    ret = a.compareTo(b) ;
        //}
        return ret * (-1);
    }
}