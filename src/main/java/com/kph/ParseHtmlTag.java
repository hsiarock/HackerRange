package com.kph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseHtmlTag {

    public static String[] inp = {
        "6",
        "<h1>Nayeem loves counseling</h1>",
        "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>",
        "<Amee>safat codes like a ninja</amee>",
        "<SA premium>Imtiaz has a secret crash</SA premium>",
        "qqoNVOmJDG@6IBDZoEmk9337LswEL&TQnLCuR`04XD%1t{G)Jmi_iNEXKwp&<iBKMbDGtF4v@coLsF1_LqgTJ3cSp& 3a~I&Q(j0h_w~Vk(oBZCL#vhYY9%c><wkjkTvAuA8Zk}n_l7Si\"-pfm`M8YE3F}4`YQyChgC3uRbyTvu>bMUGux)5n7L={M}e^`0xlSm5ce}ehiE}CJ6y0KPd~~B~ak5$PTdPGv}QnXpw6n9V8wVCVaTRTgLKkeF</wkjkTvAuA8Zk}n_l7Si\"-pfm`M8YE3F}4`YQyChgC3uRbyTvu>haZQKlWPxlRqXXkKHo=FDofc6$_S-GWA&m0zT*D~uorf_nAF^ym*U&6hGAI)s<XshvNhnnNbeVDuxRcQAgTpWZ-kqIps-@@}Uwq0J3Z06Y5mZgB9><FbTSC#F104{py9Xl6s{yi-R~}k5Fv4i1kCgmBY7P=vVj-j48xUg8x9BCxl~Y><lyxRRMqnMBGj1_d7Qqh5Ebn7 aMb{Q0Dm){9~I0DTS8BZ7+bui~)rQ\"2Yb4f>EeZWvJvHIk</XshvNhnnNbeVDuxRcQAgTpWZ-kqIps-@@}Uwq0J3Z06Y5mZgB9><BkkZV631Pnj}#%TWhZn@Y><kXjDpTvLA^tnXYb`h+cA J2",
        "wRhDGQCG`r N4=cWqp4jF\"#I7#)jofKUYktmjH(\"s2nD4+NxsN)tpCf2U@78MsGNbEgSgR=6`\"y685~I(D-p&T2BnaJNa%S%y9pYMb_9v{PlScQ7R=~~xnSkpSd<orcsjzalN#eslhhH2d\"1MD)pzc*$tBG-mmI_*zW><xMphtS-F8MVM^u2n5tN2DthGw{KZ`y7)><ZpjQU2&UMjzwJwnV70-CiM}M-OvR%a)Vk3R}2><DqcnlvJJa7ZYYrX^M*BI^*A_-mm0 HT4i^syNtujpEE8M@><mpX{FWXe#$d`)QdqT#eBbH=EJOXc@cFhxpJg14#*G0 o-w9G++`GA9U><PbwFCKiY2D^jhX_l7fM}tsB6QKv{-truncated-}"
    };


    public static void main(String[]args){

        for (int i=1; i<inp.length; i++) {
            String[] ret = parseTag(inp[i]);
            if (ret != null && ret.length > 0) {
                for (String s : ret) {
                    System.out.println("Line count: " + i + " found extracted:" + s);

                }
            } else {
                System.out.println("None");
            }
        }
    }

    public static String[] parseTag(String inp) {
        inp = inp.replace("{", "\\{")
                .replace("}", "\\}")
                .replace(")", "\\)")
                .replace("(", "\\)")
                .replace("^", "\\^")
                .replace("#", "\\#");
        List<String> ret = new ArrayList<>();
        //(.+?) means any character between the two specified tags.
        String regstr = "(.+?)";
        // parse to find all <xxxx
        String tagReg = "<([^\\/].*?)>";
        Pattern pattern = Pattern.compile(tagReg);
        Matcher m = pattern.matcher(inp);
        //String searchInp = inp;
        while (m.find()) {
            String extractedStr = m.group(1);

            String mytagrex = "<" + extractedStr + ">" + regstr + "</" + extractedStr +">";
            String extractedVal = extractPattern(mytagrex, inp);
            //System.out.println("Found extracted tag " + mytagrex + " value :" + extractedVal);
            if (extractedVal != null && !extractedVal.contains("<")) {
                ret.add(extractedVal);
            }
            //int matchlen = Math.min(extractedStr.length(), 5);
            int idx = inp.indexOf(extractedStr);
            inp = inp.substring(idx + extractedStr.length() );
        }

        return ret.toArray(new String[0]);
    }

    public static String extractPattern(String regxStr, String inp) {
        //System.out.println("matching pattern:" + regxStr + " with value: " + inp);
        //Pattern pattern = Pattern.compile(regxStr, Pattern.LITERAL);
        Pattern pattern = Pattern.compile(regxStr);
        Matcher m = pattern.matcher(inp);
        String ret = null;
        if (m.find()) {
            ret = m.group(1);
            //System.out.println("Found the extracted pattern:" + ret);
            if (ret != null && ret.matches("<.*>")) {
                return null;
            }
        }
        return ret;
    }
}
