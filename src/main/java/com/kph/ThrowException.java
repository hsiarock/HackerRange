package com.kph;

import java.math.BigInteger;

public class ThrowException {
    public static void main(String[] args) {
        int b = 3;
        int h = -9;
        try {
            if (b < 0 || h < 0) {
                throw new Exception("Breadth and heigth must be poistive");
            } else {
                System.out.println("Area is : " + b * h);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        BigInteger bn = new BigInteger("9384938");

        if (bn.isProbablePrime(10)) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }


    }
}
