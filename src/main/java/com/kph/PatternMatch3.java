package com.kph;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatch3 {

    public static void main(String[] args) {

        String[] inpstr = {
                "5",
                "Goodbye bye Bye bYe world world World",
                "Sam went went to To tO his business",
                "Reya is is the The best player in eye eye game",
                "in inthe",
                "Hello hello Ab aB"
        };

        try {
            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int rn = Integer.parseInt(inpstr[0]);
            System.out.println(rn);
            for (int i=1; i <= rn; i++) {
                System.out.println(reduceDup(inpstr[i]));
            }
        } catch(Exception ex) {
            System.out.println("IOException: " + ex.getMessage());
        }

    }

    private static String reduceDup(String inp) {
        //Pattern pattern = Pattern.compile(regstr, Pattern.CASE_INSENSITIVE);
        //Matcher m = pattern.matcher(inp);
        StringBuilder ret = new StringBuilder();
        String[] tk = inp.split(" ");
        ret.append(tk[0]);
        for (int i=1; i< tk.length; i++) {
            String prev = tk[i-1];
            //if (!tk[i].matches("(?!.*" + prev + ".*)")) {
            if (!tk[i].matches("(?i)" + prev)) {
            //if (!tk[i].equalsIgnoreCase(prev))  {
                ret.append(" ");
                ret.append(tk[i]);
            }
        }

        return ret.toString();
    }
}
