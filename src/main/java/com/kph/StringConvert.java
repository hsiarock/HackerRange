package com.kph;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.pow;

public class StringConvert {

    public static void main(String[] args) {

        Integer biii = 10; // autobox
        System.out.println(biii);

        // ---- reverse String
        System.out.println("\n---- String palindrome (reserved) checking");
        String s1 = "abcdcba";

        StringBuilder s1bd = new StringBuilder(s1);
        StringBuilder s2bd = s1bd.reverse();
        if (s1bd.toString().equals(s2bd.toString())) {
            System.out.println("String: " + s1 + " is a palindrome" + " reverse: " + s2bd.toString());
        } else {
            System.out.println("String: " + s1 + " is NOT a palindrome"+ " reverse: " + s2bd.toString());
        }

        // Test from Glider
        List<String> A = Arrays.asList("abic", "ialkl", "oidlsd");
        List<String> B = Arrays.asList("baic", "ialkle", "dsoidl");

        Test1 test1 = new Test1();
        System.out.println(test1.solve(A, B));

        String[] names1 = new String[]{"Ava", "Emma", "Olivia"};
        String[] names2 = new String[]{"Olivia", "Sophia", "Emma"};

        System.out.println(" ----- print from HasSet ----------");
        String[] uniqList = uniqueNames(names1, names2);
        for (String s : uniqList) {
            System.out.print(" -" + s);
        }

        System.out.println("\n ----- Collections.reverse ----------");
        Collections.reverse(Arrays.asList(uniqList));
        //Collections.sort(uniqList); // need List<>
        for (String s : uniqList) {
            System.out.print(" -" + s);
        }
        System.out.println("\n -----Arrays.sort(a) ----------");
        Arrays.sort(uniqList);
        for (String s : uniqList) {
            System.out.print(" -" + s);
        }

        System.out.println("\n ----- Arrays.sort(a, Collections.reverseOrder) ----------");
        Arrays.sort(uniqList, Collections.reverseOrder());
        for (String s : uniqList) {
            System.out.print(" -" + s);
        }

        String regxstr = "[ !,?._'@]";
        String[] words = "the test str,ing, isn't ok?".split(regxstr);
        //if (pattern.matches(words, regxstr)) {
        System.out.println("\nTest the split function:" + words);

        List<String> outw = Stream.of(words)
                .filter(s -> s.length() != 0)
                .collect(Collectors.toList());

        System.out.println(outw.size() );
        for (String s: outw) {
            System.out.println(s);
        }

        System.out.println("----------------\nprint serial formular");

        int qn = 1;
        String t1 = "0 2 10";
        String[] t1arry = t1.replaceAll("\\s+$", "").split(" ");

        for (int i=0; i< qn; i++) {
            String[] parameters = t1.split(" ");
            int a = Integer.parseInt(parameters[0]);
            int b = Integer.parseInt(parameters[1]);
            int n = Integer.parseInt(parameters[2]); // exception if not existing
            if ( a < 0 || a > 50 || b < 0 || b > 50 || n < 1 || n > 15) {
                System.out.println("Error input parameter number");
                return;
            }

            int kv = a;
            for (int ql=0; ql<n; ql++) {
                //System.out.printf("%d + %d * %d = ", a,b, tn);
                kv += (int) pow(2.0, (double) ql) * b;
                System.out.println(kv + " ");
            }
            System.out.println();

            return;

            //System.out.println("SHould be ingored by compilere");
    }

    }



    public static String[] uniqueNames(String[] names1, String[] names2) {

        HashSet<String> nout = new HashSet<>();
        for (String n1: names1){
            nout.add(n1);
        }
        for(String n2: names2) {
            nout.add(n2);
        }
        String[] out = nout.toArray(new String[0]);
//        String[] out = new String[nout.size()];
//        int i =0 ;
//        for (String str : nout) {
//            //System.out.println("got name" + str);
//            out[i++] = str;
//        }

        return out;
    }

}
