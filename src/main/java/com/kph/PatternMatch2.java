package com.kph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class PatternMatch2 {

    public static void main(String[] args) {

        String regexStr = "(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)";
        String[] ilines = {
            "12.12.12.12",
            "13.13.13.112",
            "VUUT.12.12",
            "111.111.11.111",
            "1.1.1.1.1.1.1",
            ".....",
            "1...1..1..1",
            "0.0.0.0",
            "255.0.255.0",
            "266.266.266.266",
            "00000.000000.0000000.00001",
            "0023.0012.0012.0034" };

        MyRegex myRegex = new MyRegex();
        try {

            for (String s: ilines) {
                System.out.println(myRegex.isValidIpAddress(s));
            }

        } catch (Exception ex) {
            System.out.println("exception: " + ex.getMessage());
        }

    }
}
class MyRegex {

    private final String ptnstr = "(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)";
    Pattern pattern = null;

    public MyRegex() {
        pattern = Pattern.compile(ptnstr);
    }

    public boolean isValidIpAddress(String inpstr) {

        boolean cc = false;
        try {
            if (inpstr.matches(ptnstr)) {
                Matcher m = pattern.matcher(inpstr);
                if (m.find()) {
                    for (int i = 1; i <= 4; i++) {
                        System.out.printf("find(%d) : %s\n", i, m.group(i));
//                        System.out.println("startsWith : " + "-" + m.group(i).startsWith("0"));
//                        System.out.println("parseInt() : " + "-" + (Integer.parseInt(m.group(i)) > 255));

                        int myv = Integer.parseInt(m.group(i));
                        if ((m.group(i).startsWith("00") && myv != 0) || myv > 255) {
                            cc = false;
                            break;
                        } else {
                            cc = true;
                        }
                    }
                }
            } else {
                cc = false;
            }
        } catch (Exception ex) {
            System.out.println(" IsvalidIpAddress return exception: " + ex.getMessage());
        }

        return cc;
    }
}
